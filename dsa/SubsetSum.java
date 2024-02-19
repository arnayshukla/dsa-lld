package com.practice.java.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given an array print all the sum of the subset generated from it, in the increasing order.
 */
public class SubsetSum {

    public static void main(String[] args) {
//        int arr[] = {5,2,1};
        int arr[]= {3,1,2};
        List<Integer> sumList = subsetSum(arr, arr.length);
        Collections.sort(sumList);
        for (int i = 0; i < sumList.size(); i++) {
            System.out.print(sumList.get(i) + ", ");
        }
    }

    private static List<Integer> subsetSum(int[] arr, int length) {
        List<Integer> sumList = new ArrayList<>();
        subsetSumHelper(0, 0, sumList, length, arr);
        return sumList;
    }

    private static void subsetSumHelper(int index, int sum, List<Integer> sumList, int length, int[] arr) {
        if (index == length) {
            sumList.add(sum);
            return;
        }
        subsetSumHelper(index + 1, sum + arr[index], sumList, length, arr);
        subsetSumHelper(index + 1, sum, sumList, length, arr);
    }
}
