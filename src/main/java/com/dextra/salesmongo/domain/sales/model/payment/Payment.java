package com.dextra.salesmongo.domain.sales.model.payment;

import com.dextra.salesmongo.domain.sales.type.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Payment {

    private BigDecimal value;

    private PaymentType type;

    public abstract void createPayment();
}
