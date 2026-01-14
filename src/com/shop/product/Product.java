package com.shop.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public abstract class Product {

    private final String productId;
    private final String name;
    private double price;
    private int quantity;

    protected Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Only getters for identity fields
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    // Price can change (business rule)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Quantity changes via behavior, not setter
    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) throws Exception {
        if (amount > quantity) {
            throw new Exception("Insufficient stock for " + name);
        }
        quantity -= amount;
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }

    // Category now comes from class type
    public abstract String getCategory();

    public abstract String displayInfo();

    @Override
    public String toString() {
        return String.format(
            "ID: %s | Name: %s | Price: %.2f | Qty: %d | Category: %s",
            productId, name, price, quantity, getCategory()
        );
    }

    public void setName(String newName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

