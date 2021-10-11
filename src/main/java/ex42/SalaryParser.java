/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SalaryParser {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise42_input.txt";

    public static void main(String[] args) {
        // initialize Names class
        Employees employees = new Employees();

        // read list of employees and populate Employees class
        employees.setEmployeeList(readEmployees(inputPath));

        // parse and display employees' salaries
        System.out.println(employees.formatEmployeeList());
    }

    // read names from file; each line is a new name
    public static ArrayList<Employee> readEmployees(String path) {
        // create temp variable to fill
        ArrayList<Employee> employeeList = new ArrayList<>();

        // read file from path
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) {
                // parse csv from file
                ArrayList<String> parsedCSV = parseCSV(file.next());

                // add newly generated employee to list
                employeeList.add(new Employee(parsedCSV.get(1), parsedCSV.get(0), Integer.parseInt(parsedCSV.get(2))));
            }
        } catch(IOException e) {
            System.out.println(e);
        }

        // return result
        return employeeList;
    }

    // function to parse csv (separates by commas)
    public static ArrayList<String> parseCSV(String rawCSV) {
        return new ArrayList<>(Arrays.asList(rawCSV.split(",")));
    }
}
