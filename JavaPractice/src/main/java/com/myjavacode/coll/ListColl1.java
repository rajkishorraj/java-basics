package com.myjavacode.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListColl1 {

    public static void main(String [] args) {

        List<String> arraylist = new ArrayList<>();
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 != i2);
        arraylist.add("sf");
        arraylist.add("sf");
        arraylist.remove(arraylist.size() - 1);

        int [] row = new int[5];
        Arrays.fill(row, 1);
        List<Integer> integers = new ArrayList<>();
        integers = Arrays.stream(row).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(integers);
    }
}
