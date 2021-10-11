/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalaryParserTest {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise42_input.txt";

    @Test
    void readEmployees_JonesChris34500() {
        SalaryParser salaryParser = new SalaryParser();
        Assertions.assertEquals(34500, salaryParser.readEmployees(inputPath).get(3).getSalary());
    }

    @Test
    void parseCSV_abc() {
        SalaryParser salaryParser = new SalaryParser();
        Assertions.assertEquals("[a, b, c]", salaryParser.parseCSV("a,b,c").toString());
    }
}

