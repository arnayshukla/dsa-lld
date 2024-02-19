package com.practice.java.dsa;

/*
 * Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k.
 * Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
 */
public class FindElementInSortedAndRotatedArray {

  public static void main(String[] args) {
    int[] array = {4,5,6,7,0,1,2,3};
    int k = 0;
    int start = 0, end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (array[mid] == k) {
        System.out.println("Index of " + k + " is: " + mid);
        return;
      }
      if (array[start] <= array[mid]) {
        if (array[start] <= k && k <= array[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (array[mid] <= k && k <= array[end]) {
          start = mid + 1;
        } else {
          end =  mid - 1;
        }
      }
      
    }
    System.out.println("Element " + k + " not found in array");
  }

}
