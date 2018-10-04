package com.example.kinoXP.Controller;

import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class MovieController {

    public ArrayList<String> moviepictures = new ArrayList<>();



    @Autowired
    MovieService movieService;

    @GetMapping(value = "/movie/{id}")
    public String getMovie(Model model, @PathVariable("id")Long id){


        String src = movieService.pictureArray().get(id.intValue()-1);
        Movie movie = movieService.findMovieById(id);
        model.addAttribute("src",src);
        model.addAttribute(movie);

        return "movie";
    }

}
