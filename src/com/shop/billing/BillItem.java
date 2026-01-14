/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 


*/
package com.shop.billing;

/**
 *
 * @author Jaindee
 */

import com.shop.product.Product;

public class BillItem implements Discountable {

    private final Product product;
    private final int quantity;
    private double discountPercent;

    public BillItem(Product product, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Quantity must be greater than zero");
        }
        this.product = product;
        this.quantity = quantity;
        this.discountPercent = 0.0;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public void setDiscount(double percent) {
        this.discountPercent = percent;
    }

    @Override
    public double getDiscountAmount() {
        return getSubtotal() * (discountPercent / 100);
    }

    @Override
    public double getFinalPrice() {
        return getSubtotal() - getDiscountAmount();
    }

    @Override
    public String toString() {
        return String.format(
            "%-20s %4d %8.2f %6.1f%% %10.2f",
            product.getName(),
            quantity,
            product.getPrice(),
            discountPercent,
            getFinalPrice()
        );
    }
}
