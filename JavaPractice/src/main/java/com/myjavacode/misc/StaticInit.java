package com.myjavacode.misc;

public class StaticInit {

    public static void main(String[] args) {
        new abc().method();
    }
}

class abc extends bcd {

    @Override
    public void method() {
        super.method();
        System.out.println("in class abc");
    }
}

abstract class bcd {

    public void method() {
        System.out.println("doing something");
    }

}