package com.practice.java.dsa;

import java.util.Arrays;

//Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
//Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,0,0,0,0,0};
        int n = 5;
        int[] nums2 = {0,2,6,8,9};
        int m = 4;
     // int i = 0;
        // int j = 0;
        // int temp = 0;
        // if (n == 0)
        //     return;
        // if (m == 0) {
        //     while (j < n) {
        //         nums1[j] = nums2[j];
        //         return;
        //     }
        // }
        // while (i < (m+n) && j < n) {
        //     if (nums1[i] > nums2[j]) {
        //         nums1[m + j] = nums1[i];
        //         nums1[i] = nums2[j];
        //         j++;
        //     } else if (i > m) {
        //         nums1[i] = nums2[j];
        //         j++;
        //     }
        //     i++;
        // }
        int i = m;
        for(int j=0; j<n; j++){
            nums1[i++] = nums2[j];
        }
        Arrays.sort(nums1);
        for (i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

}
