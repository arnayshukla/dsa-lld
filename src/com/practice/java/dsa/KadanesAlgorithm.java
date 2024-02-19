package com.practice.java.dsa;

public class KadanesAlgorithm {

  public static void main(String[] args) {
    int[] array = {-2,1,-3,4,-1,2,1,-5,4};
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
      if (max < sum) {
        max = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    System.out.println(max);
  }

}
