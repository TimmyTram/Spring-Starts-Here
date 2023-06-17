package com.tram.sqch10ex5.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tram.sqch10ex5.exceptions.NotEnoughMoneyException;
import com.tram.sqch10ex5.models.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    
    // this tag triggers this function if we encounter the given exception type.
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment.");
        return ResponseEntity
        .badRequest()
        .body(errorDetails);
    }

}
