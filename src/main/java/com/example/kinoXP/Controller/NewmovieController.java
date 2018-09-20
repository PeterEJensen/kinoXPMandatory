package com.example.kinoXP.Controller;

import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class NewmovieController {

    private Logger logger = Logger.getLogger(NewmovieController.class.getName());

    @Autowired
    MovieService movieService;

    @GetMapping("/add")
    public String addmovieGet(){

        return "add";
    }

    @PostMapping("/add")
    public String addmoviePost(@RequestParam(value = "title")String title,
                               @RequestParam(value = "genre")String genre,
                               @RequestParam(value = "description")String description){

        logger.info(title);
        logger.info(genre);
        logger.info(description);

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setDescription(description);

        movieService.addMovie(movie);
        return "redirect:/";
    }
}
