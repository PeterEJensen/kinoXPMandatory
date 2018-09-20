package com.example.kinoXP;

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
}

