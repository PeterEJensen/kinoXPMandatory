package com.example.kinoXP.Service;

import com.example.kinoXP.Controller.NewmovieController;
import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Domain.MovieShowing;
import com.example.kinoXP.Repository.MovieRepository;
import com.example.kinoXP.Repository.MovieShowingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class MovieServiceImpl implements MovieService{

    private Logger logger = Logger.getLogger(MovieServiceImpl.class.getName());

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieShowingsRepository movieShowingsRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void addMovieShowing(Movie movie, MovieShowing movieShowing) {

        movie.addMovieShowing(movieShowing);
        movieShowingsRepository.save(movieShowing);
    }

    @Override
    public Date createDateObject(String date, String time) {
        Calendar finalDate = Calendar.getInstance();

        String[] stringDateArray = date.split("-");
        int[] intDateArray = new int[stringDateArray.length];
        for (int i = 0; i < stringDateArray.length; i++) {
            intDateArray[i] = Integer.parseInt(stringDateArray[i]);
        }

        String[] stringTimeArray = time.split(":");
        int[] intTimeArray = new int[stringTimeArray.length];
        for (int i = 0; i < stringTimeArray.length; i++) {
            intTimeArray[i] = Integer.parseInt(stringTimeArray[i]);
        }

        logger.info("" + intDateArray[0] + " : " + intDateArray[1] + " : " + intDateArray[2] + " : " + intTimeArray[0] + " : " + intTimeArray[1]);


        finalDate.set(Calendar.YEAR, intDateArray[0]);
        //Da MONTH er nul baseret bliver vi nødt til at plusse med 1
        finalDate.set(Calendar.MONTH, intDateArray[1] - 1);
        finalDate.set(Calendar.DAY_OF_MONTH, intDateArray[2]);
        finalDate.set(Calendar.HOUR_OF_DAY, intTimeArray[0]);
        finalDate.set(Calendar.MINUTE, intTimeArray[1]);
        finalDate.set(Calendar.SECOND, 0);
        finalDate.set(Calendar.MILLISECOND, 0);

        return finalDate.getTime();
    }
}
