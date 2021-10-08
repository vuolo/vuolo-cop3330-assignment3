/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Vuolo
 */

package ex41;

import java.util.ArrayList;
import java.util.Collections;

// Names stores a list of names and allows for sorting
public class Names {

    // setup private array list of names
    private ArrayList<String> nameList;

    // constructor
    public Names() {
        // do nothing upon initialization
    }

    // replace list with specified list
    public void setNameList(ArrayList<String> incomingList) {
        this.nameList = incomingList;
    }

    // get current name list
    public ArrayList<String> getNameList() {
        return this.nameList;
    }

    // sort names
    public ArrayList<String> sortNameList() {
        Collections.sort(this.nameList);
        return this.nameList;
    }

    // return size of name list
    public int size() {
        return this.nameList.size();
    }
}