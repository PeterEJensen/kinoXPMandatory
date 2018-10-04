package com.example.kinoXP.Service;

import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Domain.MovieShowing;

import java.util.Date;
import java.util.List;

public interface MovieService  {

    List<String> pictureArray();
    List<Movie> findAll();
    void addMovie(Movie movie);
    void addMovieShowing(Movie movie, MovieShowing movieShowing);
    Date createDateObject(String date, String time);
    Movie findMovieById(Long id);
    Movie findMovieByTitle(String title);
}
