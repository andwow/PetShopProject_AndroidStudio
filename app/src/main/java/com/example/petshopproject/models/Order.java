package com.example.petshopproject.models;

public class Order {
    private int count;
    private Product product;

    Order() {
        count = 0;
        product = new Product();
    }

    Order(int count, Product product) {
        this.count = count;
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
