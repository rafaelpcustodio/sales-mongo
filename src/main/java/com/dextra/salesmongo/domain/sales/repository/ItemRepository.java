package com.dextra.salesmongo.domain.sales.repository;

import com.dextra.salesmongo.domain.sales.model.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, ObjectId> {
}
