package com.practice.java.dsa;;

/*
 * Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array.
 */
public class SearchSingleElementInSortedArray {
    public static void main(String[] args) {
//        int arr[] = {1,1,2,2,3,3,4,5,5,6,6};
        int arr[] = {1,1,3,5,5};
        if (arr.length == 1) {
            System.out.println(arr[0]);
        } else if (arr[0] != arr[1]) {
            System.out.println(arr[0]);
        } else if (arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1]);
        }
        int start = 1, end = arr.length - 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                System.out.println(arr[mid]);
                return;
            }
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("-1");
    }
}
