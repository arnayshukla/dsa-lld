package com.practice.java.dsa;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a String, find the length of longest substring without any repeating character.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        while (right < str.length()) {
            if (indexMap.containsKey(str.charAt(right))) {
                left = Math.max(left, indexMap.get(str.charAt(right)) + 1);
            }
            indexMap.put(str.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        System.out.println(maxLength);
    }
}
