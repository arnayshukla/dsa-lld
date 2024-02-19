package com.practice.java.dsa;


// Sort an array of 0s, 1s, and 2s
public class DutchNationalFlagProblem {
  public static void main(String[] args) {
    int[] array = {2, 0, 2, 1, 1, 0};
    int low = 0;
    int mid = 0;
    int high = array.length - 1;
    while (mid <= high) {

      if (array[mid] == 0) {
        int temp = array[low];
        array[low] = array[mid];
        array[mid] = temp;
        low++;
        mid++;
      } else if (array[mid] == 1) {
        mid++;
      } else if (array[mid] == 2) {
        int temp = array[mid];
        array[mid] = array[high];
        array[high] = temp;
        high--;
      }

    }

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }
}
