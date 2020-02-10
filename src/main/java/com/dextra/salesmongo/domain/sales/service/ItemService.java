package com.dextra.salesmongo.domain.sales.service;

import com.dextra.salesmongo.domain.sales.model.Item;
import com.dextra.salesmongo.domain.sales.repository.ItemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> findById(final String id) {
        return this.itemRepository.findById(new ObjectId(id));
    }

    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    public void deleteById(final String id) {
        this.itemRepository.deleteById(new ObjectId(id));
    }

    public void save(final Item item) {
        this.itemRepository.save(item);
    }



}
