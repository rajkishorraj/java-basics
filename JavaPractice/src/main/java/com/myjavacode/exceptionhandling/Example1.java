package com.myjavacode.exceptionhandling;

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


//        secondFunction();
//        method();
//        firstFunction();
//        throw new CustomException("this is custom exception");

        Exception exception = method2();
        exception.printStackTrace();


    }

    public static CustomException method2() {
        CustomException customException = new CustomException("this is custom exception");
        return customException;
    }
    public static CustomException method3() {
       return method2();
    }

}
