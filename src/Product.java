/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
abstract class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private String category;
    
    // Constructor
    public Product(String productId, String name, double price, int quantity, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
    
    // Getters and Setters (Encapsulation)
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    // Method to reduce quantity after sale
    public void reduceQuantity(int amount) throws Exception {
        if (amount > quantity) {
            throw new Exception("Insufficient stock for " + name);
        }
        quantity -= amount;
    }
    
    // Method to add quantity when stock arrives
    public void addQuantity(int amount) {
        quantity += amount;
    }
    
    // Abstract method for polymorphism - to be overridden by subclasses
    public abstract String displayInfo();
    
    // Common display format
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Price: $%.2f | Qty: %d | Category: %s",
                productId, name, price, quantity, category);
    }
}
