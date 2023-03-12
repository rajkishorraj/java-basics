package com.myjavacode.coll;

import net.lingala.zip4j.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class ListColl1 {

    public static void main(String [] args) throws IOException {

        Iterable<Integer> abc = null;

        for (int ab : abc) {
            System.out.println(ab);
        }
//        DriverManager.getConnection()



//        List<Integer> [] graph = new List [7];
//
//        graph[0] = new ArrayList<>();

//        System.out.println(graph[0]);

//        File file = new File("/data/dist/tmp/raj" + reportName);

//        List<String> arraylist = new ArrayList<>();
//        Integer i1 = 100;
//        Integer i2 = 100;
//        System.out.println(i1 != i2);
//        arraylist.add("sf");
//        arraylist.add("sf");
//        arraylist.remove(arraylist.size() - 1);
//
//        int [] row = new int[5];
//        Arrays.fill(row, 1);
//        List<Integer> integers = new ArrayList<>();
//        integers = Arrays.stream(row).boxed().collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(integers);
    }

    private int count = 0;
    private int element = 0;
    public void traverse(Node root, int K) {
        if (root == null) {
            count++;
        }

        traverse(root.left, K);
        if (count == K) {
            element = root.val;
            return;
        }
        traverse(root.right, K);
    }

    class Node {
        Node left;
        Node right;
        int val;
    }

}

