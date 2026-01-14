package com.shop.product;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public class HouseHold extends NonFood {

    private final String usage;

    public HouseHold(String productId, String name, double price, int quantity,
                     String brand, String usage) {
        super(productId, name, price, quantity, brand);
        this.usage = usage;
    }

    @Override
    public String getCategory() {
        return "Household";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Usage: " + usage;
    }

    public String getUsage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


