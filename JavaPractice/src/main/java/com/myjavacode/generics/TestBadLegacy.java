package com.myjavacode.generics;

import java.util.ArrayList;
import java.util.List;

public class TestBadLegacy {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        new Inserter().insert(arrayList);
        System.out.println(arrayList);
    }
}

class Inserter {
    void insert (List list) {
        list.add("42");
    }
}
