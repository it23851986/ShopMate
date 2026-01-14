package com.shop.product;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
public abstract class NonFood extends Product {

    private final String brand;

    protected NonFood(String productId, String name, double price, int quantity, String brand) {
        super(productId, name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String displayInfo() {
        return toString() + " | Brand: " + brand;
    }
}
