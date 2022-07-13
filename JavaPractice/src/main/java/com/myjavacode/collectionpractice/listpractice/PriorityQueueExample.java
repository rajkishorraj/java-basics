package com.myjavacode.collectionpractice.listpractice;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(0);
        priorityQueue.poll();  //get and remove
        priorityQueue.remove();
        priorityQueue.peek();
    }
}
