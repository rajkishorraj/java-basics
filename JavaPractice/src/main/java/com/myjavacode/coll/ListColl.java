package com.myjavacode.coll;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListColl {

    public static boolean extractQueueIdFromQueueUrl(URI queueUrl) {

        return Optional.of(Pattern
                .compile("(.*)(/queue/item/)(\\d+)$")
                .matcher(queueUrl.toString())
                .find())
                .get();

    }

    public boolean checkValidString(String s) {

        int minOpenParanthesis = 0;
        int maxOpenParanthesis = 0; //both can be treated as same except when it comes to *

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                minOpenParanthesis++;
                maxOpenParanthesis++;
            } else if (ch == ')') {
                minOpenParanthesis--;
                maxOpenParanthesis--;
            } else {
                minOpenParanthesis = Integer.max(0, minOpenParanthesis - 1);
                maxOpenParanthesis++;
            }

            if (maxOpenParanthesis < 0) {
                return false;
            }
        }

        return minOpenParanthesis == 0;


    }

    public static void main(String [] args) throws URISyntaxException {

//        System.out.println(ListColl.extractQueueIdFromQueueUrl((URI)null));

        List<String> st = new ArrayList<>(Arrays.asList("Raj", "SSS")).stream().map(String::toLowerCase).collect(Collectors.toList());
        st.add("ds");
        st.stream().map(String::toLowerCase);

        System.out.println(st);




//
//        AtomicInteger count = new AtomicInteger(0);
//
//        st.forEach(s -> {
//            if (s.length() > 0) {
//                count.getAndIncrement();
//            }
//        });
//
//        Set<String> ssft = new HashSet<>();












//        System.out.println(count);


    }
}
