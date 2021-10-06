/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

// This pseudocode will help you determine where and how your code should be broken up into classes and methods.
// If you have a comment describing what multiple statements accomplish, those statements probably need to be extracted into a method.
// If you find that your class has multiple methods which form subgroups that each do something completely different,
// you probably need to extra one of those subgroups into a new class.

// PSEUDOCODE: (write this before Java code)
/*

 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSorter {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise41_input.txt";

    // static output file path
    static String outputPath = "src/main/resources/output_files/exercise41_output.txt";

    public static void main(String[] args) {
        // initialize Names class
        Names names = new Names();

        // read list of names and populate Names class
        names.setNameList(readNames(inputPath));

        // sort names and write to file
        writeNames(names.sortNamesList(), outputPath);
    }

    // read names from file; each line is a new name
    public static ArrayList<String> readNames(String path) {
        // create temp variable to fill
        ArrayList<String> namesList = new ArrayList<>();

        // read file from path
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) namesList.add(file.next());
        } catch(IOException e) {
            System.out.println(e);
        }

        // return result
        return namesList;
    }

    // write names to file (including a header)
    public static boolean writeNames(ArrayList<String> names, String path) {
        // ensures file is created to prevent issues writing
        createFileIfDoesntExist(path);

        // begin writing to file
        try (FileWriter w = new FileWriter(path)) {
            // write header first
            String header = String.format("Total of %d names\n-----------------\n", names.size());
            w.write(header);

            // then write names
            for (String name : names)
                w.append(name).append("\n");
        } catch (IOException e) {
            return false;
        }

        // wrote safely and correctly
        return true;
    }

    // creates a file if not already existing
    public static void createFileIfDoesntExist(String path) {
        File file = new File(path);
        try {
            boolean fileCreated = file.createNewFile();
            if (!fileCreated)
                file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
