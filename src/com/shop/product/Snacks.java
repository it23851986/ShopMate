package com.shop.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public class Snacks extends Food {

    private final String flavor;

    public Snacks(String productId, String name, double price, int quantity,
                  String expiryDate, String flavor) {
        super(productId, name, price, quantity, expiryDate);
        this.flavor = flavor;
    }

    @Override
    public String getCategory() {
        return "Snacks";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Flavor: " + flavor;
    }

    public String getFlavor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
