/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {
    // static input file path
    static String inputPath = "src/main/resources/input_files/exercise45_input.txt";

    // static output file path
    static String outputPath = "src/main/resources/output_files/";

    public static void main(String[] args) {
        // create new scanner
        Scanner input = new Scanner(System.in);

        // read list of names and populate Names class
        ArrayList<String> phraseList = readPhrases(inputPath);

        // prompt for output file name
        System.out.print("Output file name (discluding file extention): ");
        String outputFileName = input.nextLine();

        // update phrases and write to file
        writePhrases(replaceOccurances(phraseList, "utilize", "use"), outputPath + outputFileName + ".txt");
        System.out.println("All occurances of \"utilize\" successfully replaced with \"use\".");
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

    // write phrases to file
    public static boolean writePhrases(ArrayList<String> phrases, String path) {
        // ensures file is created to prevent issues writing
        createFileIfDoesntExist(path);

        // begin writing to file
        try (FileWriter w = new FileWriter(path)) {
            // write phrases
            for (String phrase : phrases)
                w.append(phrase).append("\n");
        } catch (IOException e) {
            return false;
        }

        // wrote safely and correctly
        return true;
    }

    // creates a file if not already existing
    public static void createFileIfDoesntExist(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // replaces all occurances of a string in a list of phrases
    public static ArrayList<String> replaceOccurances(ArrayList<String> phraseList, String oldWord, String newWord) {
        for (int i = 0; i < phraseList.size(); i++)
            phraseList.set(i, phraseList.get(i).replace(oldWord, newWord));
        return phraseList;
    }
}
