/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex44;

// Product keeps track of a product and it's attributes
public class Product {

    // setup private attributes
    private String name;
    private float price;
    private int quantity;

    // constructor
    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // update name
    public void setName(String name) {
        this.name = name;
    }

    // get name
    public String getName() {
        return this.name;
    }

    // update price
    public void setPrice(float price) {
        this.price = price;
    }

    // get price
    public float getPrice() {
        return this.price;
    }

    // update quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // get quantity
    public int getQuantity() {
        return this.quantity;
    }

    // neatly display product information
    public void display() {
        System.out.println(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", this.name, this.price, this.quantity));
    }

}