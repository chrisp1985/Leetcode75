package com.chrisparsons;

import java.util.HashMap;

public class Leetcode {

    /**
     *
     * Two Sum
     *
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     */

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> prevSeen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            if(prevSeen.get(target - nums[i]) !=null) {

                int[] returnArray = new int[] {prevSeen.get(target - nums[i]), i};

                return returnArray;

            }

            prevSeen.put(nums[i], i);

        }

        return new int[2];

    }


    /**
     *
     * 9. Palindrome Number
     *
     *
     * Example 1:
     *
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     *
     * Example 2:
     *
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     *
     * Example 3:
     *
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */

    public boolean isPalindrome(int x) {

        if(x < 0) {
            return false;
        }

        char[] intArray = String.valueOf(x).toCharArray();

        int l = 0;
        int r = intArray.length -1;

        while(l < r) {
            if(intArray[l] != intArray[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }
}
