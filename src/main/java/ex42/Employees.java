/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex42;

import java.util.ArrayList;
import java.util.Collections;

// Employees stores a list of employees
public class Employees {

    // setup private array list of names
    private ArrayList<Employee> employeeList;

    // constructor
    public Employees() {
        // do nothing upon initialization
    }

    // replace list with specified list
    public void setEmployeeList(ArrayList<Employee> incomingList) {
        this.employeeList = incomingList;
    }

    // get current employee list
    public ArrayList<Employee> getEmployeeList() {
        return this.employeeList;
    }

    // format employees
    public String formatEmployeeList() {
        // create header
        String formattedEmployeesOutput = "Last      First     Salary\n" + "--------------------------";

        // gather data from each employee
        for (Employee employee : employeeList)
            formattedEmployeesOutput += "\n" + employee.getLastName() + "    \t" + employee.getFirstName() + "  \t" + employee.getSalary();

        // return result
        return formattedEmployeesOutput;
    }

}