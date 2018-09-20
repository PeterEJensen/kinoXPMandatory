package com.example.kinoXP.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
//comment
    @GetMapping("/index")
    public String index(Model model) {
        log.info("index action called...");
        //code
        log.info("index action ended...");

        return "index";
    }


    @RequestMapping(value="/american")
    public String american(){
        return "american";
    }

    @RequestMapping(value="/clockwork")
    public String clockwork(){
        return "clockwork";
    }

    @RequestMapping(value="/eet")
    public String eet(){
        return "eet";
    }

    @RequestMapping(value="/silencelambs")
    public String silencelambs(){
        return "silencelambs";
    }

    @RequestMapping(value="/truman")
    public String truman(){
        return "truman";
    }


    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }



    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

