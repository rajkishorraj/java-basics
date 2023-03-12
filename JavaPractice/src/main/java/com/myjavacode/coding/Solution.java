package com.myjavacode.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public boolean dfs(Map<Integer, List<Integer>>  graph, Set<Integer> visited, int node, Set<Integer> underDfs) {
        underDfs.add(node);

        for (Integer adjNode : graph.get(node)) {
            if (visited.contains(adjNode)) {
                continue;
            }

            if (underDfs.contains(adjNode) || dfs(graph, visited, adjNode, underDfs)) {
                return true;
            }
        }

        visited.add(node);
        underDfs.remove(node);

        return false;

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Map<Integer, List<Integer>> graph = new HashMap<>();


        for (int i = 0; i < adj.size(); i++) {
            graph.computeIfAbsent(i, k -> new ArrayList<>()).add(adj.get(i).get(0));
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> underDfs = new HashSet<>();

        // for (int i = 0; i < V; i++) {
        //     if (!visited.contains(i) && dfs(graph, visited, i, underDfs)) {
        //         return true;
        //     }
        // }

        return false;
    }

    public String addTwoStr(String str1, String str2) {

        StringBuilder sb = new StringBuilder();

        int i = str1.length() - 1;
        int j = str2.length() - 1;

        System.out.println(str1);
        System.out.println(str2);

        int rem = 0;

        while (i >= 0 && j >= 0) {
            int num = (str1.charAt(i) - '0') + (str2.charAt(j) - '0') + rem;
            sb.append(num % 10);
            rem = num / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int num = (str1.charAt(i) - '0') + rem;
            sb.append(num % 10);
            rem = num / 10;
            i--;
        }

        while (j >= 0) {
            int num = (str2.charAt(j) - '0') + rem;
            sb.append(num % 10);
            rem = num / 10;
            j--;
        }

        if (rem > 0) {
            sb.append(rem);
        }

        return sb.reverse().toString();
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int [] flight : flights) {
            graph.computeIfAbsent(flight[0], val -> new ArrayList<>()).add(new ArrayList<>(Arrays.asList(flight[1], flight[2])));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);

        Set<Integer> visited = new HashSet<>();
        visited.add(src);

        pq.offer(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int [] stop = pq.poll();

            if (stop[0] == dst) {
                return stop[2];
            }

            for (List<Integer> nextFlight : graph.get(stop[0])) {
                if (!visited.contains(nextFlight.get(0)) && stop[1] + 1 <= k) {
                    visited.add(nextFlight.get(0));
                    pq.offer(new int[]{nextFlight.get(0), stop[1] + 1, stop[2] + nextFlight.get(1)});
                }
            }
        }

        return -1;

    }

}