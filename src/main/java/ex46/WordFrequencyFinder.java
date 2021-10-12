/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex46;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordFrequencyFinder {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise46_input.txt";

    public static void main(String[] args) {
        // create new scanner
        Scanner input = new Scanner(System.in);

        // read list of names and populate Names class
        ArrayList<String> phraseList = readPhrases(inputPath);

        // count occurances of each word
        displayWordOccurrencesHistogram(countOccurrences(phraseList));
    }

    // read phrases from file
    public static ArrayList<String> readPhrases(String path) {
        // create temp variable to fill
        ArrayList<String> phraseList = new ArrayList<>();

        // read file from path
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) phraseList.add(file.next());
        } catch(IOException e) {
            System.out.println(e);
        }

        // return result
        return phraseList;
    }

    // counts all occurrences of each word in a list of phrases
    public static HashMap<String, Integer> countOccurrences(ArrayList<String> phraseList) {
        // create new hash map to keep track of occurrences
        HashMap<String, Integer> wordHashMap = new HashMap<String, Integer>();

        // loop through each word in each phrase to add to hash map and count occurrences
        for (String phrase : phraseList)
            for (String word : phrase.split(" "))
                if (wordHashMap.get(word) == null)
                    wordHashMap.put(word, 1);
                else
                    wordHashMap.put(word, wordHashMap.get(word) + 1);

        // return sorted hash map result
        return sortHashMap(wordHashMap);
    }

    // sort hash map by value
    public static HashMap<String, Integer> sortHashMap(HashMap<String, Integer> hashMap) {
        // create a new list with hash map values
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());

        // sort hash map values
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        // reverse collections to make sure its greatest to least
        Collections.reverse(list);

        // create new hash map sorted in new order
        HashMap<String, Integer> newHashMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
            newHashMap.put(entry.getKey(), entry.getValue());

        // return sorted result
        return newHashMap;
    }

    // displays list of words and each of their occurrences (in asterisks)
    public static void displayWordOccurrencesHistogram(HashMap<String, Integer> hashMap) {
        for (String key : hashMap.keySet())
            System.out.println(String.format("%s: %s", key, convertIntToAsterisks(hashMap.get(key))));
    }

    // results in a string filled with n asterisks
    public static String convertIntToAsterisks(int numAsterisks) {
        // create temp variable to store asterisks
        String asterisksString = "";

        // loop through and append each asterisk
        for (int i = 0; i < numAsterisks; i++)
            asterisksString += "*";

        // return asterisks
        return asterisksString;
    }
}
