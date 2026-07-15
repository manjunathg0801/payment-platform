package com.mans.payments.service.payment.controller;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;
import com.mans.payments.service.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mans.payments.service.payment.enums.PaymentStatus;

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



    @GetMapping
    @Operation(summary = "Get All Payments")
    public Page<PaymentResponse> getPayments(Pageable pageable) {

        return paymentService.getPayments(pageable);

    }

    @GetMapping("/search")
    @Operation(summary = "Search Payments")
    public Page<PaymentResponse> searchPayments(

            @RequestParam(name = "customerId", required = false)
            String customerId,

            @RequestParam(name = "paymentStatus", required = false)
            PaymentStatus paymentStatus,

            @RequestParam(name = "currency", required = false)
            String currency,

            Pageable pageable) {

        return paymentService.searchPayments(
                customerId,
                paymentStatus,
                currency,
                pageable);
    }
}