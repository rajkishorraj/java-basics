package com.myjavacode.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueues {
    public static void main(String [] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

        String a = new String("Raj");
        String b = new String("Raj");

        String ab = "raj";
        String ba = "raj";

        System .out.println(a == b);
        System .out.println(ab == ba);

        Runnable runnable = () -> {
            if (blockingQueue.size() > 0) {
                blockingQueue.poll();
            }
        };

        Thread two = new Thread(runnable);
        two.start();


        try {
            blockingQueue.put(3);
            blockingQueue.put(4); //since size is one thread will get blocked here unless 3 is removed
            System.out.println("priniting");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            System.out.println("dfsf");
        }

    }
}
