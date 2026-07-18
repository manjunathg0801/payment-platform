package com.mans.payments.service.payment.service.impl;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;
import com.mans.payments.service.payment.entity.Payment;
import com.mans.payments.service.payment.enums.PaymentStatus;
import com.mans.payments.service.payment.repository.PaymentRepository;
import com.mans.payments.service.payment.service.PaymentService;
import org.springframework.stereotype.Service;
import com.mans.payments.service.payment.mapper.PaymentMapper;

import org.springframework.transaction.annotation.Transactional;
import com.mans.payments.service.payment.exception.PaymentNotFoundException;

import com.mans.payments.service.payment.specification.PaymentSpecification;
import org.springframework.data.jpa.domain.Specification;
import com.mans.payments.service.payment.constants.ApplicationConstants;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponse createPayment(CreatePaymentRequest request) {

        Payment payment = paymentMapper.toEntity(request);

        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setTransactionReference(generateTransactionReference());
        payment.setPaymentStatus(PaymentStatus.INITIATED);
        payment.setCreatedDate(LocalDateTime.now());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setRetryCount(0);
        payment.setChannel(ApplicationConstants.API_CHANNEL);
        payment.setCreatedBy(ApplicationConstants.SYSTEM_USER);

        Payment savedPayment = paymentRepository.save(payment);

        PaymentResponse response = paymentMapper.toResponse(savedPayment);
        response.setMessage(ApplicationConstants.PAYMENT_CREATED);

        return response;
    }

    private String generateTransactionReference() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 16);
    }

    @Override
    @Transactional(readOnly = true)
    public PaymentResponse getPayment(String paymentId) {

        Payment payment = paymentRepository
                .findByPaymentId(paymentId)
                .orElseThrow(() ->
                        new PaymentNotFoundException(paymentId));

        PaymentResponse response = paymentMapper.toResponse(payment);
        response.setMessage(ApplicationConstants.PAYMENT_RETRIEVED);

        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentResponse> getPayments(Pageable pageable) {

        return paymentRepository.findAll(pageable)
                .map(paymentMapper::toResponse);

    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentResponse> searchPayments(
            String customerId,
            PaymentStatus paymentStatus,
            String currency,
            Pageable pageable) {

        Specification<Payment> spec =
                Specification.where(PaymentSpecification.hasCustomerId(customerId))
                        .and(PaymentSpecification.hasStatus(paymentStatus))
                        .and(PaymentSpecification.hasCurrency(currency));

        return paymentRepository.findAll(spec, pageable)
                .map(paymentMapper::toResponse);
    }
}