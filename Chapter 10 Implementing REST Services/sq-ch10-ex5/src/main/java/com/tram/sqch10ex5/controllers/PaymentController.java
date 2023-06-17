package com.tram.sqch10ex5.controllers;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tram.sqch10ex5.exceptions.NotEnoughMoneyException;
import com.tram.sqch10ex5.models.ErrorDetails;
import com.tram.sqch10ex5.models.PaymentDetails;
import com.tram.sqch10ex5.services.PaymentService;

@RestController
public class PaymentController {
    
    private final PaymentService paymentService;
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    // controller has a Dependency which is paymentService
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
        @RequestBody PaymentDetails paymentDetails) {
        
        logger.info("[LOG]: Received payment: " + paymentDetails.getAmount());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }

    // @PostMapping("/payment")
    // public ResponseEntity<PaymentDetails> makePayment() {
    //     PaymentDetails paymentDetails = paymentService.processPayment();
    //     return ResponseEntity
    //     .status(HttpStatus.ACCEPTED)
    //     .body(paymentDetails);
    // }

    // we will not use this code because we should instead create an exception Controller to reduce duplicate code
    // @PostMapping("/payment")
    // public ResponseEntity<?> makePayment() {
    //     // try to return a successful payment
    //     try {
    //         // the service performs the business logic
    //         // it can return a paymentDetails object or throw an exception which catch
    //         PaymentDetails paymentDetails = paymentService.processPayment();

    //         return ResponseEntity
    //         .status(HttpStatus.ACCEPTED)
    //         .body(paymentDetails);
    //     } catch(NotEnoughMoneyException e) { // otherwise return error details
    //         ErrorDetails errorDetails = new ErrorDetails();
    //         errorDetails.setMessage("Not enough money to make the payment.");

    //         return ResponseEntity
    //         .badRequest()
    //         .body(errorDetails);
    //     }
    // }

}
