/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
class Dry extends Food {
    private String grainType;
    
    public Dry(String productId, String name, double price, int quantity, String expiryDate, String grainType) {
        super(productId, name, price, quantity, "Dry", expiryDate);
        this.grainType = grainType;
    }
    
    public String getGrainType() {
        return grainType;
    }
    
    public void setGrainType(String grainType) {
        this.grainType = grainType;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Type: " + grainType;
    }
}
