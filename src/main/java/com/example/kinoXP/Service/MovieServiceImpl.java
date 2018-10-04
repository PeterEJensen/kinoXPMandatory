package com.example.kinoXP.Service;

import com.example.kinoXP.Controller.NewmovieController;
import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Domain.MovieShowing;
import com.example.kinoXP.Repository.MovieRepository;
import com.example.kinoXP.Repository.MovieShowingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MovieServiceImpl implements MovieService{




    private Logger logger = Logger.getLogger(MovieServiceImpl.class.getName());

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieShowingsRepository movieShowingsRepository;

    @Override
    public List<String> pictureArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("http://www.gstatic.com/tv/thumb/v22vodart/23514/p23514_v_v8_ab.jpg");
        arrayList.add("http://www.gstatic.com/tv/thumb/v22vodart/1587/p1587_v_v8_aa.jpg");
        arrayList.add("http://www.gstatic.com/tv/thumb/v22vodart/10998/p10998_v_v8_ah.jpg");
        arrayList.add("http://www.gstatic.com/tv/thumb/v22vodart/13013/p13013_v_v8_ac.jpg");
        arrayList.add("https://resizing.flixster.com/1euG0DUzyKp959yYjF4g4_3WSmw=/206x305/v1.bTsxMTI5MDIyNDtqOzE3OTA1OzEyMDA7MjQzOTszMjUy");
        return arrayList;

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

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

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }
}
