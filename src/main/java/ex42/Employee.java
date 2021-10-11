/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex42;

// Employee include first/last name and salary
public class Employee {

    // setup private attributes
    private String firstName;
    private String lastName;
    private int salary;

    // constructor
    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // update first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // get first name
    public String getFirstName() {
        return this.firstName;
    }

    // update last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // get last name
    public String getLastName() {
        return this.lastName;
    }

    // update salary
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // get salary
    public int getSalary() {
        return this.salary;
    }

}