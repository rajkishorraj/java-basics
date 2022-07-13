package com.myjavacode.thread;

public class DeadLockExample {

    public static void main(String[] args) {
        String resource1 = "Resource 1";
        String resource2 = "Resource 2";

        Runnable runnable1 = () -> {
            System.out.println("running runnable 1");
            synchronized (resource1) {
                System.out.println("locking resource 1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("locking resource 2");
                }
                System.out.println("resource 2 released");
            }
            System.out.println("resource 1 released");
        };

        Runnable runnable2 = () -> {
            System.out.println("running runnable 2");
            synchronized (resource2) {
                System.out.println("locking resource 2");
                synchronized (resource1) {
                    System.out.println("locking resource 1");
                }
                System.out.println("resource 1 released");
            }
            System.out.println("resource 2 released");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

}
