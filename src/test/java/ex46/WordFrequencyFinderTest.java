/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WordFrequencyFinderTest {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise46_input.txt";

    @Test
    void readNames_BadgerBadgerBadger() {
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder();
        Assertions.assertEquals("badger badger badger", wordFrequencyFinder.readPhrases(inputPath).get(0));
    }

    @Test
    void countOccurrences_aaabbc() {
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder();
        Assertions.assertEquals(3, wordFrequencyFinder.countOccurrences(new ArrayList<String>(Arrays.asList("a a a b b c"))).get("a"));
    }

    @Test
    void convertIntToAsterisks_7() {
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder();
        Assertions.assertEquals("*******", wordFrequencyFinder.convertIntToAsterisks(7));
    }
}

