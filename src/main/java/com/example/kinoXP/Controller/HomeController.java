package com.example.kinoXP.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
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
    public String showMovies() {
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

