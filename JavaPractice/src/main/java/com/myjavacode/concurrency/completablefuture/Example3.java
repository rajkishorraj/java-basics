package com.myjavacode.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture.runAsync(() -> Example2.task("first stage"), executorService)
                .thenRun(() -> Example2.task("second"))
                .thenRunAsync(() -> Example2.task("third stage"), executorService)
                .get();

        System.out.println("exiting main");
        executorService.shutdown();

    }
}
