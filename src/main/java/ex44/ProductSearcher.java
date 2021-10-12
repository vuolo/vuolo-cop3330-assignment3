/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex44;

import java.util.Scanner;

public class ProductSearcher {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise44_input.json";

    public static void main(String[] args) {
        // create new scanner
        Scanner input = new Scanner(System.in);

        // create new empty product
        Product foundProduct = new Product("", 0, 0);

        // store products
        Products products = new Products(inputPath);

        // keep track of search term
        String curSearchTerm;

        // continue search for product while name is empty
        while (foundProduct.getName() == "") {
            // prompt for a product name to search
            System.out.print("What is the product name? ");
            curSearchTerm = input.nextLine();

            // search for product
            foundProduct = products.searchForProduct(curSearchTerm);
        }

        // display product information
        foundProduct.display();
    }

}
