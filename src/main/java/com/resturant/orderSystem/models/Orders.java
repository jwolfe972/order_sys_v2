package com.resturant.orderSystem.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Orders {
    @Id
    private String id;
    private List<String> items;
    private String usersID;
    private double price;
    private Users userInfo;
    private  List<Items> orderedItems;
    private int numOfItems = 0;
    private String orderDesc;

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public List<Items> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Items> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Users getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(Users userInfo) {
        this.userInfo = userInfo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Orders(){};



    public Orders(List<String > i, String user_id){
        this.items = i;

        this.usersID = user_id;



    }



    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsersID() {
        return this.usersID;
    }

    public void setUsersID(String usersID) {
        this.usersID = usersID;
    }

    public List<String> getFoodItems() {
        return this.items;
    }

    public void setFoodItems(List<String> foodItems) {
        this.items = foodItems;
    }

}
