/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void isAnagram_False() {
        App anagram = new App();
        Assertions.assertFalse(anagram.isAnagram("tone", "part"));
        Assertions.assertFalse(anagram.isAnagram("tone", "ent"));
    }

    @Test
    public void isAnagram_True() {
        App anagram = new App();
        Assertions.assertTrue(anagram.isAnagram("tone", "enot"));
    }
}

