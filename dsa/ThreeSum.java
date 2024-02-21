package com.nykaa.tradeScheme.test;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] input =  {0,0,0};
        int target = 0;
        Arrays.sort(input);
//        for (int i = 0; i < input.length; i++) {
//            
//            int left = i+1;
//            int right = input.length - 1;
//            while (left < right) {
//                int currentSum = input[i] + input[left] + input[right];
//                if (currentSum == target) {
//                    System.out.println("Triplets are: " + input[i] + ", " + input[left] + ", " + input[right]);
//                    break;
//                } else if (currentSum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
        for (int i = 0; i < input.length; ++i) {
            if (input[i] > 0) {
                break;
            }
            
            if (i > 0 && input[i] == input[i - 1]) {
                continue;
            }
            
            int low = i + 1, high = input.length - 1;
            while (low < high) {
                int sum = input[i] + input[low] + input[high];
                if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    System.out.println("Triplets are: " + input[i] + ", " + input[low] + ", " + input[high]);
                    int lastLowOccurrence = input[low];
                    int lastHighOccurrence = input[high];
                    
                    while (low < high && input[low] == lastLowOccurrence) {
                        low++;
                    }
                    
                    while (low < high && input[high] == lastHighOccurrence) {
                        high--;
                    }
                }
            }
        }
    }
}
