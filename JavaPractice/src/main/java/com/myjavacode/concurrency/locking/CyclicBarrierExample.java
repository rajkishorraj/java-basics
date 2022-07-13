package com.myjavacode.concurrency.locking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    List<String> list = new ArrayList<>();
    final CyclicBarrier cyclicBarrier;
    static String[] dogs1 = {"boi", "clover", "charis"};
    static String[] dogs2 = {"bok", "clovet", "charist"};


    class ProcessDogs implements Runnable {
        String [] dogs;
        ProcessDogs (String [] d) {
            dogs = d;
        }

        @Override
        public void run() {
            for (int i = 0; i < dogs.length; i++) {
                String dogName = dogs[i];
                dogName = dogName.substring(0,1).toUpperCase() + dogName.substring(1);
                dogs[i] = dogName;
            }
            try {
                cyclicBarrier.await(); //all threads will wait here until the last thread reaches here.
                System.out.println(Thread.currentThread().getName() + " is waiting ");
            } catch (InterruptedException | BrokenBarrierException exception) {
                exception.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " is done ");

        }
    }

    public CyclicBarrierExample() {
        cyclicBarrier = new CyclicBarrier(2 , ( ) -> { // 2threads 1 runnable

            for (int i = 0; i < dogs1.length; i++) {
            list.add(dogs1[i]);
            }
            for (int i = 0; i < dogs2.length; i++) {
                list.add(dogs2[i]);
            }

            System.out.println(Thread.currentThread().getName() + " is done and result " + list );
        });

        Thread t1 = new Thread(new ProcessDogs(dogs1));
        Thread t2 = new Thread(new ProcessDogs(dogs1));
        t1.start();
        t2.start();

        System.out.println("Main thread is done");

    }

    public static void main(String[] args) {
        CyclicBarrierExample cyclicBarrierExample = new CyclicBarrierExample();

    }
}
