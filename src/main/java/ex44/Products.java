/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex44;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.*;

// Employees stores a list of employees
public class Products {

    // setup private array list of names
    private ArrayList<Product> productList = new ArrayList<>();

    // constructor
    public Products(String path) {
        // attempt to read products from file
        File input = new File(path);
        try {
            // read JSON from input file
            JsonElement jsonParsed = JsonParser.parseReader(new FileReader(input));
            JsonObject jsonObject = jsonParsed.getAsJsonObject();
            JsonArray jsonProductList = jsonObject.get("products").getAsJsonArray();

            // loop through each product
            for (JsonElement productJson : jsonProductList) {
                JsonObject jsonProduct = productJson.getAsJsonObject();

                // read attributes of product
                String name = jsonProduct.get("name").getAsString();
                float price = jsonProduct.get("price").getAsFloat();
                int quantity = jsonProduct.get("quantity").getAsInt();

                // add product to product list
                this.productList.add(new Product(name, price, quantity));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // replace list with specified list
    public void setProductList(ArrayList<Product> incomingList) {
        this.productList = incomingList;
    }

    // get current product list
    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    // search for product
    public Product searchForProduct(String searchTerm) {
        // search for product
        for (Product product : this.productList)
            if (product.getName().equalsIgnoreCase(searchTerm))
                return product;

        // return empty product by default
        System.out.println("Sorry, that product was not found in our inventory.");
        return new Product("", 0, 0);
    }

}