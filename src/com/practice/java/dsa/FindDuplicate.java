package com.practice.java.dsa;;

//Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. 
//Assuming there is only one duplicate number, your task is to find the duplicate number.

public class FindDuplicate {
    public static void main(String[] args) {
        int[] array = {1,3,4,3,2};

        //Sum of N natural no.s = (n * (n+1))/2
        int sumOfNaturalNos = ((array.length)*(array.length - 1))/2;
        int sumOfArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfArray+=array[i];
        }
        System.out.println(sumOfArray - sumOfNaturalNos);

        //XOR solution
        int xor = 0;
        //XOR of array value
        for (int i = 0; i < array.length ; i++) {
            xor = array[i] ^ xor ;
        }
        //XOR of array value with 1-N natural no.s
        for(int i=1;i<=array.length-1;i++) {
            xor=xor^i;
        }
        System.out.println(xor);
    }
}
