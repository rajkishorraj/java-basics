package com.myjavacode.coll;

import javafx.util.Pair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListColl {

    public static void main(String [] args) throws URISyntaxException {
//
//        List<Integer> list = new ArrayList<>();
//        list.add(6);
//        list.add(4);
//        list.sort(Comparator.comparingInt(Integer::intValue));
//        System.out.println(list);
//        Thread.yield();

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
