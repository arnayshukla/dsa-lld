package com.practice.java.dsa;

public class StockBuyAndSell {

  public static void main(String[] args) {
    int[] array = {7,1,5,3,6,4};
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 1; i < array.length; i++) {

      if (array[i] < minPrice) {
        minPrice = array[i];
      }

      if (array[i] - minPrice > maxProfit) {
        maxProfit = array[i] - minPrice;
      }

    }
    System.out.println(maxProfit);
  }

}
