package com.myjavacode.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ListColl2 {

    public static void main(String [] args) {

        List<String> arraylist = new ArrayList<>();
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 != i2);

        arraylist.sort(Comparator.comparingInt(String::length));

        method();
    }

    public static void method() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3))); //deep copy
        Stack<Integer> stack = new Stack<>();

        System.out.println(list);
    }
}
