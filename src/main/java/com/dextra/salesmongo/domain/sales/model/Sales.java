package com.dextra.salesmongo.domain.sales.model;

import com.dextra.salesmongo.domain.sales.model.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import javax.persistence.Id;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "sales")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sales implements Serializable {

    @Id
    @GeneratedValue()
    private ObjectId id;

    private BigDecimal price;

    private List<Item> items;

    private Payment payment;
}
