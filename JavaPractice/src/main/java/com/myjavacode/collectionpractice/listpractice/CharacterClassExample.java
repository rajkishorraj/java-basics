package com.myjavacode.collectionpractice.listpractice;

import java.util.HashMap;
import java.util.Map;

public class CharacterClassExample {

    public static void main(String[] args) {
        Character ch = new Character('6');
        System.out.println(ch.charValue() + " " + Character.isDigit('6'));
        System.out.println(ch.charValue() + " " + Character.getNumericValue('a'));

        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            char a = (char) ('a' + i);
            mp.put(new Character(a), i);
        }

        mp.forEach((key, value) -> System.out.println(key + " " + value));

        Integer a = new Integer(5);
        a = 5;

        System.out.println(a);
        String x = "sdfsfd";
        x = "sdfsf";

        System.out.println(x);


    }
}
