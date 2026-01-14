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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bill implements Billable {

    private final String billId;
    private final String customerName;
    private final Date billDate;

    private final ArrayList<BillItem> items;
    private double discountPercent;
    private double subtotal;
    private double total;
    private String paymentMethod;

    public Bill(String billId, String customerName) {
        this.billId = billId;
        this.customerName = customerName;
        this.billDate = new Date();
        this.items = new ArrayList<>();
        this.discountPercent = 0.0;
        this.paymentMethod = "Cash";
    }

    // Business logic only
    public void addItem(Product product, int quantity) throws Exception {
        BillItem item = new BillItem(product, quantity);
        item.setDiscount(discountPercent);

        product.reduceQuantity(quantity);
        items.add(item);
    }

    public boolean removeItem(String productId) {
        for (int i = 0; i < items.size(); i++) {
            BillItem item = items.get(i);
            if (item.getProduct().getProductId().equals(productId)) {
                item.getProduct().addQuantity(item.getQuantity());
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            return;
        }
        this.discountPercent = discountPercent;
        for (BillItem item : items) {
            item.setDiscount(discountPercent);
        }
    }

    @Override
    public double calculateTotal() {
        subtotal = 0.0;
        total = 0.0;

        for (BillItem item : items) {
            subtotal += item.getSubtotal();
            total += item.getFinalPrice();
        }
        return total;
    }

    @Override
    public String generateReceipt() {
        calculateTotal();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("\n══════════════════════════════════════════════════════\n");
        sb.append("                SHOPMATE GROCERY                      \n");
        sb.append("══════════════════════════════════════════════════════\n");
        sb.append("Bill ID: ").append(billId).append("\n");
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Date: ").append(df.format(billDate)).append("\n");
        sb.append("Payment: ").append(paymentMethod).append("\n");
        sb.append("------------------------------------------------------\n");
        sb.append(String.format("%-20s %4s %8s %6s %10s\n",
                "Item", "Qty", "Price", "Disc", "Total"));
        sb.append("------------------------------------------------------\n");

        for (BillItem item : items) {
            sb.append(item).append("\n");
        }

        sb.append("------------------------------------------------------\n");
        sb.append(String.format("%-40s %.2f\n", "Subtotal:", subtotal));

        if (discountPercent > 0) {
            sb.append(String.format(
                "%-40s -%.2f\n",
                "Discount (" + discountPercent + "%):",
                subtotal - total
            ));
        }

        sb.append(String.format("%-40s %.2f\n", "TOTAL:", total));
        sb.append("══════════════════════════════════════════════════════\n");

        return sb.toString();
    }

    public void setPaymentMethod(String method) {
        this.paymentMethod = method;
    }

    public double getTotal() {
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
