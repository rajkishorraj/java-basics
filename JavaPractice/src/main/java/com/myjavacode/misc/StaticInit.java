package com.myjavacode.misc;

public class StaticInit {

    public static void main(String[] args) {
        new abc().method();
        new abc().method();
    }
}

class abc extends bcd {

    static {
        System.out.println("child class abc static block");
    }
    {
        System.out.println("child class abc instance block");
    }

    abc() {
        System.out.println("child class abc constructor ");
    }
    @Override
    public void method() {
        super.method();
        System.out.println("in class abc");
    }
}

abstract class bcd {

    static {
        System.out.println("Parent class static block");
    }

     {
        System.out.println("Parent class instance block");
    }

    bcd() {
        System.out.println("parent class constructor");
    }

    public void method() {
        System.out.println("doing something in method");
    }

}