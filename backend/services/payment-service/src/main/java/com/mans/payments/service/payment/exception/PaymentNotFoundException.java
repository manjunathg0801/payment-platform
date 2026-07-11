package com.mans.payments.service.payment.exception;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(String paymentId) {
        super("Payment not found : " + paymentId);
    }

}