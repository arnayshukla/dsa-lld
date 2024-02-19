package com.practice.java.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement: Given an array of integers arr[] and an integer target.

    1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

    2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {2,6,5,8,11};
        int target = 14;
        int result[] = {-1,-1};
        //HASH MAP
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                result[0] = map.get(target-array[i]);
                result[1] = i;
                break;
            } else {
                map.put(array[i], i);
            }
        }
        System.out.println("{"+result[0]+","+result[1]+"}");

        //TWO POINTERS
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                System.out.println("TRUE");
                break;
            } else if (array[left] + array[right] < target) {
                left++;
            } else if (array[left] + array[right] > target) {
                right--;
            }
        }
    }
}
