package com.resturant.orderSystem.services;


import com.resturant.orderSystem.exception.UserNotFoundException;
import com.resturant.orderSystem.models.Users;
import com.resturant.orderSystem.repo.ConfirmationTokenRepo;
import com.resturant.orderSystem.services.token.ConfirmationToken;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoOperations;

import java.time.LocalDateTime;

@Service
public class ConfirmationTokenService {


    private final ConfirmationTokenRepo confirmRepo;
    private final MongoOperations mongoOperations;


    public ConfirmationTokenService(ConfirmationTokenRepo confirmRepo, MongoOperations mongoOperations) {
        this.confirmRepo = confirmRepo;
        this.mongoOperations = mongoOperations;
    }



    public void saveConfirmationToken(ConfirmationToken t){


        confirmRepo.save(t);
    }


    public ConfirmationToken getToken(String ctoken) {


       return confirmRepo.findByToken(ctoken).orElseThrow(
               ()-> new UserNotFoundException("this token could not be found ---> " + ctoken)
       );
    }

    public void setConfirmedAt(String token, LocalDateTime timeIn) {


        Query query = new Query();
        query.addCriteria(Criteria.where("token").is(token));


        ConfirmationToken ct = mongoOperations.findOne(query, ConfirmationToken.class);


        assert ct != null;
        ct.setToken(token);
        ct.setConfirmationTime(timeIn);

        confirmRepo.save(ct);




    }
}
