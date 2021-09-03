package com.resturant.orderSystem.resources;

import com.resturant.orderSystem.models.Items;
import com.resturant.orderSystem.services.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class   ItemsResources {


    private final ItemsService userService;

    public ItemsResources(ItemsService userService) {
        this.userService = userService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Items>> getAllUsers(){


        List<Items> userList = userService.getAllOrders();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Items> getUser(@PathVariable("id") String id){
        Items u = userService.findOrderByID(id);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Items> addUser(@RequestBody Items us){


        Items u = userService.addOrder(us);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){


        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);



    }

    @PutMapping("/update")
    public ResponseEntity<Items> updateStudent(@RequestBody Items u){

        Items user = userService.updateOrder(u);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }







}
