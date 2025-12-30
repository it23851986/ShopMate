/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jaindee
 */
class PersonalCare extends NonFood {
    private String skinType;
    
    public PersonalCare(String productId, String name, double price, int quantity, String brand, String skinType) {
        super(productId, name, price, quantity, "Personal Care", brand);
        this.skinType = skinType;
    }
    
    public String getSkinType() {
        return skinType;
    }
    
    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + " | Skin Type: " + skinType;
    }
}