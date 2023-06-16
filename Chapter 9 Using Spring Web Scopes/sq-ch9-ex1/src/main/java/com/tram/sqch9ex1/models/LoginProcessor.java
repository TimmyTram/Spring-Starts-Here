package com.tram.sqch9ex1.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.tram.sqch9ex1.services.LoggedInUserManagementService;

@Component
@RequestScope
public class LoginProcessor {
    
    private final LoggedInUserManagementService loggedInUserManagementService;

    private String username;
    private String password;

    public LoginProcessor(LoggedInUserManagementService loggedInUserManagementService) {
        this.loggedInUserManagementService = loggedInUserManagementService;
    }
    
    public boolean login() {
        username = this.getUsername();
        password = this.getPassword();
        
        boolean loginResult = false;
        if("tim".equals(username) && "password".equals(password)) {
            loginResult = true;
            loggedInUserManagementService.setUsername(username); // pass username to be a session scope value.
        }
        return loginResult;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
