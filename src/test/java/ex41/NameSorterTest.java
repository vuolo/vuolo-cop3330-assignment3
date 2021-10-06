/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NameSorterTest {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise41_input.txt";

    // static output file path
    static String testOutputPath = "src/main/resources/output_files/exercise41_test_output.txt";

    @Test
    void readNames_JonesChris() {
        NameSorter nameSorter = new NameSorter();
        Assertions.assertEquals("Jones, Chris", nameSorter.readNames(inputPath).get(3));
    }

    @Test
    void writeNames_MichaelVuolo() {
        NameSorter nameSorter = new NameSorter();
        Assertions.assertTrue(nameSorter.writeNames(new ArrayList<String>(Arrays.asList("Michael Vuolo")), testOutputPath));
    }
}

