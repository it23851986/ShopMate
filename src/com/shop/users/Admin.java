/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.users;

/**
 *
 * @author Jaindee
 */
import com.shop.product.Product;
import com.shop.product.Inventory;
import java.util.List;

// Admin class - uses Singleton Inventory
public class Admin extends User {

    private Inventory inventory;      // Singleton inventory
    private double currentDiscount;

    public Admin(String userId, String username, String password) {
        super(userId, username, password, "Admin");
        this.inventory = Inventory.getInstance(); // ✅ Singleton access
        this.currentDiscount = 0.0;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       ADMIN PROFILE                ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println(toString());
        System.out.println("Total Products: " + inventory.getProducts().size());
        System.out.println("Current Discount: " + currentDiscount + "%");
    }

    @Override
    public void showMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         ADMIN MENU                 ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. View All Products");
        System.out.println("5. Set Discount");
        System.out.println("6. Add Stock");
        System.out.println("7. Generate Bill");
        System.out.println("8. View Profile");
        System.out.println("9. Logout");
        System.out.print("\nEnter choice: ");
    }

    // Add product
    public void addProduct(Product product) {
        inventory.addProduct(product);
        System.out.println("✓ Product added: " + product.getName());
    }

    // Remove product
    public boolean removeProduct(String productId) {
        boolean removed = inventory.removeProduct(productId);
        if (removed) {
            System.out.println("✓ Product removed successfully");
        } else {
            System.out.println("✗ Product not found");
        }
        return removed;
    }

    // Update product
    public boolean updateProduct(String productId, String newName, double newPrice) {
        Product product = inventory.searchProduct(productId);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            System.out.println("✓ Product updated successfully");
            return true;
        }
        System.out.println("✗ Product not found");
        return false;
    }

    // Add stock
    public boolean addStock(String productId, int quantity) {
        try {
            if (quantity <= 0) {
                throw new Exception("Quantity must be positive");
            }

            Product product = inventory.searchProduct(productId);
            if (product != null) {
                product.addQuantity(quantity);
                System.out.println("✓ Stock updated. New quantity: " + product.getQuantity());
                return true;
            }

            System.out.println("✗ Product not found");
            return false;

        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            return false;
        }
    }

    // View all products
    public void viewAllProducts() {
        List<Product> products = inventory.getProducts();

        if (products.isEmpty()) {
            System.out.println("⚠ Inventory is empty");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                     INVENTORY                             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        for (Product product : products) {
            System.out.println(product.displayInfo());
            System.out.println("─".repeat(70));
        }
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount > 100) {
            System.out.println("✗ Discount must be between 0 and 100");
            return;
        }
        this.currentDiscount = discount;
        System.out.println("✓ Discount set to " + discount + "%");
    }

    public double getCurrentDiscount() {
        return currentDiscount;
    }
}
