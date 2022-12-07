package com.myjavacode.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckAsync {
    public static void main(String[] args) {

        AsyncCall asyncCall = new AsyncCall();

        for (int i = 0; i < 20; i++) {
            asyncCall.method();
        }

        System.out.println("main finished: " + Thread.currentThread().getName());
    }
}

class AsyncCall {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    int counter = 1;
    public void method() {
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("waiting for start, cnt:" + counter++ + " t: " + Thread.currentThread().getName());
                System.out.println("waiting done");
                if (counter ==14 || counter == 15 || counter == 16 || counter == 17) {
                    System.out.println("exception founddddddddddddddddddddddddd");
                    throw new RuntimeException();
                }
            } catch (RuntimeException| InterruptedException e) {
                System.out.println("after founddddddddddddddddddddddddd");
                throw new RuntimeException(e);
            }
        });
    }

}