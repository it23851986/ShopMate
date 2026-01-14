package com.shop.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public class PersonalCare extends NonFood {

    private final String skinType;

    public PersonalCare(String productId, String name, double price, int quantity,
                        String brand, String skinType) {
        super(productId, name, price, quantity, brand);
        this.skinType = skinType;
    }

    @Override
    public String getCategory() {
        return "Personal Care";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Skin Type: " + skinType;
    }

    public String getSkinType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
