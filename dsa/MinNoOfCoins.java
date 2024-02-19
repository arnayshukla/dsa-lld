package com.practice.java.dsa;;

/*
 * Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, 
 * i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
 * what is the minimum number of coins and/or notes needed to make the change.
 *
 */
public class MinNoOfCoins {
 public static void main(String[] args) {
    int value = 6853;
    int[] denomination = { 1, 2, 5, 10, 20, 50, 100, 500, 1000} ;
    int count = 0;
    for (int i = denomination.length - 1; i >= 0; i--) {
        count += value / denomination[i];
        value = value % denomination[i];
    }
    System.out.println("Min req coins/notes: " + count);
}
}
