package com.dextra.salesmongo.domain.sales.repository;

import com.dextra.salesmongo.domain.sales.model.Sales;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends MongoRepository<Sales, ObjectId> {

    Optional<Sales> findById(ObjectId id);
}
