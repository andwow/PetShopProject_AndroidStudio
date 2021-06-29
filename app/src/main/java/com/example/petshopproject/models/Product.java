package com.example.petshopproject.models;

public class Product {
    private Long productId;
    private String name;
    private String description;
    private Float price;
    public Product()
    {
        productId = 0L;
        name = "";
        description = "";
        price = 0.0F;
    }
    public Product(Long productId, String name, String description, Float price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getProductId() {
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
    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getPrice() {
        return price;
    }
}
