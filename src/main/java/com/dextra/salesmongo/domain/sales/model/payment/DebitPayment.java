package com.dextra.salesmongo.domain.sales.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitPayment extends Payment {

    private String ownerName;

    private String cardNumber;

    private String password;

    private LocalDate expirationDate;

    @Override
    public void createPayment() {
        System.out.println("created debit payment");
    }
}
