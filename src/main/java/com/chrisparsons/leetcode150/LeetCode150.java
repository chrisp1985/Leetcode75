package com.chrisparsons.leetcode150;

import com.chrisparsons.leetcode150.helpers.TreeNode;

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
     * Constraints:
     *
     *     1 <= nums.length <= 104
     *     0 <= nums[i] <= 1000
     *     It's guaranteed that you can reach nums[n - 1].
     *
     */

    public int jump(int[] nums) { //TODO

        if(nums.length == 1) {

            return 0;

        }

        int count = 0;
        int maxJump = 0;

        // [2,3,0,1,4] = 2
        for(int i=0; i < nums.length; i++) {
            if(i + maxJump >= nums.length) {

                return count++;

            }

            if(maxJump < nums[i]) {

                count++;
                maxJump = nums[i];

            }

            maxJump--;

        }

        return count;
    }

    /**
     *
     * 242. Valid Anagram
     *
     *
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length, t.length <= 5 * 104
     *     s and t consist of lowercase English letters.
     */

    public boolean isAnagram(String s, String t) {

        char[] t1_arr = t.toCharArray();
        char[] s1_arr = s.toCharArray();

        if(t1_arr.length != s1_arr.length) {

            return false;

        }

        Arrays.sort(t1_arr);
        Arrays.sort(s1_arr);

        for(int i = 0; i < t1_arr.length; i++) {

            if(t1_arr[i] != s1_arr[i]) {

                return false;

            }

        }

        return true;

    }


    /**
     *
     * 49. Group Anagrams
     *
     *
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Example 2:
     *
     * Input: strs = [""]
     * Output: [[""]]
     *
     * Example 3:
     *
     * Input: strs = ["a"]
     * Output: [["a"]]
     *
     *
     *
     * Constraints:
     *
     *     1 <= strs.length <= 104
     *     0 <= strs[i].length <= 100
     *     strs[i] consists of lowercase English letters.
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String string : strs) {
            char[] char_arr = string.toCharArray();
            Arrays.sort(char_arr);
            String sortedString = String.valueOf(char_arr);

            if(map.containsKey(sortedString)) {
                List<String> strings = map.get(sortedString);
                List<String> newStrings = new ArrayList<>();
                newStrings.addAll(strings);
                newStrings.add(string);
                map.put(sortedString, newStrings);
            }
            else {
                map.put(sortedString, List.of(string));
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }


    /**
     *
     * 205. Isomorphic Strings
     *
     *
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     * Output: false
     *
     * Example 3:
     *
     * Input: s = "paper", t = "title"
     * Output: true
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length <= 5 * 104
     *     t.length == s.length
     *     s and t consist of any valid ascii character.
     */

    public boolean isIsomorphic(String s, String t) {

        //TODO

        HashMap<Character, Character> mapA = new HashMap<>();
        HashMap<Character, Character> mapB = new HashMap<>();

        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        for(int i = 0; i < s_arr.length; i++) {

            if(mapA.get(s_arr[i]) == null && mapB.get(t_arr[i]) == null) {
                mapA.put(s_arr[i], t_arr[i]);
                mapB.put(t_arr[i], s_arr[i]);
            }
            else {
                if(mapA.get(s_arr[i]) == null || mapB.get(t_arr[i]) == null || mapA.get(s_arr[i]) != t_arr[i] || mapB.get(t_arr[i]) != s_arr[i]) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] alphabetArray = new int[122];

        for(int i=0; i < magazine.length(); i++) {
            alphabetArray[magazine.charAt(i)]++;
        }

        for(int i=0; i < ransomNote.length(); i++) {
            alphabetArray[ransomNote.charAt(i)]--;
            if(alphabetArray[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * 56. Merge Intervals
     *
     *
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     *
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     *
     *
     * Constraints:
     *
     *     1 <= intervals.length <= 104
     *     intervals[i].length == 2
     *     0 <= starti <= endi <= 104
     *
     */

    public int[][] merge(int[][] intervals) {

        List<int[]> listOfIntervals = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        listOfIntervals.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {

            if(listOfIntervals.get(listOfIntervals.size()-1)[1] >= intervals[i][0]) {
                int start = Math.min(listOfIntervals.get(listOfIntervals.size()-1)[0], intervals[i][0]);
                int end = Math.max(listOfIntervals.get(listOfIntervals.size()-1)[1], intervals[i][1]);

                listOfIntervals.remove(listOfIntervals.get(listOfIntervals.size()-1));
                listOfIntervals.add(new int[]{start, end});

            }

            else {
                listOfIntervals.add(intervals[i]);
            }

        }


        return listOfIntervals.toArray(new int[0][]);

    }

    /**
     *
     *
     * 20. Valid Parentheses
     *
     *
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     *     Open brackets must be closed by the same type of brackets.
     *     Open brackets must be closed in the correct order.
     *     Every close bracket has a corresponding open bracket of the same type.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     *
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length <= 104
     *     s consists of parentheses only '()[]{}'.
     *
     *
     */

    public boolean isValid(String s) {

        char[] charArr = s.toCharArray();
        Stack<Character> char_stack = new Stack<>();
        Map<Character, Character> map = Map.of(
                '}', '{',
                ')', '(' ,
                ']', '[');

        char_stack.push(charArr[0]);
        for(int i = 1; i < charArr.length; i++) {
            if(!char_stack.isEmpty() && map.get(charArr[i]) == char_stack.peek()) {
                char_stack.pop();
            }
            else {
                char_stack.push(charArr[i]);
            }
        }

        return char_stack.isEmpty();

    }

    /**
     *
     * 71. Simplify Path
     *
     *
     * Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
     *
     * In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.
     *
     * The simplified canonical path should adhere to the following rules:
     *
     *     It must start with a single slash '/'.
     *     Directories within the path should be separated by only one slash '/'.
     *     It should not end with a slash '/', unless it's the root directory.
     *     It should exclude any single or double periods used to denote current or parent directories.
     *
     * Return the new path.
     *
     *
     *
     * Example 1:
     *
     * Input: path = "/home/"
     *
     * Output: "/home"
     *
     * Explanation:
     *
     * The trailing slash should be removed.
     *
     *
     * Example 2:
     *
     * Input: path = "/home//foo/"
     *
     * Output: "/home/foo"
     *
     * Explanation:
     *
     * Multiple consecutive slashes are replaced by a single one.
     *
     * Example 3:
     *
     * Input: path = "/home/user/Documents/../Pictures"
     *
     * Output: "/home/user/Pictures"
     *
     * Explanation:
     *
     * A double period ".." refers to the directory up a level.
     *
     * Example 4:
     *
     * Input: path = "/../"
     *
     * Output: "/"
     *
     * Explanation:
     *
     * Going one level up from the root directory is not possible.
     *
     * Example 5:
     *
     * Input: path = "/.../a/../b/c/../d/./"
     *
     * Output: "/.../b/d"
     *
     * Explanation:
     *
     * "..." is a valid name for a directory in this problem.
     *
     *
     *
     * Constraints:
     *
     *     1 <= path.length <= 3000
     *     path consists of English letters, digits, period '.', slash '/' or '_'.
     *     path is a valid absolute Unix path.
     *
     *
     *
     *
     */

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] groupedPath = path.split("\\/");

        if(groupedPath.length == 0) {
            return "/";
        }

        stack.push(groupedPath[0]);

        for(int i = 1; i < groupedPath.length; i++) {

            if(groupedPath[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }

            }
            else if(groupedPath[i].equals("//")) {
                stack.push("/");
            }
            else if(groupedPath[i].equals(".")) {
                // Do nothing.
            }
            else if(!groupedPath[i].isEmpty()) {
                stack.push(groupedPath[i]);
            }

        }

        String res = String.join("/", stack);
        String resFormatted = res.startsWith("/") ? res : "/" + res;
        return resFormatted;
    }


    /**
     *
     * 150. Evaluate Reverse Polish Notation
     *
     *
     * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
     *
     * Evaluate the expression. Return an integer that represents the value of the expression.
     *
     * Note that:
     *
     *     The valid operators are '+', '-', '*', and '/'.
     *     Each operand may be an integer or another expression.
     *     The division between two integers always truncates toward zero.
     *     There will not be any division by zero.
     *     The input represents a valid arithmetic expression in a reverse polish notation.
     *     The answer and all the intermediate calculations can be represented in a 32-bit integer.
     *
     *
     *
     * Example 1:
     *
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     *
     * Example 2:
     *
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     *
     * Example 3:
     *
     * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * Output: 22
     * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     *
     *
     *
     * Constraints:
     *
     *     1 <= tokens.length <= 104
     *     tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     */

    public int evalRPN(String[] tokens) {
        if(tokens.length ==1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> numbers = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+")) {
                numbers.push(numbers.pop() + numbers.pop());
            }
            else if(token.equals("-")) {
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a - b);
            }
            else if(token.equals("*")) {
                numbers.push(numbers.pop() * numbers.pop());
            }
            else if(token.equals("/")) {
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a / b);
            }
            else {
                numbers.push(Integer.valueOf(token));
            }
        }

        return numbers.pop();

    }


    /**
     * 224. Basic Calculator
     *
     *
     * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
     *
     * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
     *
     *
     *
     * Example 1:
     *
     * Input: s = "1 + 1"
     * Output: 2
     *
     * Example 2:
     *
     * Input: s = " 2-1 + 2 "
     * Output: 3
     *
     * Example 3:
     *
     * Input: s = "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length <= 3 * 105
     *     s consists of digits, '+', '-', '(', ')', and ' '.
     *     s represents a valid expression.
     *     '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
     *     '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
     *     There will be no two consecutive operators in the input.
     *     Every number and running calculation will fit in a signed 32-bit integer.
     */

    public int calculate(String s) {

        // TODO

        return 0;

    }


    /**
     *
     * 128. Longest Consecutive Sequence
     *
     *
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Example 2:
     *
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     *
     *
     *
     * Constraints:
     *
     *     0 <= nums.length <= 105
     *     -109 <= nums[i] <= 109
     */

    public int longestConsecutive(int[] nums) {


        int res = 0;
        Set<Integer> foundNums = new HashSet<>();

        for(Integer num : nums) {
            foundNums.add(num);
        }

        for(int i = 0; i < nums.length; i++) {

            if(!foundNums.contains(nums[i]-1)) {
                int counter = 0;
                while(counter != nums.length && foundNums.contains(nums[i] + counter)) {
                    foundNums.remove(nums[i] + counter);
                    counter++;

                }
                res = Math.max(res, counter);
            }

        }

        return res;
    }


    /**
     *
     * 202. Happy Number
     *
     *
     * Write an algorithm to determine if a number n is happy.
     *
     * A happy number is a number defined by the following process:
     *
     *     Starting with any positive integer, replace the number by the sum of the squares of its digits.
     *     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     *     Those numbers for which this process ends in 1 are happy.
     *
     * Return true if n is a happy number, and false if not.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     *
     * Example 2:
     *
     * Input: n = 2
     * Output: false
     *
     *
     *
     * Constraints:
     *
     *     1 <= n <= 231 - 1
     */

    public boolean isHappy(int n) {

        return isHappy(new HashSet<>(), n);

    }

    private boolean isHappy(HashSet<Integer> memo, int n) {

        if(n == 1) {
            return true;
        }

        if(n < 0) {
            return false;
        }

        String n_str = String.valueOf(n);

        char[] n_arr = n_str.toCharArray();

        int sum = 0;
        for(char n_char : n_arr) {

            Integer n_dig = Integer.valueOf(String.valueOf(n_char));
            sum += n_dig * n_dig;

        }


        if(memo.contains(sum)) {
            return false;
        }

        memo.add(sum);
        return isHappy(memo, sum);

    }


    /**
     *
     *
     * 15. 3Sum
     *
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     *
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     *
     * Example 3:
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     *
     *
     *
     * Constraints:
     *
     *     3 <= nums.length <= 3000
     *     -105 <= nums[i] <= 105
     */

    public List<List<Integer>> threeSum(int[] nums) { // TODO

        int target = 0;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = nums.length -1;

            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while(l < r) {

                if(nums[i] + nums[l] + nums[r] == target) {

                    List<Integer> found = List.of(nums[i], nums[l], nums[r]);
                    res.add(found);
                    l++;
                    while(nums[l] == nums[l-1]) {
                        l++;
                    }

                }

                if(nums[i] + nums[l] + nums[r] > target) {

                    r--;

                }

                if(nums[i] + nums[l] + nums[r] < target) {

                    l++;

                }

            }

        }

        return res;
    }


    /**
     *
     * 17. Letter Combinations of a Phone Number
     *
     *
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     *
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     *
     *
     * Constraints:
     *
     *     0 <= digits.length <= 4
     *     digits[i] is a digit in the range ['2', '9'].
     *
     *
     *
     */

    public List<String> letterCombinations(String digits) {

        Map<Integer, String[]> map = Map.of(
                2, new String[]{"a","b","c"},
                3, new String[]{"d","e","f"},
                4, new String[]{"g","h","i"},
                5, new String[]{"j","k","l"},
                6, new String[]{"m","n","o"},
                7, new String[]{"p","q","r","s"},
                8, new String[]{"t","u","v"},
                9, new String[]{"w","x","y","z"}
        );

        //TODO

        return List.of("");
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


    /**
     *
     * 134. Gas Station
     *
     *
     * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
     *
     * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
     *
     *
     *
     * Example 1:
     *
     * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * Output: 3
     * Explanation:
     * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
     * Travel to station 4. Your tank = 4 - 1 + 5 = 8
     * Travel to station 0. Your tank = 8 - 2 + 1 = 7
     * Travel to station 1. Your tank = 7 - 3 + 2 = 6
     * Travel to station 2. Your tank = 6 - 4 + 3 = 5
     * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
     * Therefore, return 3 as the starting index.
     *
     * Example 2:
     *
     * Input: gas = [2,3,4], cost = [3,4,3]
     * Output: -1
     * Explanation:
     * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
     * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
     * Travel to station 0. Your tank = 4 - 3 + 2 = 3
     * Travel to station 1. Your tank = 3 - 3 + 3 = 3
     * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
     * Therefore, you can't travel around the circuit once no matter where you start.
     *
     *
     *
     * Constraints:
     *
     *     n == gas.length == cost.length
     *     1 <= n <= 105
     *     0 <= gas[i], cost[i] <= 104
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int index = -1;
        int totalSum = 0;

        if(gas.length == 1) {
            return gas[0] - cost[0] > -1 ? 0 : -1;
        }

        for(int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            totalGas = Math.max(0, totalGas + gas[i] - cost[i]);

            if(gas[i] - cost[i] > 0) {

                if(index < 0) {
                    index = i;
                }

            }

            if(totalGas==0 && i < cost.length -1) {

                index = -1;

            }

        }

        return totalSum >= 0 ? index : -1;

    }

    /**
     *
     *
     * 100. Same Tree
     *
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     *
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     *
     *
     *
     * Example 1:
     *
     * Input: p = [1,2,3], q = [1,2,3]
     * Output: true
     *
     * Example 2:
     *
     * Input: p = [1,2], q = [1,null,2]
     * Output: false
     *
     * Example 3:
     *
     * Input: p = [1,2,1], q = [1,1,2]
     * Output: false
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in both trees is in the range [0, 100].
     *     -104 <= Node.val <= 104
     *
     *
     *
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    /**
     *
     * 28. Find the Index of the First Occurrence in a String
     *
     *
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     *
     *
     * Example 1:
     *
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     *
     * Example 2:
     *
     * Input: haystack = "leetcode", needle = "leeto"
     * Output: -1
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     *
     *
     *
     * Constraints:
     *
     *     1 <= haystack.length, needle.length <= 104
     *     haystack and needle consist of only lowercase English characters.
     */

    public int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length()) {
            return -1;
        }

        int counter = 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(counter)) {
                counter++;
            }
            else {
                i = i - counter;
                counter=0;
            }
            if(needle.length() == counter) {
                return i - needle.length() + 1;
            }

        }

        return -1;

    }


    /**
     *
     *
     * 167. Two Sum II - Input Array Is Sorted
     *
     *
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     *
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     *
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     *
     * Your solution must use only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     *
     * Example 2:
     *
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     *
     * Example 3:
     *
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
     *
     *
     *
     * Constraints:
     *
     *     2 <= numbers.length <= 3 * 104
     *     -1000 <= numbers[i] <= 1000
     *     numbers is sorted in non-decreasing order.
     *     -1000 <= target <= 1000
     *     The tests are generated such that there is exactly one solution.
     */

    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length -1;

        while(numbers[l] + numbers[r] != target) {

            if(numbers[l] + numbers[r] > target) {
                r--;
            }
            if(numbers[l] + numbers[r] < target) {
                l++;
            }
        }

        return new int[]{l +1 , r +1};

    }


    /**
     *
     * 209. Minimum Size Subarray Sum
     *
     *
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     * subarray
     * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     *
     *
     * Example 1:
     *
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     *
     * Example 2:
     *
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     *
     * Example 3:
     *
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     *
     *
     *
     * Constraints:
     *
     *     1 <= target <= 109
     *     1 <= nums.length <= 105
     *     1 <= nums[i] <= 104
     *
     *
     */

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];
            while(sum >= target) {
                res = Math.min(i-l + 1, res);
                sum = sum - nums[l];
                l++;
            }

        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();

        String[] splitGroups = s.split("\\s+");
        char[] patter_arr = pattern.toCharArray();

        if(splitGroups.length != pattern.length()) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {

            if(map.get(patter_arr[i]) == null) {
                if(map.containsValue(splitGroups[i])) {
                    return false;
                }
                map.put(patter_arr[i], splitGroups[i]);
            }
            else {
                if(!map.get(patter_arr[i]).equals(splitGroups[i])) {
                    return false;
                }
            }

        }
        return true;

    }

    /**
     *
     * 3. Longest Substring Without Repeating Characters
     *
     *
     * Given a string s, find the length of the longest
     * substring
     * without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     *
     *
     * Constraints:
     *
     *     0 <= s.length <= 5 * 104
     *     s consists of English letters, digits, symbols and spaces.
     */

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1) {
            return 1;
        }

        int sum = 0;
        int leftPointer = 0;
        char[] s_arr = s.toCharArray();
        Set<Character> map = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            while(map.contains(s_arr[i])) {
                map.remove(s_arr[leftPointer]);
                leftPointer++;
            }

            map.add(s_arr[i]);

            sum = Math.max(sum, map.size());

        }

        return sum;

    }
}
