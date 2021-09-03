package com.resturant.orderSystem.resources;

import com.resturant.orderSystem.models.Items;
import com.resturant.orderSystem.models.Orders;
import com.resturant.orderSystem.models.Users;
import com.resturant.orderSystem.services.ItemsService;
import com.resturant.orderSystem.services.OrdersService;
import com.resturant.orderSystem.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class   OrdersResources {


    private final OrdersService userService;
    private  final ItemsService itemsService;
    private final UserService userServices;

    public OrdersResources(OrdersService userService, ItemsService itemsService, UserService userServices) {
        this.userService = userService;
        this.itemsService = itemsService;
        this.userServices = userServices;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Orders>> getAllUsers(){


        List<Orders> userList = userService.getAllOrders();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Orders> getUser(@PathVariable("id") String id){
        Orders u = userService.findOrderByID(id);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Orders> addUser(@RequestBody Orders us){




        Orders u = userService.addOrder(us);
        performModifications(u.getId());


        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){


        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);



    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateStudent(@RequestBody Orders u){


        Orders user = userService.updateOrder(u);
        performModifications(user.getId());



        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public void calculateOrderAmnt(String id){
        String first = "The order has:\n";


        Orders o = userService.findOrderByID(id);
        List<String> u = o.getFoodItems();
        HashMap<String, Integer> orderLayout = new HashMap<>();

        double p = 0.0;

        for (String s : u) {

            Items v = itemsService.findOrderByID(s);
            o.setNumOfItems(o.getNumOfItems() +1);


            if (!orderLayout.containsKey(s)){

                orderLayout.put(s, 1);




            }
            else {

                orderLayout.put(s, orderLayout.get(s) + 1);
            }



            p+= v.getItemPrice();
        }
        o.setPrice(p);


        for (Map.Entry<String, Integer> entry : orderLayout.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(value > 1){
                first += value + " " + itemsService.findOrderByID(key).getItemName() + "s\n";
            }
            else {
                first += value + " " + itemsService.findOrderByID(key).getItemName() + "\n";
            }
        }


        o.setOrderDesc(first);


        userService.updateOrder(o);

    }


    public void setUserInfoInOrderTab(String id){


        Orders o = userService.findOrderByID(id);
        Users user = userServices.findUserByID(o.getUsersID());


        o.setUserInfo(user);
        userService.updateOrder(o);
    }


    public void setItemInfoInOrderTab(String id){


        List<Items> cartItems = new ArrayList<>();

        Orders o = userService.findOrderByID(id);
        List<String> foodItems = o.getFoodItems();
        for (String foodItem : foodItems) {

            cartItems.add(itemsService.findOrderByID(foodItem));

        }
        o.setOrderedItems(cartItems);
        userService.updateOrder(o);

    }


    public void performModifications(String id){


        calculateOrderAmnt(id);
        setUserInfoInOrderTab(id);
        setItemInfoInOrderTab(id);

    }

    @GetMapping("/call/{id}")
    public void callOrder( @PathVariable("id")String id){

        Orders o = userService.findOrderByID(id);



        System.out.println(o.getUserInfo().getFirstName() + " " + o.getUserInfo().getLastName() + " your order number: " + o.getId() + " is ready!!") ;




    }




}
