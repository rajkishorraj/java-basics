package com.myjavacode.collectionpractice.listpractice;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(0);
//        priorityQueue.poll();  //get and remove
//        priorityQueue.remove();

        System.out.println(priorityQueue.peek());


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); //reverse
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> Integer.compare(b, a));


    }
}
