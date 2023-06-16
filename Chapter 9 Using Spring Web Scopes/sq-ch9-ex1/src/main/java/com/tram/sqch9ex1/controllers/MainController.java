package com.tram.sqch9ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tram.sqch9ex1.services.LoggedInUserManagementService;



@Controller
public class MainController {
    
    private final LoggedInUserManagementService loggedInUserManagementService;

    public MainController(LoggedInUserManagementService loggedInUserManagementService) {
        this.loggedInUserManagementService = loggedInUserManagementService;
    }

    @GetMapping("/main")
    public String home(
        @RequestParam(required = false) String logout, 
        Model model
    ) {
        
        if(logout != null)
            loggedInUserManagementService.setUsername(null); // if logout is present erase username

        
        String username = loggedInUserManagementService.getUsername();

        if(username == null)
            return "redirect:/";
        
        model.addAttribute("username", username);
        return "main.html";
    }
    

}
