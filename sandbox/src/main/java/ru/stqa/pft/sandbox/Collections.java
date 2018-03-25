package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
//========Array
        String[] langs = {"Java", "C#", "Python", "PHP"};
        for (String l : langs) {
            System.out.println("I want to learn " + l);
        }

//========List
        //adding elements one by one
      /*  List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C#");*/
        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l : languages) {
            System.out.println("I want to learn " + l);
        }

        //cycle with counter
       /* for (int i = 0; i < languages.size(); i++) {
            System.out.println("I want to learn " + languages.get(i));
        }*/


//========List with elements of differents types
        List diffTypesList = Arrays.asList("Java", "C#", "Python", "PHP");
        for (Object l : diffTypesList) {
            System.out.println("I want to learn " + l);
        }
    }
}
