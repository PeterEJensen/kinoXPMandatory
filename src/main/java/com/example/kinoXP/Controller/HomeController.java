package com.example.kinoXP.Controller;


import com.example.kinoXP.Domain.Movie;
import com.example.kinoXP.Service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MovieService movieService;

//comment
@RequestMapping(value = "/", method = RequestMethod.GET) //get method to request data
public String index() {
    return "index";
}


    @RequestMapping(value="/403")
    public String Error403(){
        return "/error/403";
    }
    @RequestMapping(value="/404")
    public String Error404(){
        return "/error/404";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/showMovies")
    public String showMovies(Model model) {
        List<Movie> list;
        list = movieService.findAll();
        model.addAttribute("movies",list);
        return "showMovies";
    }

    @GetMapping("/calendar")
    String calendar(Model model) {
        return "calendar";
    }

    @GetMapping("/contact")
    public String contact() {

        return "contact";
    }


    @GetMapping("/showBookings")
    public String showBookings() {
        return "showBookings";
    }
}

