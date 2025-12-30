/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
abstract class NonFood extends Product {
    private String brand;
    
    public NonFood(String productId, String name, double price, int quantity, String category, String brand) {
        super(productId, name, price, quantity, category);
        this.brand = brand;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    @Override
    public String displayInfo() {
        return toString() + " | Brand: " + brand;
    }
}