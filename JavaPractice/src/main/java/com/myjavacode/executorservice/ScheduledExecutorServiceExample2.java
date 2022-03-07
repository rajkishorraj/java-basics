package com.myjavacode.executorservice;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledExecutorServiceExample2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main started");

        AtomicInteger counter = new AtomicInteger();
        Runnable task1 = () -> {
            int i = 1;
            i = i+ 1;
            System.out.println("Executing the task1 at: " + LocalDateTime.now() + " -- " + counter.getAndIncrement() + " -- " + Thread.currentThread().getName());

            if ( i == 2) {
                System.out.println("raj");
            }
            i = i - 1;
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        LocalDateTime startedTime = LocalDateTime.now();
        System.out.println("Scheduling task to run after 5 seconds... " + LocalDateTime.now());
        ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> future1 = scheduledExecutorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
        System.out.println("Scheduling task to run after 5 seconds started... " + LocalDateTime.now());
////
//        if (LocalDateTime.now()  startedTime.plusSeconds(20)) {
//            future.cancel(true);
//            scheduledExecutorService.shutdown();
//        }

        System.out.println("Thread main finished");
    }
}
