package com.myjavacode.thread.threadinteraction;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        Thread t1 = new Thread(new Producer(blockingQueue), "T1");
        Thread t2 = new Thread(new Consumer(blockingQueue), "T1");

        t2.start();
        Thread.sleep(2000);
        t1.start();

    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    Producer (BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                blockingQueue.put(i);
                System.out.println("Produced: " + i);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    int taken = -1;

    Consumer (BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(taken != 9) {
            try {
                System.out.println("Waiting to take out: ");
                taken = blockingQueue.take();
                System.out.println("Consumed: " + taken);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}