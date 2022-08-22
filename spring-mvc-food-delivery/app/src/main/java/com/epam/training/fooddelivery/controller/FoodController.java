package com.epam.training.fooddelivery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping(value = "/foods", method = RequestMethod.GET)
    public String listAllFood(){
        return "food";
    }
}
