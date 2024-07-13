package com.chrisparsons.leetcode150;

import java.util.*;

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

    /**
     *
     * 3110. Score of a String
     *
     *
     * You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
     *
     * Return the score of s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "hello"
     *
     * Output: 13
     *
     * Explanation:
     *
     * The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
     *
     * Example 2:
     *
     * Input: s = "zaz"
     *
     * Output: 50
     *
     * Explanation:
     *
     * The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
     *
     *
     *
     * Constraints:
     *
     *     2 <= s.length <= 100
     *     s consists only of lowercase English letters.
     *
     *
     */

    public int scoreOfString(String s) {

        char[] stringArray = s.toCharArray();

        int sum = 0;
        int lastKnown = stringArray[0];

        for(int i = 1; i < s.length(); i++) {
            sum += Math.max(lastKnown - stringArray[i], stringArray[i] - lastKnown);
            lastKnown = stringArray[i];
        }

        return sum ;

    }

    /**
     *
     * 55. Jump Game
     *
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Example 2:
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     *
     *
     *
     * Constraints:
     *
     *     1 <= nums.length <= 104
     *     0 <= nums[i] <= 105
     */

    public boolean canJump2(int[] nums) {

        if(nums.length == 1) {
            return true;
        }

        int stash = nums[0] -1;
        int index = 0;

        while(stash > 0 && index < nums.length) {

            stash = Math.max(nums[index], stash);
            index++;
            stash--;
        }

        return index >= nums.length -1;

    }

    public boolean canJump(int[] nums) {

        if(nums.length == 1) {
            return true;
        }

        if(nums[0] == 0) {
            return false;
        }

        int count = nums[0] -1;

        for(int i = 1; i < nums.length -1; i++) {

            count = Math.max(count, nums[i]);

            if(count == 0) {

                return false;

            }

            count --;

        }

        return true;
    }


    /**
     *
     * 45. Jump Game II
     *
     *
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     *
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
     *
     *     0 <= j <= nums[i] and
     *     i + j < n
     *
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Example 2:
     *
     * Input: nums = [2,3,0,1,4]
     * Output: 2
     *
     *
     *
     */

    public int jump(int[] nums) {

        return 0;
    }

    /**
     *
     *
     * 125. Valid Palindrome
     *
     *
     *
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     *
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     *
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     *
     */

    public boolean isPalindrome(String s) {

        char[] stringArray = s
                .replaceAll("[^A-Za-z0-9]", "")
                .strip()
                .trim()
                .toLowerCase()
                .toCharArray();

        int l = 0;
        int r = stringArray.length - 1;

        while(l < r) {
            if(stringArray[l] != stringArray[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }

    /**
     *
     * 392. Is Subsequence
     *
     *
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     *
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     *
     */

    public boolean isSubsequence(String s, String t) {

        char[] t_arr = t.toCharArray();
        char[] s_arr = s.toCharArray();

        int counter = 0;

        if(s.isEmpty()) {
            return true;
        }

        for(int i=0; i < t_arr.length; i++) {

            if(t_arr[i] == s_arr[counter]) {
                counter++;
            }

            if(counter == s.length()) {
                return true;
            }
        }

        return false;

    }

    /**
     *
     *
     * 70. Climbing Stairs
     *
     *
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     *
     * Example 2:
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     */

    public int climbStairs(int n) {

        return climbStairs(new HashMap<Integer, Integer>(), n);

    }

    private int climbStairs(HashMap<Integer, Integer> memo, int n) {

        if(memo.get(n) !=null) {
            return memo.get(n);
        }

        if(n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        memo.put(n, climbStairs(memo, n - 1) + climbStairs(memo, n -2));
        return memo.get(n);
    }

    /**
     *
     *
     * 151. Reverse Words in a String
     *
     *
     *
     * Given an input string s, reverse the order of the words.
     *
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     *
     * Return a string of the words in reverse order concatenated by a single space.
     *
     * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     *
     * Example 2:
     *
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     *
     * Example 3:
     *
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length <= 104
     *     s contains English letters (upper-case and lower-case), digits, and spaces ' '.
     *     There is at least one word in s.
     *
     *
     *
     * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
     *
     *
     *
     */
    public String reverseWords(String s) {

        String[] stringsSplit = s.split("\\s+");

        int l = 0;
        int r = stringsSplit.length -1 ;

        while(l < r) {

            var tmp = stringsSplit[l];
            stringsSplit[l] = stringsSplit[r];
            stringsSplit[r] = tmp;

            l++;
            r--;

        }


        return String.join(" ", stringsSplit).trim();
    }

    /**
     *
     *
     * 6. Zigzag Conversion
     *
     *
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     *
     *
     *
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     *
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * Example 3:
     *
     * Input: s = "A", numRows = 1
     * Output: "A"
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length <= 1000
     *     s consists of English letters (lower-case and upper-case), ',' and '.'.
     *     1 <= numRows <= 1000
     */

    public String convert(String s, int numRows) {

        char[] s_arr = s.toCharArray();
        int counter = 0;
        boolean inversed = false;

        HashMap<Integer, String> map = new HashMap<>();

        for(int i = 0; i < s_arr.length; i++) {

            if(counter == 0) {
                inversed = false;
            }
            else if (counter == numRows - 1) {
                inversed = true;
            }

            String existing = map.get(counter) == null ? "" : map.get(counter);
            existing += s_arr[i];
            map.put(counter, existing);

            if(!inversed) {
                counter++;
            }
            else {
                counter--;
            }
        }

        StringBuilder returnString = new StringBuilder();

        for(Map.Entry<Integer,String> entry : map.entrySet()) {
            returnString.append(entry.getValue());
        }
        return returnString.toString();
    }

    /**
     *
     * 14. Longest Common Prefix
     *
     *
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     *
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     *
     * Constraints:
     *
     *     1 <= strs.length <= 200
     *     0 <= strs[i].length <= 200
     *     strs[i] consists of only lowercase English letters.
     *
     */
    public String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();
        int loop = 0;

        if(strs.length == 0) {
            return "";
        }

        while(true) {
            StringBuilder stringToMatch = new StringBuilder();
            for(String stringInput : strs) {

                if(loop == stringInput.length() || stringInput.isEmpty()) {
                    return res.toString();
                }

                if(stringToMatch.toString().isEmpty()) {
                    stringToMatch.append(stringInput.charAt(loop));
                }
                else {
                    if(!(stringInput.charAt(loop) == stringToMatch.charAt(0))) {
                        return res.toString();
                    }
                }
            }

            loop++;
            res.append(stringToMatch);

        }
    }

    /**
     *
     * 12. Integer to Roman
     *
     *
     * Seven different symbols represent Roman numerals with the following values:
     * Symbol	Value
     * I	1
     * V	5
     * X	10
     * L	50
     * C	100
     * D	500
     * M	1000
     *
     * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
     *
     *     If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
     *     If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
     *     Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
     *
     * Given an integer, convert it to a Roman numeral.
     *
     *
     *
     * Example 1:
     *
     * Input: num = 3749
     *
     * Output: "MMMDCCXLIX"
     *
     * Explanation:
     *
     * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
     *  700 = DCC as 500 (D) + 100 (C) + 100 (C)
     *   40 = XL as 10 (X) less of 50 (L)
     *    9 = IX as 1 (I) less of 10 (X)
     * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
     *
     * Example 2:
     *
     * Input: num = 58
     *
     * Output: "LVIII"
     *
     * Explanation:
     *
     * 50 = L
     *  8 = VIII
     *
     * Example 3:
     *
     * Input: num = 1994
     *
     * Output: "MCMXCIV"
     *
     * Explanation:
     *
     * 1000 = M
     *  900 = CM
     *   90 = XC
     *    4 = IV
     *
     *
     *
     * Constraints:
     *
     *     1 <= num <= 3999
     */

    public String intToRoman(int num) {

        LinkedHashMap<String, Integer> romanMap = new LinkedHashMap<>() {{
            put("M",1000);
            put("CM",900);
            put("D",500);
            put("CD",400);
            put("C",100);
            put("XC",90);
            put("L",50);
            put("XL",40);
            put("X",10);
            put("IX",9);
            put("V",5);
            put("IV",4);
            put("I",1);
        }};

        StringBuilder res = new StringBuilder();

        for(Map.Entry<String, Integer> entry : romanMap.entrySet()) {
            while(num >= entry.getValue()) {
                res.append(entry.getKey());
                num = num - entry.getValue();
            }
        }

        return res.toString();
    }
}
