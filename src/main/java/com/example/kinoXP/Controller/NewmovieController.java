package com.example.kinoXP.Controller;

import com.example.kinoXP.Domain.Movie;
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
import java.util.logging.Logger;

@Controller
public class NewmovieController {

    private Logger logger = Logger.getLogger(NewmovieController.class.getName());

    @Autowired
    MovieService movieService;

    @Autowired
    EntityManager entityManager;

    @GetMapping("/add")
    public String addmovieGet(){

        return "add";
    }

    @PostMapping("/add")
    public String addmoviePost(@RequestParam(value = "title")String title,
                               @RequestParam(value = "genre")String genre,
                               @RequestParam(value = "description")String description,
                               @RequestParam(value = "startDate")String startDate,
                               @RequestParam(value = "startTime")String startTime){

        logger.info(title);
        logger.info(genre);
        logger.info(description);
        logger.info(startDate);
        logger.info(startTime);



        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setDescription(description);


       logger.info(movieService.createDateObject(startDate,startTime).toString());


        movieService.addMovie(movie);
        return "redirect:/";
    }
}
