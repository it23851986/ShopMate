/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
class HouseHold extends NonFood {
    private String usage;
    
    public HouseHold(String productId, String name, double price, int quantity, String brand, String usage) {
        super(productId, name, price, quantity, "Household", brand);
        this.usage = usage;
    }
    
    public String getUsage() {
        return usage;
    }
    
    public void setUsage(String usage) {
        this.usage = usage;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Usage: " + usage;
    }
}

