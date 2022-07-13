package com.myjavacode.immutableclass;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String... args) {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("raj", "patna");
        Student student = new Student("raj", 23, tempMap);
        tempMap.put("abc", "abcd");
        student.getMetadata().put("abc", "abcd");


        System.out.println(student.getMetadata());

    }
}

