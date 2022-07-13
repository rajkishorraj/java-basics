package com.myjavacode.thread.threadinteraction;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        Worker worker1 = new Worker(countDownLatch);
        Worker worker2 = new Worker(countDownLatch);
        Worker worker3 = new Worker(countDownLatch);

        worker1.start();
        worker2.start();
        worker3.start();


        System.out.println("Waiting for all task to finish first");
        countDownLatch.await();

        System.out.println("main task finished as well");

    }
}

class Worker extends Thread {
    private CountDownLatch countDownLatch;

    Worker (CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running>>>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
