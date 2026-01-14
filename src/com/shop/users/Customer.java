/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.users;

/**
 *
 * @author Jaindee
 */

import com.shop.product.Inventory;
import com.shop.product.Product;
import java.util.List;

// Customer class
public class Customer extends User {

    private String email;
    private String phone;
    private Inventory inventory;

    public Customer(String userId, String username, String password, String email, String phone) {
        super(userId, username, password, "Customer");
        this.email = email;
        this.phone = phone;
        this.inventory = Inventory.getInstance(); // Singleton access
    }

    @Override
    public void displayInfo() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      CUSTOMER PROFILE              ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println(toString());
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    @Override
    public void showMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        CUSTOMER MENU               ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. View Available Products");
        System.out.println("2. Search Product");
        System.out.println("3. View by Category");
        System.out.println("4. Make Purchase");
        System.out.println("5. View Profile");
        System.out.println("6. Logout");
        System.out.print("\nEnter choice: ");
    }

    // View available products
    public void viewAvailableProducts() {
        List<Product> products = inventory.getProducts();
        boolean found = false;

        for (Product product : products) {
            if (product.getQuantity() > 0) {
                System.out.println(product.displayInfo());
                System.out.println("─".repeat(70));
                found = true;
            }
        }

        if (!found) {
            System.out.println("⚠ No products available");
        }
    }

    // Search product
    public void searchProduct(String keyword) {
        boolean found = false;

        for (Product product : inventory.getProducts()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                product.getProductId().equalsIgnoreCase(keyword)) {

                System.out.println(product.displayInfo());
                System.out.println("─".repeat(70));
                found = true;
            }
        }

        if (!found) {
            System.out.println("⚠ Product not found");
        }
    }

    // View by category
    public void viewByCategory(String category) {
        boolean found = false;

        for (Product product : inventory.getProducts()) {
            if (product.getCategory().equalsIgnoreCase(category) &&
                product.getQuantity() > 0) {

                System.out.println(product.displayInfo());
                System.out.println("─".repeat(70));
                found = true;
            }
        }

        if (!found) {
            System.out.println("⚠ No products in this category");
        }
    }
}

