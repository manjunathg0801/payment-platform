package com.mans.payments.service.payment.specification;

import com.mans.payments.service.payment.entity.Payment;
import com.mans.payments.service.payment.enums.PaymentStatus;
import org.springframework.data.jpa.domain.Specification;

public class PaymentSpecification {

    public static Specification<Payment> hasCustomerId(String customerId) {
        return (root, query, cb) ->
                customerId == null
                        ? null
                        : cb.equal(root.get("customerId"), customerId);
    }

    public static Specification<Payment> hasStatus(PaymentStatus status) {
        return (root, query, cb) ->
                status == null
                        ? null
                        : cb.equal(root.get("paymentStatus"), status);
    }

    public static Specification<Payment> hasCurrency(String currency) {
        return (root, query, cb) ->
                currency == null
                        ? null
                        : cb.equal(root.get("currency"), currency);
    }

}