package com.myjavacode.sortingg;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainClass {
    public static void divide(int a, int b) {
        try {
            int c = a/b;
            System.out.println("sdfs");
        } finally {
            System.out.println("finally");
        }
    }

    public static void method() {};

    public static void firstFunction() throws Exception {
        try {
            divide(4, 0);
        } catch (Exception e) {
            System.out.println("found exception");
        } finally {
            System.out.println("running finlayy");
            throw new Exception();
        }
    }

    public static void secondFunction() throws Exception {
        try {
            divide(4, 0);
        } catch (NullPointerException io) {
            System.out.println("found exception");
        } finally {
            System.out.println("running finlayy");
//            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {

//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5));
//        Comparator<Integer> comparatorDesc = (a, b) -> b.compareTo(a); //Comparator.reverseOrder();
//        Comparator<Integer> comparatorAsc = (a, b) -> a.compareTo(b); //Integer:: compareTo;
//
//        list.sort(comparatorDesc);
//        System.out.println(list);
//        secondFunction();
        method();
        System.out.println("sdfsdf");

    }
}
