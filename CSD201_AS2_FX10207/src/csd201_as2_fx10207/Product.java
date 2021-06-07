/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

/**
 *
 * @author Admin
 */
public class Product {

    int stock;
    String productId, productName;
    double productPrice;

    /**
     * @constructor
     */
    public Product() {
    }

    /**
     * @constructor overloading with all field
     * @param productId
     * @param productName
     * @param productPrice
     * @param stock
     */
    public Product(String productId, String productName, double productPrice, int stock) {
        this.productId = productId;
        this.stock = stock;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-15s%-5s%-7.1f%-5s%s", productId, "|", productName, "|", productPrice, "|", stock);
    }

}
