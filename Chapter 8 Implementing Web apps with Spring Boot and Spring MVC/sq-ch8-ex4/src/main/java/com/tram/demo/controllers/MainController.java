package com.tram.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    

    /**
     *  This is an example of request parameters
     *  > Can be used with optional values
     *  > don't use a lot of param args
     *  > can be difficult to read, but can be used for indexing a page
     */
    // @RequestMapping("/home")
    // public String home(
    //     @RequestParam(required = false, defaultValue = "John Yakuza") String name,
    //     @RequestParam(required = false, defaultValue = "black") String color,
    //     Model page) {
    //     page.addAttribute("username", name);
    //     page.addAttribute("color", color);
    //     return "home.html";
    // }

    /**
     *  This is similar to what we do in expressJS for CSC 317
     */
    @RequestMapping("/home/{color}")
    public String home(
        @PathVariable String color,
        Model page) {
        page.addAttribute("username", "timmy");
        page.addAttribute("color", color);
        return "home.html";
    }

}
