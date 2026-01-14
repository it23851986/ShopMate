/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shop.billing;

/**
 *
 * @author Jaindee
 */

public interface Discountable {
    void setDiscount(double percent);
    double getDiscountAmount();
    double getFinalPrice();
}

