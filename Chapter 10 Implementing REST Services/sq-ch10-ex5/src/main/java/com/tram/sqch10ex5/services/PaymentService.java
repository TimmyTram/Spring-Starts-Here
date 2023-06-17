package com.tram.sqch10ex5.services;

import org.springframework.stereotype.Service;

import com.tram.sqch10ex5.exceptions.NotEnoughMoneyException;
import com.tram.sqch10ex5.models.PaymentDetails;

@Service
public class PaymentService {
    
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }

}
