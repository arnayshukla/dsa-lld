package com.practice.java.dsa;;
/*
 * Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. 
 * You may consider that such an element always exists in the array.
 */
public class FindMajorityElement {

    public static void main(String[] args) {
        int[] array = {4,4,2,4,3,4,4,3,2,4};
        int counter = 0;
        int element = 0;
        for (int i = 0; i < array.length; i++) {
            if (counter == 0) {
                element = array[i];
                counter = 1;
            } else if (element == array[i]) {
                counter++;
            } else {
                counter--;
            }
        }
        System.out.println(element);
    }
}
