/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WordFinderTest {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise45_input.txt";

    // static output file path
    static String testOutputPath = "src/main/resources/output_files/exercise45_test_output.txt";

    @Test
    void readNames_OneShouldNeverUtilizeTheWordUtilizeInWritingUseUseInstead() {
        WordFinder wordFinder = new WordFinder();
        Assertions.assertEquals("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.", wordFinder.readPhrases(inputPath).get(0));
    }

    @Test
    void writePhrases_MichaelVuolo() {
        WordFinder wordFinder = new WordFinder();
        Assertions.assertTrue(wordFinder.writePhrases(new ArrayList<String>(Arrays.asList("Michael Vuolo")), testOutputPath));
    }

    @Test
    void replaceOccurrences_HelloWorldMyNameIsWorld_World_There() {
        WordFinder wordFinder = new WordFinder();
        Assertions.assertEquals("[Hello there, my name is there.]", wordFinder.replaceOccurrences(new ArrayList<String>(Arrays.asList("Hello world, my name is world.")), "world", "there").toString());
    }
}

