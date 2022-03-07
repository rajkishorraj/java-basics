package com.myjavacode.executorservice;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main started");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        int[] ar = new int[1];

        AtomicInteger counter = new AtomicInteger();

        Runnable task1 = () -> {
            counter.getAndIncrement();
            if (counter.get() == 1) {
                ar[0] = 5;
                countDownLatch.countDown();
            }
            System.out.println("Executing the task1 at: " + LocalDateTime.now()  + " -- " + Thread.currentThread().getName());

        };

        LocalDateTime startedTime = LocalDateTime.now();
        System.out.println("Scheduling task to run after 5 seconds... " + LocalDateTime.now());
        ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
        System.out.println("Scheduling task to run after 5 seconds started... " + LocalDateTime.now());


//        if (LocalDateTime.now()  startedTime.plusSeconds(20)) {
//            future.cancel(true);
//            scheduledExecutorService.shutdown();
//        }
        countDownLatch.await(60, TimeUnit.SECONDS);
        scheduledExecutorService.shutdownNow();

        System.out.println("Thread main finished");
    }
}
