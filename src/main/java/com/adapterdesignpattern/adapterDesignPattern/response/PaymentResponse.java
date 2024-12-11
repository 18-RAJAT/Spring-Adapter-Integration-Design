package com.adapterdesignpattern.adapterDesignPattern.response;

public record PaymentResponse(boolean isSuccess,Long transactionId){
    public PaymentResponse
    {
        if(transactionId<0)
        {
            throw new IllegalArgumentException("Transaction id cannot be less than 0");
        }
    }
}
