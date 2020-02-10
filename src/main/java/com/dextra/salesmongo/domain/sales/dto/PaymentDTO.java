package com.dextra.salesmongo.domain.sales.dto;

import com.dextra.salesmongo.domain.sales.type.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private PaymentType paymentType;

    private Double value;

    private Double exchange;

    private String cardNumber;

    private String ownerName;

    private String password;

    private LocalDate expirationDate;

    private String secretCode;
}
