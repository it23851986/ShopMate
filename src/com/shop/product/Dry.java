package com.shop.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public class Dry extends Food {

    private final String grainType;

    public Dry(String productId, String name, double price, int quantity,
               String expiryDate, String grainType) {
        super(productId, name, price, quantity, expiryDate);
        this.grainType = grainType;
    }

    @Override
    public String getCategory() {
        return "Dry";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Type: " + grainType;
    }

    public String getGrainType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

