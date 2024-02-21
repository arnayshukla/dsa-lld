package com.nykaa.tradeScheme.test;

/*
 * Kadane's variation to find max product of subarray
 */
public class MaxProductOfSubArray {

    public static void main(String[] args) {
        int[] array = {-1,2,5,6,3,-5,0,80};
//        int[] array = {3, -1, 4};
        int product = 1;
        int maxLProduct = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            product = product*array[i];
            maxLProduct = Math.max(maxLProduct, product);
            if (product == 0) {
                product = 1;
            }
        }
        product = 1;
        int maxRProduct = Integer.MIN_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            product = product*array[i];
            maxLProduct = Math.max(maxLProduct, product);
            if (product == 0) {
                product = 1;
            }
        }
        System.out.println(Math.max(maxLProduct, maxRProduct));
    }

}
