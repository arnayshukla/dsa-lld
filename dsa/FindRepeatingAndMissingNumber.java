package com.practice.java.dsa;;

//Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. 
//Each integer appears exactly once except A which appears twice and B which is missing. 
//The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        int[] array = {3,1,2,5,4,6,7,5};
        int sumOfNNaturalNos = ((array.length)*(array.length + 1))/2;
        System.out.println("sumOfNNaturalNos: " + sumOfNNaturalNos);
        int sumOfSqOfNNaturalNos = ((array.length)*(array.length + 1)*((2  *array.length) + 1))/6;
        System.out.println("sumOfSqOfNNaturalNos: " + sumOfSqOfNNaturalNos);
        int sumOfArray = 0;
        int sumOfSquareOfArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfArray += array[i];
            sumOfSquareOfArray += (array[i] * array[i]);
        }
        System.out.println("sumOfArray: " + sumOfArray);
        System.out.println("sumOfSquareOfArray: " + sumOfSquareOfArray);
        int diffOfMissingAndRepeating = Math.abs(sumOfNNaturalNos - sumOfArray);
        System.out.println("diffOfMissingAndRepeating: " + diffOfMissingAndRepeating);
        int diffOfSquareOfMissingAndRepeating = Math.abs(sumOfSqOfNNaturalNos - sumOfSquareOfArray);
        System.out.println("diffOfSquareOfMissingAndRepeating: " + diffOfSquareOfMissingAndRepeating);
        int sumOfMissingAndRepeating = diffOfSquareOfMissingAndRepeating / diffOfMissingAndRepeating;
        System.out.println("sumOfMissingAndRepeating: " + sumOfMissingAndRepeating);
        int value1 = (sumOfMissingAndRepeating + diffOfMissingAndRepeating) / 2;
        int value2 = sumOfMissingAndRepeating - value1;
        System.out.println(value1 + "," + value2);
    }
}
