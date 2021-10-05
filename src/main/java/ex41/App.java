/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex41;

import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // create new scanner
        Scanner input = new Scanner(System.in);

        // prompt for two strings
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        System.out.print("Enter the first string: ");
        String string1 = input.nextLine();
        System.out.print("Enter the second string: ");
        String string2 = input.nextLine();

        // output based on if anagram
        if (isAnagram(string1, string2))
            System.out.print("\"" + string1 + "\" and \"" + string2 + "\" are anagrams.");
        else
            System.out.print("\"" + string1 + "\" and \"" + string2 + "\" are not anagrams.");
    }

    // check whether strings are anagrams of each other
    public static boolean isAnagram(String string1, String string2) {
        // convert to char array
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();

        // strings must be same length to be an anagram
        if (charArray1.length != charArray2.length)
            return false;

        // sort char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // compare sorted strings
        if (!new String(charArray1).equals(new String(charArray2)))
            return false;

        // it's an anagram!
        return true;
    }
}
