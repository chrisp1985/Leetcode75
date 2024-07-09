package com.chrisparsons.leetcode150;

public class LeetCode150 {

    // NOTE: Only includes the extras not already includied in the Leetcode 75.

    /**
     *
     * 189. Rotate Array
     *
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     *
     * Example 2:
     *
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     *
     *
     *
     * Constraints:
     *
     *     1 <= nums.length <= 105
     *     -231 <= nums[i] <= 231 - 1
     *     0 <= k <= 105
     */

    public void rotate(int[] nums, int k) {

        // Reverse all of it.
        int l = 0;
        int r = nums.length - 1;

        k = k % nums.length;

        while(l < r) {

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;

        }

        // Reverse the stuff up to k.
        l = 0;
        r = k - 1;

        while(l < r) {

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;

        }

        // Reverse the rest of it.

        l = k;
        r = nums.length - 1;
        while(l < r) {

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;

        }

    }


    /**
     *
     * 122. Best Time to Buy and Sell Stock II
     *
     *
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     *
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
     *
     * Find and return the maximum profit you can achieve.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     *
     * Example 2:
     *
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     *
     * Example 3:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     *
     *
     *
     * Constraints:
     *
     *     1 <= prices.length <= 3 * 104
     *     0 <= prices[i] <= 104
     *
     *
     */

    public int maxProfit(int[] prices) {

        int b = prices[0];
        int sum = 0;
        int difference = 0;

        for(int i = 1; i < prices.length; i++) {

            if(prices[i] <= prices[i-1]) {
                sum += difference;
                b = prices[i];
                difference = 0;
            }
            else {
                difference = prices[i] - b;
            }
        }

        return sum + difference;
    }


    /**
     *
     * 4. Median of Two Sorted Arrays
     *
     *
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     *
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     *
     *
     *
     * Constraints:
     *
     *     nums1.length == m
     *     nums2.length == n
     *     0 <= m <= 1000
     *     0 <= n <= 1000
     *     1 <= m + n <= 2000
     *     -106 <= nums1[i], nums2[i] <= 106
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArrays = mergeArrays(nums1, nums2);

        int l = 0;
        int r = mergedArrays.length -1;

        while(l < r) {

            l++;
            r--;

        }

        return (double) (mergedArrays[l] + mergedArrays[r]) / 2;

    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];
        int mergedindex = 0;
        int nums1index = 0;
        int nums2index = 0;

        while(nums1index <= nums1.length - 1 && nums2index <= nums2.length -1) {

            if(nums1[nums1index] < nums2[nums2index]) {
                mergedArray[mergedindex] = nums1[nums1index];
                nums1index++;
            }
            else {
                mergedArray[mergedindex] = nums2[nums2index];
                nums2index++;
            }
            mergedindex++;

        }

        while(nums2index <= nums2.length - 1 && mergedindex <= mergedArray.length - 1) {

            mergedArray[mergedindex] = nums2[nums2index];
            nums2index++;
            mergedindex++;

        }

        while(nums1index <= nums1.length - 1 && mergedindex <= mergedArray.length - 1) {

            mergedArray[mergedindex] = nums1[nums1index];
            nums1index++;
            mergedindex++;

        }

        return mergedArray;
    }
}
