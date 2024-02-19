package com.practice.java.dsa;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array containing both positive and negative integers, 
 * we have to find the length of the longest subarray with the sum of all elements equal to zero.
 */
public class LongestSubarrayWithZeroSum {

    public static void main(String[] args) {
//        int[] array = {6, -2, 2, -8, 1, 7, 4, -10};
//        int[] array = {1, 0, -5};
//        int[] array = {1, 3, -5, 6, -2};
        int[] array = {9, -3, 3, -1, 6, -5};
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum == 0) {
                maxLength = i + 1;
            } else {
                if (sumMap.containsKey(sum)) {
                    maxLength = Math.max(maxLength, i - sumMap.get(sum));
                } else {
                    sumMap.put(sum, i);
                }
            }
        }
        System.out.println(maxLength);
    }

}
