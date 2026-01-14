/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

/**
 *
 * @author Jaindee
 */
// ==================== MAIN.JAVA ====================
// ==================== MAIN.JAVA ====================


import com.shop.product.*;
import com.shop.users.*;
import com.shop.billing.*;
import com.shop.files.FileHandler;
import java.util.Scanner;
import java.util.ArrayList;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== ShopMate System Started ===");

        // Singleton inventory
        Inventory inventory = Inventory.getInstance();

        // File handler
        FileHandler fileHandler = new FileHandler();

        // Load data (Version B style)
        fileHandler.loadProducts();
        ArrayList<User> users = fileHandler.loadUsers();

        // Ensure admin exists
        boolean adminExists = false;
        for (User u : users) {
            if (u instanceof Admin) {
                adminExists = true;
                break;
            }
        }

        if (!adminExists) {
            users.add(new Admin("A001", "admin", "admin123"));
            System.out.println("✓ Default admin created");
        }

        // Display inventory
        System.out.println("\n--- INVENTORY ---");
        for (Product p : inventory.getProducts()) {
            System.out.println(p.displayInfo());
        }

        // Save before exit
        fileHandler.saveProducts(inventory.getProducts());
        fileHandler.saveUsers(users);

        System.out.println("\n✓ System exited safely");
    }
}

