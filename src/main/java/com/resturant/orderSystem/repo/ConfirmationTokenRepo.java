package com.resturant.orderSystem.repo;

import com.resturant.orderSystem.services.token.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepo extends MongoRepository<ConfirmationToken, String> {

    Optional<ConfirmationToken>findByToken(String token);



}
