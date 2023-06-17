package com.tram.sqch11payments.controllers;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tram.sqch11payments.models.Payment;

@RestController
public class PaymentController {
    
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());


    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
        @RequestHeader String requestId,
        @RequestHeader Payment payment
    ) {

        logger.info("[LOG]: Received request with id: " + requestId + " | Payment Amount: " + payment.getAmount());

        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }

}
