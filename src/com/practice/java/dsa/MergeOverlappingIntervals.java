package com.practice.java.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{0,4}};

//      SORTING INPUT ARRAY ON START OF INTERVAL SO THAT INTERVALS ARE IN ASC ORDER   
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length - 1; i++) {
            if (end >= intervals[i+1][0]) {
//              MAX OF CURRENT END OR NEXT END
                end = Math.max(intervals[i+1][1], end);
            } else {
                ArrayList<Integer> mergedInterval = new ArrayList<>();
                mergedInterval.add(start);
                mergedInterval.add(end);
                solution.add(mergedInterval);
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
        }

        ArrayList<Integer> mergedInterval = new ArrayList<>();
        mergedInterval.add(start);
        mergedInterval.add(end);
        solution.add(mergedInterval);

        int[][] solutionArray = new int[solution.size()][2];
        for (int i = 0 ; i < solution.size(); i++) {
            solutionArray[i][0] = solution.get(i).get(0);
            solutionArray[i][1] = solution.get(i).get(1);
        }
    }

}
