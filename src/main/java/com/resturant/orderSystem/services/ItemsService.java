package com.resturant.orderSystem.services;


import com.resturant.orderSystem.exception.UserNotFoundException;
import com.resturant.orderSystem.models.Items;
import com.resturant.orderSystem.repo.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {


    private final ItemsRepo ordersRepo;

    @Autowired
    public ItemsService(ItemsRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }


    public Items addOrder(Items u){
        return ordersRepo.save(u);
    }


    public List<Items> getAllOrders(){
        return ordersRepo.findAll();
    }


    public Items updateOrder(Items u){

        return ordersRepo.save(u);

    }


    public  Items findOrderByID(String id){

        return   ordersRepo.findByid(id).orElseThrow(
                () -> new UserNotFoundException("Item by id " + id + " was not found!!")
        );
    }

    public void deleteUser(String id){

        ordersRepo.deleteById(id);
    }




}
