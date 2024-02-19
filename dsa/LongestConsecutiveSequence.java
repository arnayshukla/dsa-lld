package com.practice.java.dsa;

import java.util.HashSet;
import java.util.Set;

//You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] array = {100, 200, 1, 3, 2, 4};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        int result = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int x = i;
                while(set.contains(x + 1)) {
                    x += 1;
                    count += 1;
                }
                result = Math.max(count, result);
            }
        }
        System.out.println(result);
    }
}
