package com.shop.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public class Dairy extends Food {

    private final String storageTemp;

    public Dairy(String productId, String name, double price, int quantity,
                 String expiryDate, String storageTemp) {
        super(productId, name, price, quantity, expiryDate);
        this.storageTemp = storageTemp;
    }

    @Override
    public String getCategory() {
        return "Dairy";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Storage: " + storageTemp;
    }

    public String getStorageTemp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


