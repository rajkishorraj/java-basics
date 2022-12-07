package com.myjavacode.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
}