package com.myjavacode.stringexample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CharacterClassExample {

    public static void main(String[] args) {
        String str2 = "" + (char)('A' + 57);

        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> (int)b[1] - (int)a[1]);

        Integer [] charArr = new Integer[26];
        Arrays.fill(charArr, 4);

        String str = String.join("", Collections.nCopies(5, "a"));
        Arrays.sort(charArr, Comparator.reverseOrder());
    }

    public void method() {
        Character ch = new Character('6');
        Character ch2 = 't';

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

    public void stringOperation() {
        String str = "678";
        int num = str.charAt(0) - '0';

        String newStr = num + "";

    }

    public void moreOperaiton() {
        String str2 = "" + (char)('a' + 5);
        System.out.println(str2);



        Integer [] charArr = new Integer[26];
        Arrays.fill(charArr, 4);
        String str = String.join("", Collections.nCopies(5, "a"));
        System.out.println(str);

        String s = "dffsywpqrs";
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
        }
        Arrays.sort(charArr, Comparator.reverseOrder());
    }
}
