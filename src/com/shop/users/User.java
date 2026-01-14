/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.users;

/**
 *
 * @author Jaindee
 */

// Abstract User class - base for Admin and Customer
// Uses: Abstraction, Encapsulation

public abstract class User {

    private final String userId;
    private final String username;
    private final String password;
    private final String userType;

    protected User(String userId, String username, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    protected boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public String getUserType() {
        return userType;
    }

    public abstract void displayInfo();
    public abstract void showMenu();

    @Override
    public String toString() {
        return "User ID: " + userId + " | Username: " + username + " | Type: " + userType;
    }
}
