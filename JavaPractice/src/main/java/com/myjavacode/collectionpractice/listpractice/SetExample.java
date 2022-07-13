package com.myjavacode.collectionpractice.listpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        Set<String> set =  new HashSet<>();
        set.add("kajal");
        set.add("Sakshi");
        set.add("baby");

        Set<String> set1 = Collections.unmodifiableSet(set);
        System.out.println(set1);
        set.add("rimjhim");
        System.out.println(set1); //addition on specifed coll will reflect in unmodifiable collection too
//        set1.add("some"); //error

        set.size(); //return size of set
        set.addAll(new ArrayList<>());
        String [] strArray = set.toArray(new String[0]);

        Iterator<String> stringIterator = set.iterator();
        set.forEach(System.out::println);

        //have all method similar to List

        //returns sorted set
        Set<String> set2 = new TreeSet<>(String::compareTo);




    }
}
