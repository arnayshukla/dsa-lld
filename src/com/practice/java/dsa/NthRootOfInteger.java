package com.practice.java.dsa;;

/*
 * Given two numbers N and M, find the Nth root of M. 
 * The nth root of a number M is defined as a number X when raised to the power N equals M. 
 * If the ‘nth root is not an integer, return -1.
 */
public class NthRootOfInteger {

    public static void main(String[] args) {
        int m = 27, n =3;
        int start = 1, end = m;
        while (start <= end) {
            int mid = (start + end)/2;
            int value = Double.valueOf(Math.pow(mid, n)).intValue();
            if (value == m) {
                System.out.println(mid);
                return;
            } else if (value < m) {
                start = mid + 1;
            } else if (value > m) {
                end = mid - 1;
            }
        }
        System.out.println("-1");
    }
}
