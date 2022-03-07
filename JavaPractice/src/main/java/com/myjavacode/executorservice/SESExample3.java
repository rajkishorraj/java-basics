package com.myjavacode.executorservice;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SESExample3 {
    private static Future<?> scheduledFuture;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main started");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        AtomicInteger counter = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runnable task1 = () -> {

            System.out.println("Executing the task1 at: " + LocalDateTime.now()  + " -- " + counter.get());

            if (counter.getAndIncrement() == 1000) {
                 countDownLatch.countDown();
                 scheduledFuture.cancel(false);
             }

        };

        System.out.println("Scheduling task to run after 5 seconds... " + LocalDateTime.now());
        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
        System.out.println("Scheduling task to run after 5 seconds started... " + LocalDateTime.now());

        countDownLatch.await(10, TimeUnit.SECONDS);

//        scheduledExecutorService.awaitTermination(2, TimeUnit.SECONDS);


        System.out.println("Thread main finished");
    }
}
