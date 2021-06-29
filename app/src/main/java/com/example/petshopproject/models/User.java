package com.example.petshopproject.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private String location;
    private List<Order> products;
    public User() {
        username = "";
        password = "";
        email = "";
        location = "";
        products = new ArrayList<Order>();
    }

    public User(String username, String password, String email, String location) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        products = new ArrayList<Order>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addProduct(Order order) { products.add(order); }
    public void removeProduct(Order order) { products.remove(order); }
    public void clearProducts(Order order) { products.clear(); }
}