package com.resturant.orderSystem.repo;

import com.resturant.orderSystem.models.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepo extends MongoRepository<Orders, String> {


    Optional<Orders> findByid(String id);
}
