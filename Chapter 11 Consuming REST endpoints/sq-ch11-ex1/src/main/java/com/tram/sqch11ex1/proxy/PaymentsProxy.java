package com.tram.sqch11ex1.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.tram.sqch11ex1.models.Payment;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {
    
    @PostMapping("/payment")
    Payment createPayment(
        @RequestHeader String requestId,
        @RequestBody Payment payment
    );

}
