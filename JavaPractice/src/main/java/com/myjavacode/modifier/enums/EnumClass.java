package com.myjavacode.modifier.enums;

import java.util.Arrays;

public class EnumClass {
    EnumWithInstanceVariable size;

    public enum CoffeeSize {
        BIG, HUGE, OVERWHELMING;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }

        }

    public static void main(String [] args) {
        CoffeeSize cs = CoffeeSize.BIG;
        System.out.println(cs.toString());

        EnumClass enumClass = new EnumClass();
        enumClass.size = EnumWithInstanceVariable.BIG;
        System.out.println(enumClass.size.getOunces());

        for (EnumWithInstanceVariable eiv: EnumWithInstanceVariable.values()) {
            System.out.println(eiv + " " + eiv.getOunces());
        }

    }
}
