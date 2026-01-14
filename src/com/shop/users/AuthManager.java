/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.users;

/**
 *
 * @author Jaindee
 */

import java.util.HashMap;

public class AuthManager {

    private static AuthManager instance;
    private final HashMap<String, User> users;
    private User currentUser;

    private AuthManager() {
        users = new HashMap<>();
        users.put("admin", new Admin("ADM001", "admin", "admin123"));
    }

    public static AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }

    public boolean registerUser(User user) {
        if (user == null || users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isAdmin() {
        return currentUser instanceof Admin;
    }
}
