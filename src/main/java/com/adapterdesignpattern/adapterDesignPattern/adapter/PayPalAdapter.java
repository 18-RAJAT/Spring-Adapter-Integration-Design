package com.adapterdesignpattern.adapterDesignPattern.adapter;

import org.springframework.stereotype.Component;

@Component
public class PayPalAdapter {
    public void makePayment(double amount)
    {
        System.out.println("Payment processed using PayPal: "+amount);
    }
}
