package com.resturant.orderSystem.repo;

import com.resturant.orderSystem.models.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsRepo extends MongoRepository<Items, String> {


    Optional<Items> findByid(String id);
}
