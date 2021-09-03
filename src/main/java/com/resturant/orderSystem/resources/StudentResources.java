package com.resturant.orderSystem.resources;

import com.resturant.orderSystem.models.Users;
import com.resturant.orderSystem.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class   StudentResources {


    private final UserService userService;

    public StudentResources(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){


        List<Users> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") String id){
        Users u = userService.findUserByID(id);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<Users> addUser(@RequestBody Users us){
//
//
//        Users u = userService.addUser(us);
//
//        return new ResponseEntity<>(u, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){


        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);



    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateStudent(@RequestBody Users u){

        Users user = userService.updateUser(u);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }







}
