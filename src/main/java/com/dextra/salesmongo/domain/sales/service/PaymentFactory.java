package com.dextra.salesmongo.domain.sales.service;

import com.dextra.salesmongo.domain.sales.dto.PaymentDTO;
import com.dextra.salesmongo.domain.sales.model.payment.CashPayment;
import com.dextra.salesmongo.domain.sales.model.payment.CreditCardPayment;
import com.dextra.salesmongo.domain.sales.model.payment.DebitPayment;
import com.dextra.salesmongo.domain.sales.model.payment.Payment;
import com.dextra.salesmongo.domain.sales.type.PaymentType;

import java.math.BigDecimal;

public class PaymentFactory {

    private PaymentType type;

    private PaymentDTO paymentDTO;

    public PaymentFactory(PaymentType type, PaymentDTO paymentDTO) {
        this.type = type;
        this.paymentDTO = paymentDTO;
    }

    public PaymentFactory(PaymentType type) {
        this.type = type;
    }

    public Payment generatePayment() {
        if(this.type.toString().equalsIgnoreCase(PaymentType.CASH.toString())) {
            CashPayment cashPayment = new CashPayment();
            cashPayment.setExchange(new BigDecimal(paymentDTO.getExchange()));
            cashPayment.setValue(new BigDecimal(paymentDTO.getValue()));
            cashPayment.setType(paymentDTO.getPaymentType());
            return cashPayment;
        } else if(this.type.toString().equalsIgnoreCase(PaymentType.CREDITCARD.toString())) {
            CreditCardPayment creditCardPayment = new CreditCardPayment();
            creditCardPayment.setCardNumber(paymentDTO.getCardNumber());
            creditCardPayment.setExpirationDate(paymentDTO.getExpirationDate());
            creditCardPayment.setOwnerName(paymentDTO.getOwnerName());
            creditCardPayment.setSecretCode(paymentDTO.getSecretCode());
            creditCardPayment.setType(paymentDTO.getPaymentType());
            creditCardPayment.setValue(new BigDecimal(paymentDTO.getValue()));
            return creditCardPayment;
        } else if(this.type.toString().equalsIgnoreCase(PaymentType.DEBIT.toString())) {
            DebitPayment debitPayment = new DebitPayment();
            debitPayment.setCardNumber(paymentDTO.getCardNumber());
            debitPayment.setExpirationDate(paymentDTO.getExpirationDate());
            debitPayment.setOwnerName(paymentDTO.getOwnerName());
            debitPayment.setPassword(paymentDTO.getPassword());
            debitPayment.setType(paymentDTO.getPaymentType());
            debitPayment.setValue(new BigDecimal(paymentDTO.getValue()));
            return debitPayment;
        }
        return null;
    }
}
