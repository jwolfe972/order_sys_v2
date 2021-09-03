package com.resturant.orderSystem.services;


import com.resturant.orderSystem.exception.UserNotFoundException;
import com.resturant.orderSystem.models.Orders;
import com.resturant.orderSystem.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {


    private final OrdersRepo ordersRepo;

    @Autowired
    public OrdersService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;

    }


    public Orders addOrder(Orders u){
        return ordersRepo.save(u);
    }





    public List<Orders> getAllOrders(){
        return ordersRepo.findAll();
    }


    public Orders updateOrder(Orders u){

        return ordersRepo.save(u);

    }


    public  Orders findOrderByID(String id){

        return   ordersRepo.findByid(id).orElseThrow(
                () -> new UserNotFoundException("Order by id " + id + " was not found!!")
        );
    }

    public void deleteUser(String id){

        ordersRepo.deleteById(id);
    }




}
