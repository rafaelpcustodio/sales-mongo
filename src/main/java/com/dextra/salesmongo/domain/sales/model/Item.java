package com.dextra.salesmongo.domain.sales.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Document("item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item implements Serializable {

    @Id
    private ObjectId id;

    private String description;

    private BigDecimal price;
}
