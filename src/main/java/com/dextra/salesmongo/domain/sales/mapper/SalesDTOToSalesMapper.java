package com.dextra.salesmongo.domain.sales.mapper;

import com.dextra.salesmongo.domain.sales.dto.SalesDTO;
import com.dextra.salesmongo.domain.sales.model.Item;
import com.dextra.salesmongo.domain.sales.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SalesDTOToSalesMapper {

    private ItemDTOToItemMapper itemDTOToItemMapper;

    private PaymentDTOToPaymentMapper paymentDTOToPaymentMapper;

    @Autowired
    public SalesDTOToSalesMapper(ItemDTOToItemMapper itemDTOToItemMapper, PaymentDTOToPaymentMapper paymentDTOToPaymentMapper) {
        this.itemDTOToItemMapper = itemDTOToItemMapper;
        this.paymentDTOToPaymentMapper = paymentDTOToPaymentMapper;
    }

    public Sales map(SalesDTO salesDTO) {
        Sales sales = new Sales();
        List<Item> items =  salesDTO.getItems().stream().map(i -> itemDTOToItemMapper.map(i)).collect(Collectors.toList());
        sales.setItems(items);
        sales.setPrice(new BigDecimal(salesDTO.getPrice()));
        sales.setPayment(paymentDTOToPaymentMapper.map(salesDTO.getPayment()));
        return sales;
    }
}
