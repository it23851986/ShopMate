/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.billing;

/**
 *
 * @author Jaindee
 */

public class BillingManager {

    private static BillingManager instance;
    private int billCounter = 1000;

    private BillingManager() {}

    public static BillingManager getInstance() {
        if (instance == null) {
            instance = new BillingManager();
        }
        return instance;
    }

    public Bill createBill(String customerName) {
        String billId = "BILL" + (++billCounter);
        return new Bill(billId, customerName);
    }

    public boolean processPayment(Bill bill, String paymentMethod) {
        if (bill == null || bill.isEmpty()) {
            return false;
        }
        bill.setPaymentMethod(paymentMethod);
        bill.calculateTotal();
        return true;
    }
}
