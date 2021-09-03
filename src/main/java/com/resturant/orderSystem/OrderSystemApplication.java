package com.resturant.orderSystem;
import com.resturant.orderSystem.models.Items;
import com.resturant.orderSystem.models.Orders;
import com.resturant.orderSystem.models.Users;
import com.resturant.orderSystem.repo.ItemsRepo;
import com.resturant.orderSystem.repo.OrdersRepo;
import com.resturant.orderSystem.repo.UserRepo;
import com.resturant.orderSystem.resources.OrdersResources;
import com.resturant.orderSystem.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrderSystemApplication{


	public static void main(String[] args) {

		SpringApplication.run(OrderSystemApplication.class, args);
	}



	}


