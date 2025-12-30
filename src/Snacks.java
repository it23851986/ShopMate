/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
class Snacks extends Food {
    private String flavor;
    
    public Snacks(String productId, String name, double price, int quantity, String expiryDate, String flavor) {
        super(productId, name, price, quantity, "Snacks", expiryDate);
        this.flavor = flavor;
    }
    
    public String getFlavor() {
        return flavor;
    }
    
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Flavor: " + flavor;
    }
}
