package com.myjavacode.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ArraysExample {

    public static void main(String[] args) {

        System.out.println(TimeUnit.DAYS.toSeconds(7));
//        int [][] arr = new int[5][5];
//        Arrays.sort(arr, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int size = scores.length;
        int [][] arr = new int[scores.length][ages.length];
        int [] dp = new int[scores.length + 1];

        for (int i = 0; i < size; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.stream(arr).forEach(a -> System.out.println(new ArrayList<>(Arrays.asList(a))));

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            dp[i] = arr[i][1];

            for (int j = 0; j < i; j++) {
                if (arr[j][1] < arr[i][1]) {
                    dp[i] = Integer.max(dp[i], dp[j] + arr[i][1]);
                }
            }

            maxVal = Integer.max(maxVal, dp[i]);
        }

        return maxVal;

    }

    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        while (r < fruits.length) {
            if (map.size() < 2 || (map.size() == 2 && map.containsKey(fruits[r]))) {
                map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
                count++;
                r++;
            } else {

                if (map.get(fruits[l]) > 1) {
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                } else {
                    map.remove(fruits[l]);
                }

                count--;
                l++;

            }
            System.out.println(count + " :el " + map);
            maxCount = Integer.max(maxCount, count);
        }

        return maxCount;
    }

    public int method(String [] ideas) {
        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> halfStringMap = new HashMap<>();
        for (String idea: ideas) {
            charMap.put(idea.charAt(0), charMap.getOrDefault(idea.charAt(0), 0) + 1);
            String halfStr = idea.substring(1);
            halfStringMap.put(halfStr, halfStringMap.getOrDefault(halfStr, 0) + 1);
        }

        int count = 0;
        for (String idea: ideas) {
            int countCurr = ideas.length - charMap.get(idea.charAt(0));
            countCurr = countCurr - halfStringMap.get(idea.substring(1)) + 1;

            if (count == 0) {
                count += 2 * countCurr;
            } else {
                count += 2 * countCurr - 2;
            }

        }



        return count;

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        Integer [][] pandc = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            pandc[i][0] = profits[i];
            pandc[i][1] = capital[i];
        }

        Arrays.sort(pandc, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else if (a[1] == 0 || b[1] == 0) {
                return 1;
            } else if ( b[0] / b[1] == 0 || a[0] / a[1] == 0) {
                return (b[0] * a[1]) - (a[0] * a[1]);
            } else {
                return (b[0] + b[1]) - (a[0] + a[1]);
            }
        });

        Arrays.stream(pandc).forEach(a -> System.out.println(new ArrayList<>(Arrays.asList(a)).toString()));


//        Set<Integer[]> hashSet = new HashSet<>(new ArrayList<>(Arrays.asList(pandc)));

        while (k > 0) {
            for (int i = 0; i < n && k > 0; i++) {
                if (w < pandc[0][1]) {
                    continue;
                }
                w = w + pandc[i][0];
                pandc[i][0] = 0;
                pandc[i][1] = 0;
                k--;
            }
        }
        return w;
    }
}


