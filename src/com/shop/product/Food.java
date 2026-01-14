package com.shop.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public abstract class Food extends Product {

    private final String expiryDate;

    protected Food(String productId, String name, double price, int quantity, String expiryDate) {
        super(productId, name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String displayInfo() {
        return toString() + " | Expiry: " + expiryDate;
    }
}
        
