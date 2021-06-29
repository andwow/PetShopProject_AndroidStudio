package com.example.petshopproject.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserForRegister implements Serializable {
    private String username;
    private String password;
    private String email;
    private String location;
    public UserForRegister() {
        username = "";
        password = "";
        email = "";
        location = "";
    }

    public UserForRegister(String username, String password, String email, String location) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
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
}
