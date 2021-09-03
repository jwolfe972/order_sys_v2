package com.resturant.orderSystem.repo;

import com.resturant.orderSystem.models.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface UserRepo extends MongoRepository<Users, String> {

    public Users findByFirstName(String id);
    public List<Users> findByLastName(String lastName);


    Optional<Users> findStudentByid(String id);

    Optional<Users> findStudentByEmailAddress(String s);
    @Transactional
    @Modifying
    int enabled(String emailAddress);
}
