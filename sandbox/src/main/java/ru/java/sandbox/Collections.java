package ru.java.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main (String[] arg) {
       //String [] langs = new String[4];
        String[] langs = {"Java", "C#", "Python", "PHP"};

        //List, add value to List
        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");

        for (String l : languages) {
            System.out.println("I want to learn " + l);

        // Perebor Massiva Option 1: Start with index 0, till last one, with step 1
       // for (int i = 0; i < langs.length; i++) {
            //System.out.println("I want to learn " + langs[i]);


            // Perebor Massiva Option 2: Start with index 0, till last one, with step 1
            //for (String l : langs) {
                //System.out.println("I want to learn " + l);

        }
    }
}
