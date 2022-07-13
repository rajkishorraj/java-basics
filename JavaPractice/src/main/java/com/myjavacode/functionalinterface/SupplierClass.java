package com.myjavacode.functionalinterface;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SupplierClass {

    public static void main(String [] args) {
        Supplier<Integer> sp = () -> 42;

        Supplier<Integer> sp2 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        };

        String aa = "java practice";
        String b = "lambda expression";
        Consumer<String> cm = (some) -> System.out.println("practicing: " + some);

        cm.accept("sd");
        System.out.println("supplier: " + sp.get());

        BiConsumer<Integer, String>  bcm= (a, c) -> System.out.println(c + "has value: " + a);
        bcm.accept(5, "raj");


        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 0;
            }
        };

        predicate.test("res");


        Function<Integer, String> function = new Function<Integer, String>() {

            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };

        function.apply(7); //biFunction accepts two argument
        BiFunction<String, String, Integer> biFunction = new BiFunction<String, String, Integer>() {
            @Override
            public Integer apply(String s, String s2) {
                return null;
            }
        };

        UnaryOperator<String> unaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        }; //it extends function functional interface and it has same input and return type




        new ArrayList<>().forEach(System.out::println); //for each accepts consumer
        //and it accepts biconsumer in case of map


    }
}
