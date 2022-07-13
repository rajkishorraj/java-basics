package com.myjavacode.thread.threadinteraction;

public class PrintSequenceUsingThreeThreads {

    public static void main(String[] args) {

        PrinterRunnable p1 = new PrinterRunnable(1);
        PrinterRunnable p2 = new PrinterRunnable(2);
        PrinterRunnable p3 = new PrinterRunnable(0);

        Thread t1 = new Thread(p1, "T1");
        Thread t2 = new Thread(p2, "T2");
        Thread t3 = new Thread(p3, "T3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("All threads have been started");

    }
}

class PrinterRunnable implements Runnable {
    private int remainder;
    private static int num = 1;
    private static int maxNum = 10;
    private static final Object object =  new Object();

    PrinterRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        while(num < maxNum - 1) {
            synchronized (object) {
                while (num % 3 != remainder) {
                    try {
                        object.wait();
                    } catch (InterruptedException interruptedException) {
                        System.out.println("interrupted " + interruptedException);
                    }
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " " + num);
                num++;
                object.notifyAll();
            }
        }
    }
}




