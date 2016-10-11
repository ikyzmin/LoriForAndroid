package com.ssau.lori.serverapi.entities;

public class User {

    String username;
    String password;
    private final String locale = "ru";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
