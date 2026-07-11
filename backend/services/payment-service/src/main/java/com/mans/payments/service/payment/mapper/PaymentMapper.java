package com.mans.payments.service.payment.mapper;

import com.mans.payments.service.payment.dto.CreatePaymentRequest;
import com.mans.payments.service.payment.dto.PaymentResponse;
import com.mans.payments.service.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toEntity(CreatePaymentRequest request);

    @Mapping(target = "status",
            expression = "java(payment.getPaymentStatus().name())")
    @Mapping(target = "message", ignore = true)
    PaymentResponse toResponse(Payment payment);

}