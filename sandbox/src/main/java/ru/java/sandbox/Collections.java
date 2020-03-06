package ru.java.sandbox;

public class Collections {
    public static void main (String[] arg) {
       //String [] langs = new String[4];
        String[] langs = {"Java", "C#", "Python", "PHP"};

        // Perebor Option 1: Start with index 0, till last one, with step 1
       // for (int i = 0; i < langs.length; i++) {
            //System.out.println("I want to learn " + langs[i]);


            // Perebor Option 2: Start with index 0, till last one, with step 1
            for (String l : langs) {
                System.out.println("I want to learn " + l);

        }
    }
}
