package com.adapterdesignpattern.adapterDesignPattern.request;

public class PaymentRequest {
    private double amount;
    private String gateway;

    // Getters & setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
}
