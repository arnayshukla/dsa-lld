package com.practice.java.dsa;;
/*
 * Problem Statement: Given a matrix m X n, count paths from left-top to the right bottom of a matrix 
 * with the constraints that from each cell you can either only move to the rightward direction or the downward direction.
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int count = paths(0,0,m,n);
        System.out.println(count);
    }

    private static int paths(int i, int j, int m, int n) {
        if (i == n-1 || j == m-1)
            return 1;
        if (i >= n || j >= m)
            return 0;
        return paths(i+1,j,m,n) + paths(i,j+1,m,n);
        
    }
}
