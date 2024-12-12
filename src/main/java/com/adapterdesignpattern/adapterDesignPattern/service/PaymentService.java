package com.adapterdesignpattern.adapterDesignPattern.service;

import com.adapterdesignpattern.adapterDesignPattern.adapter.GPayAdapter;
import com.adapterdesignpattern.adapterDesignPattern.adapter.PayPalAdapter;
import com.adapterdesignpattern.adapterDesignPattern.adapter.StripeAdapter;
import com.adapterdesignpattern.adapterDesignPattern.adapter.PhonePeAdapter;

import com.adapterdesignpattern.adapterDesignPattern.processor.PaymentProcessor;

import com.adapterdesignpattern.adapterDesignPattern.request.PaymentRequest;
import com.adapterdesignpattern.adapterDesignPattern.response.PaymentResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class PaymentService {
    //private final Map<String,PaymentProcessor>paymentProcessorMap;
    private Map<String,PaymentProcessor>paymentProcessorMap;
    public PaymentService(List<PaymentProcessor>paymentProcessors)
    {
        paymentProcessorMap=paymentProcessors.stream()
                .collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(),Function.identity()));
    }

    public PaymentResponse processPayment(String gateway,PaymentRequest paymentRequest)
    {
        PaymentProcessor paymentProcessor=paymentProcessorMap.get(gateway+" Adapter");
        paymentProcessor.makePayment(paymentRequest.amount());
        return new PaymentResponse(true,new Random().nextLong(10000000L));
    }
}
