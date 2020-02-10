package com.dextra.salesmongo.domain.sales.mapper;

import com.dextra.salesmongo.domain.sales.dto.ItemDTO;
import com.dextra.salesmongo.domain.sales.model.Item;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ItemDTOToItemMapper {

    public Item map(ItemDTO itemDTO) {
        Item item = new Item();
        item.setDescription(itemDTO.getDescription());
        item.setPrice(new BigDecimal(itemDTO.getPrice()));
        return item;
    }
}
