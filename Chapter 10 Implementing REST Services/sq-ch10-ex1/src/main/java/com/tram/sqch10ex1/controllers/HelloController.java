package com.tram.sqch10ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// public class HelloController {
    
//     @GetMapping("/hello")
//     @ResponseBody
//     public String hello() {
//         return "Hello!";
//     }

//     @GetMapping("/bye")
//     @ResponseBody
//     public String bye() {
//         return "Bye!";
//     }

// }


// using @RestController allows us to omit @ResponseBody, this tells spring
// all controller actions are REST endpoints.
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye!";
    }
}
