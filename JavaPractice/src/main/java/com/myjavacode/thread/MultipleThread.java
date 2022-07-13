package com.myjavacode.thread;

public class MultipleThread {

    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Executed by thread: " + Thread.currentThread().getName()
                + " i is " + i);
            }

        };

        Thread one = new Thread(r);
        Thread two = new Thread(r);
        Thread three = new Thread(r);

        one.setName("Fred");
        two.setName("Lucky");
        three.setName("Ricky");

        one.start();
        two.start();
        three.start();


    }
}
