package com.mans.payments.service.payment.controller;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;
import com.mans.payments.service.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment API", description = "Payment Management APIs")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create Payment")
    public PaymentResponse createPayment(
            @Valid @RequestBody CreatePaymentRequest request) {

        return service.createPayment(request);
    }
}