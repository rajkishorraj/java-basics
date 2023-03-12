package com.myjavacode.collectionpractice.listpractice;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {

        method3();

//        Collections.binarySearch(new ArrayList<>(), 10); //if not found it returns
        //-(index  - 1) i.e., index is the supposed index of elements
    }

    public static void simpleMapOperations() {
        Map<String, String> map = new HashMap<>();
        map.getOrDefault("raj", "not found"); //Returns the value to which the specified key is mapped, or
        // if this map contains no mapping for the key.
        map.get("raj"); //null if not found // although it can also returns null if the value for specifed key is null
        //because hashmap can contains one null key and multiple null values
        //null returns deoesnot mean key is not there ,
        //to check if key is present use containsKey method


        map.putIfAbsent("kishor", "kr"); //If the specified key does not exist or specified key has value null

        map.put("raj", "rj"); //put if key not found else replaced if key is already there;
//        List<Character> list = new ArrayList<>(Arrays.asList('R', 'G', 'B'));

        map.putAll(new HashMap<>()); //put all the mappings from a given map to this map

        map.computeIfAbsent("raj", String::toLowerCase);  //The computeIfAbsent method takes two parameters.
        // The first parameter is the key and the second parameter is the mappingFunction.
        // It's important to know that mapping function is only called if the mapping is not present.
        map.compute("raj", String::concat); //it takes key and bifunction key, value to remap the value
//        map.compute("unkonw", String::concat);


        map.containsKey("raj"); //check if key is present
        map.containsValue("kr"); //returns true if map has atleast one key with this value

        Set<Map.Entry<String, String>> setKeyValue = map.entrySet(); // returns set of Map.Entry, Entry is interface with two
        //method getKey and GetValue
        setKeyValue.iterator().next().getKey();
        setKeyValue.iterator().next().getValue();

        map.forEach((key, value) -> System.out.println(key + " " + value));
        Set<String> setKey = map.keySet(); //returns set of KEy
        List<String> setValues = new ArrayList<>(map.values()); //returns set of values

        for (Map.Entry<String, String> entry : map.entrySet()) {

        }

        map.remove("raj"); //either reomves the key or returned null if key is not there
        map.remove("raj", "kr"); //removes only if the key is linked with given value.


        StringBuilder sb = new StringBuilder("sdfsf");

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));


        Map<String, Integer> mp = new HashMap<>();

        String str = "sdfs sdfs";
        str = str + 's';

        mp.merge("raj", 3, Integer::sum);

        mp.forEach((a, b) -> System.out.println(a + " " + b));

        Set<Character> setC = new HashSet<>();
        setC.add(new Character('a'));
        setC.add(new Character('a'));


        for (Character c : setC) {
            System.out.println(c.charValue());
        }


        String sttr = "sdfsf";
        for (Character c : sttr.toCharArray()) {
            System.out.println(c.charValue());
        }

        for (int i = 0; i < sttr.length(); i++) {
            setC.add(sttr.charAt(i));
        }

        for (Character c : setC) {
            System.out.println(c);
        }
    }

    public void treeMap() {

        Map<Integer, Character> mp = new TreeMap<>();
    }


    public static void mapOperation2() {
        Map<String, Integer> mp = new HashMap<>();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());
        list.sort(
            (a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) :
                    b.getValue() - a.getValue()
        );

        list.stream().limit(Integer.min(list.size(), 5)).map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));


        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue().equals(a.getValue()) ? b.getKey().compareTo(a.getKey()) :
                        a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            pq.offer(entry);
            if (pq.size() > 5) {
                pq.poll();
            }
        }
        list.addAll(pq);

        Collections.reverse(list);
    }

    public static void concurrentHashMapOperation() {
        Map<String, String> mp = new ConcurrentHashMap<>();
    }

    public static void method3() {
        int x = 7;
//        Map<Integer, Integer> mp = new HashMap<>();

        new ArrayList<>().clone();

        List<Map<Integer, Integer>> listMap = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<Integer, Integer> t = new HashMap<>();
            t.put(6,i);
            listMap.add(t);
        }

        System.out.println(listMap);


        Map<String, Integer> map = new HashMap<>();


//
//        mp.put(5, 6);
//        mp.put(6, 7);
//        mp.put(8, 6);
//        Map<Integer, Long> mp2 = mp.values().stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
//
//        System.out.println(mp2);
    }

}
