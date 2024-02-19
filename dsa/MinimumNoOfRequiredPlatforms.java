package com.practice.java.dsa;

import java.util.Arrays;

/*
 * We are given two arrays that represent the arrival and departure times of trains that stop at the platform. 
 * We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
 */
public class MinimumNoOfRequiredPlatforms {
    public static void main(String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int n=arr.length;
        int totalCount=findPlatform(arr,dep,n);
        System.out.println("Minimum number of Platforms required "+totalCount);
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        int platformCounter = 1;
        int maxPlatform = 1;
        int i = 1;
        int j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformCounter++;
                i++;
            } else if (arr[i] > dep[j]) {
                platformCounter--;
                j++;
            }
            maxPlatform = Math.max(maxPlatform, platformCounter);
        }
        return maxPlatform;
    }
}
