package com.example.kinoXP.Controller;

import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Domain.MovieShowing;
import com.example.kinoXP.Service.MovieService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.*;
import java.sql.Blob;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class NewmovieController {

    private Logger logger = Logger.getLogger(NewmovieController.class.getName());

    @Autowired
    MovieService movieService;

    @Autowired
    EntityManager entityManager;

    @GetMapping("/add")
    public String addmovieGet(Model model){
        model.addAttribute("movies",movieService.findAll());
        return "add";
    }

    @PostMapping("/add")
    public String addmoviePost(@RequestParam(value = "title", required = false)String title,
                               @RequestParam(value = "genre", required = false)String genre,
                               @RequestParam(value = "description", required = false)String description,
                               @RequestParam(value = "startDate")String startDate,
                               @RequestParam(value = "startTime")String startTime,
                               @RequestParam(value = "addToMovie",required = false)String addToMovie){



        logger.info(title);
        logger.info(genre);
        logger.info(description);
        logger.info(startDate);
        logger.info(startTime);

        MovieShowing movieShowing = new MovieShowing();
        Date movieShowingDate =  movieService.createDateObject(startDate,startTime);
        movieShowing.setDate(movieShowingDate);

        logger.info(addToMovie);

        if(addToMovie.equals("0")){
            logger.info("Tilføjer ny film" + addToMovie);
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setDescription(description);
            movieService.addMovie(movie);
            movieService.addMovieShowing(movie,movieShowing);
        } else {
            logger.info(addToMovie);
            Movie movie = movieService.findMovieByTitle(addToMovie);

            logger.info(movie.getTitle());

            movieService.addMovieShowing(movie, movieShowing);
        }

        return "redirect:/";
    }
}
