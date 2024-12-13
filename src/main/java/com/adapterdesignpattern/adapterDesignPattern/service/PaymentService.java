    package com.adapterdesignpattern.adapterDesignPattern.service;

    import com.adapterdesignpattern.adapterDesignPattern.adapter.PayPalAdapter;
    import com.adapterdesignpattern.adapterDesignPattern.request.PaymentRequest;
    import com.adapterdesignpattern.adapterDesignPattern.response.PaymentResponse;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.Random;

    @Service
    public class PaymentService {

        @Autowired
        private PayPalAdapter gPayAdapter;

        @Autowired
        private PayPalAdapter payPalAdapter;

        @Autowired
        private PayPalAdapter stripeAdapter;

        public PaymentResponse processPayment(String gateway, PaymentRequest paymentRequest) {
            PayPalAdapter processor = null;

            switch (gateway.toLowerCase()) {
                case "paypal":
                    processor = payPalAdapter;
                    break;
                case "stripe":
                    processor = stripeAdapter;
                    break;
                case "gpay":
                    processor = gPayAdapter;
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported payment gateway: " + gateway);
            }

            // Process the payment and ret  urn a response
            processor.makePayment(paymentRequest.getAmount());
            return new PaymentResponse(true, new Random().nextLong(10000000L));
        }
    }