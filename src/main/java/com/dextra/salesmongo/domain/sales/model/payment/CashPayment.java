package com.dextra.salesmongo.domain.sales.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashPayment extends Payment {

    private BigDecimal exchange;

    @Override
    public void createPayment() {
        System.out.println("create cash payment");
    }
}
