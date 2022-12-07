package com.myjavacode.collectionpractice.listpractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ArrayListExample {


    public static void removeEl(List<String> list) {
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            if (iterator.next().equals("raj")) {
                list.remove("str");
            }

            //will throw exception because iterator is created out of original collection
            // while it will not throw exception for concurrenthasMap or copyOnArrayList because
            //in copyOnArrayList iterator is created out of copied collection and in
            //concurrentHashMap although iterator is created out of original map but it the
            //iterator will be fail-safe which may or may not return updated data
            if (iterator.next().equals("raj")) {
                iterator.remove(); //it is fine
            }

        }

    }
    //listiterator is only for list and it traverses forward and backward unlike iterator which moves forward only

    //iterator can be used with set, queue, list etc.
    public static void iterate(List<String> list) {
        ListIterator<String> iterator = list.listIterator(); // list.listIterator(2); iterator starting at that index

        System.out.println("traversing forward");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("TRAVERING BACKWARD \n");
        while(iterator.hasPrevious()) {
            System.out.println(iterator.previous());
            //will throw exception while it will not throw exception for concurrenthasMap or copyOnArrayList
            //becasue iterator is created out of copied list not in the original lsit

        }
    }

    public static void iterateArray(String [] arr) {

        //this is foreach
        for (String element : arr) {
            System.out.println(element);
        }

    }

    public static void forEachVsIterator(List<String> list) {
        for (String i : list) {
            System.out.println(i);
            list.remove(i); // throws exception
        }

        Iterator<String> it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            it.remove(); // valid here
        }
    }
    public static void methodsOfCollection(List<String> str) {
        List<String> str2 = new ArrayList<>();

        Collections.addAll(str, "baby", "babu"); // add all elements to collection
        List<Integer> list = Collections.emptyList(); //returns emptyList immutable
        Collections.fill(str, "mannat"); //replace all of the elements in the specified list with given obj
        Collections.copy(str2, str); //str2 - dest, str - src -- copies element from src to dest
        Collections.reverse(str2); //reverses list of string
        Collections.synchronizedCollection(str2); // returns synchronizedCollection backed by origincal collection
        //while traversing sync using iterator you must synchorined on the list object.
        Collections.unmodifiableList(str2); //returns unmodifiable view of the specified list . its just a wrapper around
        // specified collection if we modify specifed coll ,, this coll will change too
        Collections.checkedList(str2, String.class); //dynamically typesafe view of the colleciton ..passing list and type of list object
        //Any attempt to insert an element of the wrong type will result in an immediate ClassCastException
        Collections.singletonList("raj"); // returns immutable list containing that object only
        Collections.singleton("kr"); //Returns an immutable set containing only the specified object.
        Collections.sort(str2, String::compareTo);
        Collections.emptyIterator(); // returnns empty iterator

     }


    public static void copyOnArrayListOperation(List<String> str) {

        List<Integer> listt = new CopyOnWriteArrayList<>();


    }

    public static void generalOperations() {
        List<String> list1 = new ArrayList<>(Arrays.asList("raj", "kr", "st", "str"));
        list1.add(3, "my");
        list1.remove("st");
        list1.remove(1);

        //returns index of first occurrences else -1
        System.out.println(list1.indexOf("str"));
        System.out.println(list1.set(1, "rimjhim"));
        System.out.println("is empty " + list1.isEmpty());
        System.out.println(list1.size());
        System.out.println("does contain " + list1.contains("kr"));

        //returns index of last occurrence of specified element else -1
        System.out.println("index of unknow Eleemtn " + list1.lastIndexOf(""));

        list1.replaceAll(String::toUpperCase); //it consumes UnaryOperator which extends function but it requires the argument
        //to apply method to be the same as return type.

        list1.sort(Comparator.reverseOrder());
        list1.sort(Comparator.comparing(String::length)); //here we are sorting on the basis of lenght of strings

        //to convert list to array just pass an empty Object inside toArray method
        String [] strArray = list1.toArray(new String[0]);

//        String [] strArray2 = list1.stream().toArray(String[]::new); it is more memory intensive as well slower


        System.out.println("iterate over string array");
        iterateArray(strArray);
        System.out.println("done iterate over string array \n");

        Set<String> st = new HashSet<>(Arrays.asList("kajal", "baby", "sakshi"));
        list1.addAll(st); //add all set elements to list
        list1.removeAll(st); //remove all elements from set

//        ArrayListExample.removeEl(list1);

        ArrayListExample.iterate(list1);

        //returns all the element from the list
        list1.clear();


        //Retains only the elements in this list that are contained in the
        //     * specified collection (optional operation).  In other words, removes
        //     * from this list all of its elements that are not contained in the
        //     * specified collection.
        list1.retainAll(new ArrayList<>());
    }
    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>(10);
//
////        list.add(9, 8);
////        System.out.println(list.get(0) +  " " + list.get(9));
//
//        int [] arr = new int[7];
////        System.out.println(arr[-1]);
//
//        String idsString = "1234";
//        List<Long> ids = Arrays.stream(idsString.split(",")).map(Long::valueOf).collect(Collectors.toList());
//        System.out.println(ids.get(0));

        int [] arr2 = {3, 4, 5};
        System.out.println(arr2);

    }
}
