package com.mans.payments.service.payment.controller;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;
import com.mans.payments.service.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment API", description = "Payment Management APIs")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @Operation(summary = "Create Payment")
    public PaymentResponse createPayment(
            @Valid @RequestBody CreatePaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @GetMapping("/{paymentId}")
    @Operation(summary = "Get Payment By Payment Id")
    public PaymentResponse getPayment(@PathVariable("paymentId") String paymentId) {

        return paymentService.getPayment(paymentId);
    }
}