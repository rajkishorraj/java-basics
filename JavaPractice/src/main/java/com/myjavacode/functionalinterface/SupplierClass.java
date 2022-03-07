package com.myjavacode.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierClass {

    public static void main(String [] args) {
        Supplier<Integer> sp = () -> 42;

        String aa = "java practice";
        String b = "lambda expression";
        Consumer<String> cm = (some) -> System.out.println("practicing: " + some);

        cm.accept("sd");
        System.out.println("supplier: " + sp.get());
    }
}
