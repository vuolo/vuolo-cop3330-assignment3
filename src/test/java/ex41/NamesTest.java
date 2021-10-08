/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NamesTest {
    @Test
    void sortNamesList_abc() {
        Names names = new Names();
        names.setNameList(new ArrayList<String>(Arrays.asList("c", "b", "a")));
        Assertions.assertEquals("[a, b, c]", names.sortNameList().toString());
    }
}

