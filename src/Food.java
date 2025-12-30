/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
abstract class Food extends Product {
    private String expiryDate;
    
    public Food(String productId, String name, double price, int quantity, String category, String expiryDate) {
        super(productId, name, price, quantity, category);
        this.expiryDate = expiryDate;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    @Override
    public String displayInfo() {
        return toString() + " | Expiry: " + expiryDate;
    }
}

