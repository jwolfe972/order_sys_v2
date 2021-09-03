package com.resturant.orderSystem.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Items {
    @Id
    private String id;
    private String itemName;
    public double itemPrice;
    private String itemMenuCategory;


    public  Items(){};



    public Items(String i, double p, String menu){


        this.itemMenuCategory = menu;
        this.itemPrice = p;
        this.itemName = i;
    }

    public String getItemId() {
        return id;
    }

    public void setItemId(String itemId) {
        this.id = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemMenuCategory() {
        return itemMenuCategory;
    }

    public void setItemMenuCategory(String itemMenuCategory) {
        this.itemMenuCategory = itemMenuCategory;
    }
}
