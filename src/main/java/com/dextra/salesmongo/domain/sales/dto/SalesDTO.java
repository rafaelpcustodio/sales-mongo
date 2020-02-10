package com.dextra.salesmongo.domain.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {

    private Double price;

    private PaymentDTO payment;

    private List<ItemDTO> items;
}
