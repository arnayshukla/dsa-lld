package com.practice.java.dsa;

public class PascalsTriangle {

  public static void main(String[] args) {
    pascalsTriangle(5,5,3);
  }

  private static void pascalsTriangle(int rows, int row, int col) {
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(nCr(i - 1, j - 1) + " ");
      }
      System.out.println();
    }
  }

  private static int nCr(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; i++) {
      result = result * (n-i);
      result = result / (i+1);
    }
    return (int) result;
  }
}
