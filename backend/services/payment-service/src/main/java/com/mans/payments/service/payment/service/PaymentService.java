package com.mans.payments.service.payment.service;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse createPayment(CreatePaymentRequest request);

}