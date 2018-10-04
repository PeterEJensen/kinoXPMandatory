package com.example.kinoXP.Controller;

//Created by Peter & Fida

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.kinoXP.Domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//controller class for calender in user tab, unused and might be replaced

@RestController
@RequestMapping("/api/event")
public class RestWebController {

    @GetMapping(value = "/all")
    public String getEvents() {
        String jsonMsg = null;
        try {
            List<Event> events = new ArrayList<Event>();
            Event event = new Event();
            event.setTitle("Peter vagt");
            event.setStart("2018-10-02");
            //event.setEnd("2018-03-21");
            events.add(event);


            ObjectMapper mapper = new ObjectMapper();
            jsonMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }
}
