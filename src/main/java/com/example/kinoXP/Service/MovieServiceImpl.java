package com.example.kinoXP.Service;

import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
