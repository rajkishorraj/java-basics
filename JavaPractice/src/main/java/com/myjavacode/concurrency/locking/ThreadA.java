package com.myjavacode.concurrency.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadA {

    public static void main(String [] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();

        Thread.sleep(1000);

        Lock lock = new ReentrantLock(true);
        boolean isLocked = lock.tryLock();

        System.out.println("checking if locked acquired: " + isLocked);
        if (isLocked) {
            System.out.println("inside sync block of threadA");
            try {
                System.out.println("total sum: " + threadB.total);

            } finally {
                lock.unlock();
            }
            System.out.println("after printing total");
        }

        System.out.println("Checking if it runs first if locked is not acquired");

    }
}



class ThreadB extends Thread  {
    int total = 0;

    public void run() {

        System.out.println("inside run of ThreadB");
        synchronized (this) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            for (int i = 0; i < 1000 ; i++) {
                total += i;
            }
            notify();
            System.out.println("completed the sum: " + total);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        System.out.println("getting out of the run: ");
    }
}