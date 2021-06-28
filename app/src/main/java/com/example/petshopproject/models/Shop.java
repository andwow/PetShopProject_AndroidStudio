package com.example.petshopproject.models;

public class Shop {
    private int shopId;
    private String name;
    private String description;
    private String location;
    public Shop(int shopId, String name, String description, String location) {
        this.shopId = shopId;
        this.name = name;
        this.location = location;
    }
    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
    public int getShopId() {
        return shopId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }
}
