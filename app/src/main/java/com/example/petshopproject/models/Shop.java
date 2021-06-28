package com.example.petshopproject.models;

public class Shop {
    private Long shopId;
    private String name;
    private String description;
    private String location;
    public Shop() {
        shopId = 0L;
        name = "";
        description = "";
        location = "";
    }
    public Shop(Long shopId, String name, String description, String location) {
        this.shopId = shopId;
        this.name = name;
        this.description = description;
        this.location = location;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Long getShopId() {
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
