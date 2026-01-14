/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.files;

/**
 *
 * @author Jaindee
 */
import com.shop.product.*;
import com.shop.users.*;
import java.io.*;
import java.util.ArrayList;

/**
 * FileHandler - Handles File I/O using Singleton Inventory
 */
public class FileHandler {

    private static final String PRODUCTS_FILE = "data/products.txt";
    private static final String USERS_FILE = "data/users.txt";

    private Inventory inventory;

    public FileHandler() {
        inventory = Inventory.getInstance(); // ✅ Singleton access

        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    // ================= SAVE PRODUCTS =================
    public void saveProducts(ArrayList<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {

            for (Product product : inventory.getProducts()) {
                writer.write(productToString(product));
                writer.newLine();
            }

            System.out.println("✓ Products saved successfully");

        } catch (IOException e) {
            System.out.println("✗ Error saving products: " + e.getMessage());
        }
    }

    private String productToString(Product product) {

        if (product instanceof Dairy d) {
            return "DAIRY|" + d.getProductId() + "|" + d.getName() + "|" +
                    d.getPrice() + "|" + d.getQuantity() + "|" +
                    d.getExpiryDate() + "|" + d.getStorageTemp();

        } else if (product instanceof Dry d) {
            return "DRY|" + d.getProductId() + "|" + d.getName() + "|" +
                    d.getPrice() + "|" + d.getQuantity() + "|" +
                    d.getExpiryDate() + "|" + d.getGrainType();

        } else if (product instanceof Snacks s) {
            return "SNACKS|" + s.getProductId() + "|" + s.getName() + "|" +
                    s.getPrice() + "|" + s.getQuantity() + "|" +
                    s.getExpiryDate() + "|" + s.getFlavor();

        } else if (product instanceof HouseHold h) {
            return "HOUSEHOLD|" + h.getProductId() + "|" + h.getName() + "|" +
                    h.getPrice() + "|" + h.getQuantity() + "|" +
                    h.getBrand() + "|" + h.getUsage();

        } else if (product instanceof PersonalCare p) {
            return "PERSONALCARE|" + p.getProductId() + "|" + p.getName() + "|" +
                    p.getPrice() + "|" + p.getQuantity() + "|" +
                    p.getBrand() + "|" + p.getSkinType();
        }

        return "";
    }

    // ================= LOAD PRODUCTS =================
    public void loadProducts() {

    Inventory inventory = Inventory.getInstance();
    inventory.clear();

    try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#") || line.trim().isEmpty()) continue;

            Product product = stringToProduct(line);
            if (product != null) {
                inventory.addProduct(product);
            }
        }

        System.out.println("✓ Products loaded into inventory");

    } catch (FileNotFoundException e) {
        System.out.println("⚠ No products file found");
    } catch (IOException e) {
        System.out.println("✗ Error loading products: " + e.getMessage());
    }
}


    private Product stringToProduct(String line) {
        String[] p = line.split("\\|");

        switch (p[0]) {
            case "DAIRY":
                return new Dairy(p[1], p[2], Double.parseDouble(p[3]),
                        Integer.parseInt(p[4]), p[5], p[6]);

            case "DRY":
                return new Dry(p[1], p[2], Double.parseDouble(p[3]),
                        Integer.parseInt(p[4]), p[5], p[6]);

            case "SNACKS":
                return new Snacks(p[1], p[2], Double.parseDouble(p[3]),
                        Integer.parseInt(p[4]), p[5], p[6]);

            case "HOUSEHOLD":
                return new HouseHold(p[1], p[2], Double.parseDouble(p[3]),
                        Integer.parseInt(p[4]), p[5], p[6]);

            case "PERSONALCARE":
                return new PersonalCare(p[1], p[2], Double.parseDouble(p[3]),
                        Integer.parseInt(p[4]), p[5], p[6]);
        }
        return null;
    }

    public ArrayList<User> loadUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void saveUsers(ArrayList<User> users) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
