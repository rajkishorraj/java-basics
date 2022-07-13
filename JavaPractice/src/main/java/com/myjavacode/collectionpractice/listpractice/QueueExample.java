package com.myjavacode.collectionpractice.listpractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(5); //it will throw exception if element is not added due to size restiriction
        System.out.println(q.element()); //retrieves and delete the head,, if queue is empty then throws exception
        q.offer(6); //it will either return true or false if added or not added
        q.peek(); //retireve but the does not remove the head of the queue
        q.poll(); //retrieves and remove the head of the qeueue,, null if queue is empty
        q.remove(); //retrieves and remove the head of the qeueue.. execption if queue is empty


        Deque<Integer> deque  = new ArrayDeque<>();

        //add first will add element at front of the queue.. i.e., at zeroth index

        deque.addFirst(7);
        deque.addFirst(8); //execption if no space is there
        System.out.println(deque);
        deque.addLast(9); /// it will 8 7 9
        deque.addLast(10); /// it will 8 7 9 10
        deque.addLast(11); /// it will 8 7 9 11
        System.out.println(deque);
//        deque.offerFirst(10); deque.offerLast(11); //returns true or false
        System.out.println(deque.peekFirst()); //retireives not remove,, null if q empty.. element at zeroth ind
        System.out.println(deque.peekLast()); //

        deque.pollFirst(); //retireives and remove first .. null if empty... from zeroth index
        System.out.println(deque);

        deque.pollLast(); //retireives and remove last .. null if empty
        System.out.println(deque);

        deque.poll();
        System.out.println(deque); //will poll zeroth index

        System.out.println(deque.peek());//head of the queue...ie. zeroth index



    }
}
