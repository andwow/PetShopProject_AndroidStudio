package com.example.petshopproject.models;

public class Product {
    private int productId;
    private String name;
    private String description;
    private float price;

    public Product(int productId, String name, String description, float price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getProductId() {
        return productId;
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
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return price;
    }
}
