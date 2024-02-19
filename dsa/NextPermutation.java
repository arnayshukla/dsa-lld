package com.practice.java.dsa;

public class NextPermutation {

  public static void main(String[] args) {
    int[] input = new int[] {2,1,5,4,3,0,0};

    //Find Pivot
    int pivot = -1;
    for (int i = input.length - 1 ; i > 0; i--) {
      if (input[i - 1] < input [i]) {
        pivot = i - 1;
        break;
      }
    }

    if (pivot != -1) {
      int min = Integer.MAX_VALUE;
      // swap with next greater than pivot
      int swapIndex = -1;
      for (int i = pivot + 1; i < input.length; i++) {
        if (input[i] > input[pivot] && input[i] <= min) {
          min = input[i];
          swapIndex = i;
        }
      }
      int temp = input[pivot];
      input[pivot] = min;
      input[swapIndex] = temp;
  
      //print till pivot
      for (int i = 0; i <= pivot; i++) {
        System.out.print(input[i] + " ");
      }
    }

    //reverse the remaining array
    for (int i = input.length - 1; i > pivot; i--) {
      System.out.print(input[i] + " ");
    }

  }

}
