package com.adapterdesignpattern.adapterDesignPattern.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adapterdesignpattern.adapterDesignPattern.request.PaymentRequest;
import com.adapterdesignpattern.adapterDesignPattern.response.PaymentResponse;
import com.adapterdesignpattern.adapterDesignPattern.service.PaymentService;

@RestController

@RequestMapping("/api/v1/payments")
public class PaymentController {
    public static final Logger logs=LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }
    @PostMapping
    public ResponseEntity<PaymentResponse>makePayment(@RequestBody PaymentRequest paymentRequest,@RequestBody String gateway)
    {
        logs.debug("Received Payment Request: {}",paymentRequest);
        return ResponseEntity.ok(paymentService.processPayment(gateway,paymentRequest));
    }
}
