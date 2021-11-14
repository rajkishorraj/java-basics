package com.myjavacode.modifier.enums;

enum CoffeeSize3 {
    BIG, HUGE, OVERWHELMING
}

class Coffee {
    enum CoffeeSize2 {
        BIG, HUGE, OVERWHELMING
    }
}
public class CoffeeTest {

    public static void main(String [] args) {
        Coffee.CoffeeSize2 size = Coffee.CoffeeSize2.BIG;
        CoffeeSize3 size3 = CoffeeSize3.BIG;
    }
}
