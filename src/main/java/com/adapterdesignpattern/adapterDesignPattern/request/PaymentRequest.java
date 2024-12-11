package com.adapterdesignpattern.adapterDesignPattern.request;

public record PaymentRequest(Double amount,String currency) {
    public PaymentRequest
    {
        if(amount<0)
        {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }
    }
}
