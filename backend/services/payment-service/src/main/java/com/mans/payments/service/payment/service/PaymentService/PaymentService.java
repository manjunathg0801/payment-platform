package com.mans.payments.service.payment.service;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mans.payments.service.payment.enums.PaymentStatus;

public interface PaymentService {

    PaymentResponse createPayment(CreatePaymentRequest request);
    PaymentResponse getPayment(String paymentId);
    Page<PaymentResponse> getPayments(Pageable pageable);

    Page<PaymentResponse> searchPayments(
            String customerId,
            PaymentStatus paymentStatus,
            String currency,
            Pageable pageable);
}