package com.example.kinoXP.Service;

import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Domain.MovieShowing;

import java.util.Date;

public interface MovieService  {

    void addMovie(Movie movie);
    void addMovieShowing(Movie movie, MovieShowing movieShowing);
    Date createDateObject(String date, String time);
}
