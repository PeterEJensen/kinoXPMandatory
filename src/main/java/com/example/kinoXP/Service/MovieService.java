package com.example.kinoXP.Service;

import com.example.kinoXP.Domain.Movie;

import java.util.Date;

public interface MovieService  {

    void addMovie(Movie movie);
    Date createDateObject(String date, String time);
}
