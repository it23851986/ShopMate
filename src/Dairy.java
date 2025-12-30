/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
class Dairy extends Food {
    private String storageTemp;
    
    public Dairy(String productId, String name, double price, int quantity, String expiryDate, String storageTemp) {
        super(productId, name, price, quantity, "Dairy", expiryDate);
        this.storageTemp = storageTemp;
    }
    
    public String getStorageTemp() {
        return storageTemp;
    }
    
    public void setStorageTemp(String storageTemp) {
        this.storageTemp = storageTemp;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Storage: " + storageTemp;
    }
}

