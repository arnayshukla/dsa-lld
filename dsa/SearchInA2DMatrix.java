package com.practice.java.dsa;;

/*
 * Problem Statement: You have been given a 2-D array ‘mat’ of size ‘N x M’ where ‘N’ and ‘M’ denote the number of rows and columns, respectively. 
 * The elements of each row are sorted in non-decreasing order. 
 * Moreover, the first element of a row is greater than the last element of the previous row (if it exists). 
 * You are given an integer ‘target’, and your task is to find if it exists in the given ‘mat’ or not.
 */
public class SearchInA2DMatrix {

    public static void main(String[] args) {
        
        int target = 8;
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = (n*m) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid / m][mid % m] == target) {
                System.out.println("true");
                return;
            } else if (matrix[mid / m][mid % m] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("false");
    }
}
