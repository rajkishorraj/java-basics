package com.myjavacode.exceptionhandling;

import java.util.HashMap;

public class Example1 {
    public static void divide(int a, int b) {
        try {
            int c = a/b;
            System.out.println("sdfs");
        } finally {
            System.out.println("finally");
        }
    }

    public static void divide2(int a, int b) {
        try {
            int c = a/b;
            System.out.println("sdfs");
        } catch (Exception e) {
            System.out.println("divide exception");
        } finally {
            System.out.println("finally");
        }
    }

    public static void method() {};

    public static void firstFunction() throws Exception {
        try {
            divide2(4, 0);
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
        } catch (Exception io) {
            System.out.println("found airthmatic exception");
        } finally {
            System.out.println("running finlayy");
//            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println(methodOne());
//        int i = 0;
//        while(i < 5) {
//            try {
//                method34();
//            } catch (InterruptedException e) {
//                System.out.println("sfsd");
//            }
//            System.out.println("I " + i);
//            i++;
//        }

//        secondFunction();
//        method();
//        firstFunction();
//        throw new CustomException("this is custom exception");

//        Exception exception = method2();
//        exception.printStackTrace();

    }

    public static int methodOne() {
        try {
           int a = 6;
           int b = 4;
           int c = a / b;
           return c;
        } finally {
            return 10;
        }
    }

    public static void method34() throws InterruptedException {
        Thread.sleep(1000);
        throw new RuntimeException("abc");
    }

    public static CustomException method2() {
        CustomException customException = new CustomException("this is custom exception");
        return customException;
    }
    public static CustomException method3() {
       return method2();
    }

}
