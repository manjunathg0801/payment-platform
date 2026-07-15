package com.mans.payments.service.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreatePaymentRequest {

    @NotBlank(message = "Customer Id is mandatory")
    private String customerId;

    @NotNull(message = "Payment Amount is mandatory")
    @Positive(message = "Payment Amount must be greater than zero")
    private BigDecimal paymentAmount;

    @NotBlank(message = "Currency is mandatory")
    private String currency;

    @NotBlank(message = "From Account is mandatory")
    private String fromAccount;

    @NotBlank(message = "To Account is mandatory")
    private String toAccount;

    @NotBlank(message = "From Bank is mandatory")
    private String fromBank;

    @NotBlank(message = "To Bank is mandatory")
    private String toBank;

    @NotBlank(message = "Payment Method is mandatory")
    private String paymentMethod;

    @NotBlank(message = "Transaction Type is mandatory")
    private String transactionType;


    public CreatePaymentRequest() {
    }

    //  Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getFromBank() {
        return fromBank;
    }

    public void setFromBank(String fromBank) {
        this.fromBank = fromBank;
    }

    public String getToBank() {
        return toBank;
    }

    public void setToBank(String toBank) {
        this.toBank = toBank;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}