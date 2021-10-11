/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WebsiteGenerator {
    // setup directory of website
    static String websitesDirectory = "src/main/java/ex43/website/";

    public static void main(String[] args) {
        // create new scanner
        Scanner input = new Scanner(System.in);

        // prompt for website details
        System.out.print("Site name: ");
        String siteName = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript?: ");
        boolean shouldCreateJSFolder = input.nextLine().equalsIgnoreCase("y");
        System.out.print("Do you want a folder for CSS?: ");
        boolean shouldCreateCSSFolder = input.nextLine().equalsIgnoreCase("y");

        // generate website skeleton
        generateWebsite(siteName, author, shouldCreateJSFolder, shouldCreateCSSFolder);
    }

    // creates skeleton of a new website
    public static void generateWebsite(String siteName, String author, boolean shouldCreateJSFolder, boolean shouldCreateCSSFolder) {
        // format new directory
        String curDirectory = websitesDirectory + siteName;

        // create directory
        createFileIfDoesntExist(curDirectory, true);
        System.out.println("Created ./website/" + siteName);

        // generate index.html
        genIndexHTML(curDirectory + "/index.html", siteName, author);
        System.out.println("Created ./website/" + siteName + "/index.html");

        // generate JS folder if specified
        if (shouldCreateJSFolder) {
            createFileIfDoesntExist(curDirectory + "/js", true);
            System.out.println("Created ./website/" + siteName + "/js/");
        }

        // generate CSS folder if specified
        if (shouldCreateCSSFolder) {
            createFileIfDoesntExist(curDirectory + "/css", true);
            System.out.println("Created ./website/" + siteName + "/css/");
        }
    }

    // generates and index.html with site name and author displayed
    public static boolean genIndexHTML(String path, String siteName, String author) {
        // ensures file is created to prevent issues writing
        createFileIfDoesntExist(path, false);

        // begin writing to file
        try (FileWriter w = new FileWriter(path)) {
            // write header of index.html
            String header = String.format("<head>\n\t<title>%s</title>\n\t<meta name=\"author\" content=\"%s\">\n</head>", siteName, author);
            w.write(header);
        } catch (IOException e) {
            return false;
        }

        // wrote safely and correctly
        return true;
    }

    // creates a file if not already existing
    public static void createFileIfDoesntExist(String path, boolean isDirectory) {
        File file = new File(path);
        try {
            if (isDirectory)
                file.mkdir();
            else
                file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
