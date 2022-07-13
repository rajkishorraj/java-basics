package com.myjavacode.thread.threadinteraction;

public class ThreadA {

    public static void main(String [] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();

//        Thread.sleep(1000);

        synchronized (threadB) {
            System.out.println("inside sync block of threadA");
            try {
                System.out.println("releasing lock for thread b to complete the sum");
                threadB.wait(1000);
                System.out.println("waiting completed");
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println("Total: " + threadB.total);
        }

    }
}

class ThreadB extends Thread  {
    int total = 0;

    public void run() {
        System.out.println("inside run of ThreadB");
        synchronized (this) {
            for (int i = 0; i < 100 ; i++) {
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