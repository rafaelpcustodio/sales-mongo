package com.dextra.salesmongo.domain.sales.mapper;

import com.dextra.salesmongo.domain.sales.dto.PaymentDTO;
import com.dextra.salesmongo.domain.sales.model.payment.Payment;
import com.dextra.salesmongo.domain.sales.service.PaymentFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentDTOToPaymentMapper {

    public Payment map(PaymentDTO paymentDTO) {
        PaymentFactory paymentFactory = new PaymentFactory(paymentDTO.getPaymentType(), paymentDTO);
        return paymentFactory.generatePayment();
    }
}
