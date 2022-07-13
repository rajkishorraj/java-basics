package com.myjavacode.generics;

public class Blocks {

    int x = 10;
    static int y = 25;

    Blocks() {
        System.out.println("inside constructor");
        x = 15;
    }

    static {
        System.out.println("inside static block");
         y = 16;
    }

    {
        System.out.println("inside instance block");
        x = 35;
    }

    public static void main(String[] args) {
        System.out.println("running main");
        Blocks blocks =new Blocks();
        System.out.println(blocks.x);


    }
}
