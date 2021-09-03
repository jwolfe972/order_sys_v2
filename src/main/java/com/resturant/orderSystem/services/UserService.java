package com.resturant.orderSystem.services;


import com.resturant.orderSystem.exception.UserNotFoundException;
import com.resturant.orderSystem.models.Users;
import com.resturant.orderSystem.repo.UserRepo;
import com.resturant.orderSystem.services.token.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoOperations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {


    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;
    private final ConfirmationTokenService confirmService;
    private final MongoOperations mongoOperations;

    @Autowired
    public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder, ConfirmationTokenService confirmService, MongoOperations mongoOperations) {
        this.userRepo = userRepo;
        this.encoder = encoder;

        this.confirmService = confirmService;

        this.mongoOperations = mongoOperations;
    }


    public Users addUser(Users u){
        return userRepo.save(u);
    }


    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }


    public Users updateUser(Users u){

        return userRepo.save(u);

    }


    public  Users findUserByID(String id){

        return   userRepo.findStudentByid(id).orElseThrow(
                () -> new UserNotFoundException("User by id " + id + " was not found!!")
        );
    }

    public void deleteUser(String id){

        userRepo.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            return   userRepo.findStudentByEmailAddress(s).orElseThrow(
                () -> new UserNotFoundException("User by email: " + s + " was not found!!")
        );
    }


    public String signUpUser(Users users) {


        boolean userExists = userRepo.findStudentByEmailAddress(users.getEmailAddress()).isPresent();

        if(userExists){

            throw new IllegalStateException("user already exists");
        }

        else {

            String encodedPword = encoder.encode(users.getPassword());

            users.setpWord(encodedPword);
            userRepo.save(users);
        }
        String confirm = UUID.randomUUID().toString();
        ConfirmationToken token = new ConfirmationToken(
                confirm,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                users
        );


        confirmService.saveConfirmationToken(token);



        return confirm;


    }

    public void enableAppUser(String emailAddress) {



        Query query = new Query();
        query.addCriteria(Criteria.where("emailAddress").is(emailAddress));


        Users user = mongoOperations.findOne(query, Users.class);


        assert user != null;
        user.setEnabled(true);

        userRepo.save(user);



    }
}
