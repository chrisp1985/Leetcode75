package com.chrisparsons;

import com.chrisparsons.leetcode150.helpers.TreeNode;
import com.chrisparsons.leetcode75.helpers.ListNode;

import java.util.*;

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
     *
     * 7. Reverse Integer
     *
     *
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     *
     *
     * Example 1:
     *
     * Input: x = 123
     * Output: 321
     *
     * Example 2:
     *
     * Input: x = -123
     * Output: -321
     *
     * Example 3:
     *
     * Input: x = 120
     * Output: 21
     *
     *
     *
     * Constraints:
     *
     *     -231 <= x <= 231 - 1
     */

    public int reverse(int x) {

        char[] x_arr = String.valueOf(x).toCharArray();

        StringBuilder builder = new StringBuilder();

        boolean negative = false;

        for(int i = x_arr.length -1; i > -1; i--) {

            if(x_arr[i] == '-') {

                negative = true;

            }

            else {

                builder.append(x_arr[i]);

            }

        }

        int value = Integer.parseInt(builder.toString());

        return negative ? value * -1 : value;
    }


    /**
     *
     * Binary Search
     *
     *
     *
     *
     */

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;

        while(l <= r) {

            int mid = (l + r) / 2;

            if(nums[mid]==target) {
                return mid;
            }

            if(nums[mid] > target) {

                r = mid -1;

            }

            if(nums[mid] < target) {

                l = mid + 1;

            }

        }

        return -1;
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

    /**
     * 980. Unique Paths III
     *
     * (HARD)
     *
     * You are given an m x n integer array grid where grid[i][j] could be:
     *
     *     1 representing the starting square. There is exactly one starting square.
     *     2 representing the ending square. There is exactly one ending square.
     *     0 representing empty squares we can walk over.
     *     -1 representing obstacles that we cannot walk over.
     *
     * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
     * Output: 2
     * Explanation: We have the following two paths:
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
     * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
     *
     * Example 2:
     *
     * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
     * Output: 4
     * Explanation: We have the following four paths:
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
     * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
     * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
     * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
     *
     * Example 3:
     *
     * Input: grid = [[0,1],[2,0]]
     * Output: 0
     * Explanation: There is no path that walks over every empty square exactly once.
     * Note that the starting and ending square can be anywhere in the grid.
     */

    public int uniquePathsIII(int[][] grid) {

        return 0;
        //TODO
    }

    /**
     * 1964. Find the Longest Valid Obstacle Course at Each Position
     *
     * You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, where obstacles[i] describes the height of the ith obstacle.
     *
     * For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles such that:
     *
     *     You choose any number of obstacles between 0 and i inclusive.
     *     You must include the ith obstacle in the course.
     *     You must put the chosen obstacles in the same order as they appear in obstacles.
     *     Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
     *
     * Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as described above.
     *
     *
     *
     * Example 1:
     *
     * Input: obstacles = [1,2,3,2]
     * Output: [1,2,3,3]
     * Explanation: The longest valid obstacle course at each position is:
     * - i = 0: [1], [1] has length 1.
     * - i = 1: [1,2], [1,2] has length 2.
     * - i = 2: [1,2,3], [1,2,3] has length 3.
     * - i = 3: [1,2,3,2], [1,2,2] has length 3.
     *
     * Example 2:
     *
     * Input: obstacles = [2,2,1]
     * Output: [1,2,1]
     * Explanation: The longest valid obstacle course at each position is:
     * - i = 0: [2], [2] has length 1.
     * - i = 1: [2,2], [2,2] has length 2.
     * - i = 2: [2,2,1], [1] has length 1.
     *
     * Example 3:
     *
     * Input: obstacles = [3,1,5,6,4,2]
     * Output: [1,1,2,3,2,2]
     * Explanation: The longest valid obstacle course at each position is:
     * - i = 0: [3], [3] has length 1.
     * - i = 1: [3,1], [1] has length 1.
     * - i = 2: [3,1,5], [3,5] has length 2. [1,5] is also valid.
     * - i = 3: [3,1,5,6], [3,5,6] has length 3. [1,5,6] is also valid.
     * - i = 4: [3,1,5,6,4], [3,4] has length 2. [1,4] is also valid.
     * - i = 5: [3,1,5,6,4,2], [1,2] has length 2.
     */

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int[] res = new int[obstacles.length];

        if(obstacles.length == 1) {
            res[0] = obstacles[0];
            return res;
        }

        for(int i = 0; i < obstacles.length; i++) {
            int sum = 0;
            for(int j = i-1; j > -1; j--) {

                if (obstacles[i] >= obstacles[j]) {

                    sum = Math.max(sum, res[j]);

                }

            }
            res[i] = sum + 1;
        }

        return res;

    }


    /**
     *
     * 257. Binary Tree Paths
     *
     *
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
     *
     * A leaf is a node with no children.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [1,2,3,null,5]
     * Output: ["1->2->5","1->3"]
     *
     * Example 2:
     *
     * Input: root = [1]
     * Output: ["1"]
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the tree is in the range [1, 100].
     *     -100 <= Node.val <= 100
     *
     */

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        binaryTreePathsBackTrack(root.right, res, String.valueOf(root.val));
        binaryTreePathsBackTrack(root.left, res, String.valueOf(root.val));
        return res;
    }

    private void binaryTreePathsBackTrack(TreeNode root, List<String> res, String tmpString) {
        tmpString = String.join("->", tmpString, String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            res.add(tmpString);
        }
        else if(root.left == null) {
            binaryTreePathsBackTrack(root.right, res, tmpString);
        }
        else {
            binaryTreePathsBackTrack(root.left, res, tmpString);
        }
    }

    /**
     *
     * 412. Fizz Buzz
     *
     *
     * Given an integer n, return a string array answer (1-indexed) where:
     *
     *     answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     *     answer[i] == "Fizz" if i is divisible by 3.
     *     answer[i] == "Buzz" if i is divisible by 5.
     *     answer[i] == i (as a string) if none of the above conditions are true.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 3
     * Output: ["1","2","Fizz"]
     *
     * Example 2:
     *
     * Input: n = 5
     * Output: ["1","2","Fizz","4","Buzz"]
     *
     * Example 3:
     *
     * Input: n = 15
     * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
     */

    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                res.add("Fizz");
            }
            else if(i % 5 == 0) {
                res.add("Buzz");
            }
            else {
                res.add(String.valueOf(i));
            }

        }

        return res;
    }


    public int subsetXORSum(int[] nums) {

        return subsetXORSumBacktrack(nums, 0, 0);

    }

    private int subsetXORSumBacktrack(int[] nums, int res, int start) {

        if(start == nums.length) {
            return res;
        }

        int includeCurrentElement = subsetXORSumBacktrack(nums, res ^ nums[start], start+1);
        int excludeCurrentElement = subsetXORSumBacktrack(nums, res, start+1);

        return includeCurrentElement + excludeCurrentElement;

    }

    /**
     *
     * 2037. Minimum Number of Moves to Seat Everyone
     *
     *
     * There are n seats and n students in a room. You are given an array seats of length n, where seats[i] is the
     * position of the ith seat. You are also given the array students of length n, where students[j] is the position
     * of the jth student.
     *
     * You may perform the following move any number of times:
     *
     *     Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1
     *     or x - 1)
     *
     * Return the minimum number of moves required to move each student to a seat such that no two students are in the
     * same seat.
     *
     * Note that there may be multiple seats or students in the same position at the beginning.
     *
     *
     *
     * Example 1:
     *
     * Input: seats = [3,1,5], students = [2,7,4]
     * Output: 4
     * Explanation: The students are moved as follows:
     * - The first student is moved from from position 2 to position 1 using 1 move.
     * - The second student is moved from from position 7 to position 5 using 2 moves.
     * - The third student is moved from from position 4 to position 3 using 1 move.
     * In total, 1 + 2 + 1 = 4 moves were used.
     *
     * Example 2:
     *
     * Input: seats = [4,1,5,9], students = [1,3,2,6]
     * Output: 7
     * Explanation: The students are moved as follows:
     * - The first student is not moved.
     * - The second student is moved from from position 3 to position 4 using 1 move.
     * - The third student is moved from from position 2 to position 5 using 3 moves.
     * - The fourth student is moved from from position 6 to position 9 using 3 moves.
     * In total, 0 + 1 + 3 + 3 = 7 moves were used.
     *
     * Example 3:
     *
     * Input: seats = [2,2,6,6], students = [1,3,2,6]
     * Output: 4
     * Explanation: Note that there are two seats at position 2 and two seats at position 6.
     * The students are moved as follows:
     * - The first student is moved from from position 1 to position 2 using 1 move.
     * - The second student is moved from from position 3 to position 6 using 3 moves.
     * - The third student is not moved.
     * - The fourth student is not moved.
     * In total, 1 + 3 + 0 + 0 = 4 moves were used.
     *
     */

    public int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int count = 0;
        for(int i = 0; i < students.length; i++) {
            count += Math.max(students[i] - seats[i], seats[i] - students[i]);
        }
        return count;
    }

    /**
     *
     * 1255. Maximum Score Words Formed by Letters
     *
     * Given a list of words, list of  single letters (might be repeating) and score of every character.
     *
     * Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
     *
     * It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
     * Output: 23
     * Explanation:
     * Score  a=1, c=9, d=5, g=3, o=2
     * Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
     * Words "dad" and "dog" only get a score of 21.
     *
     * Example 2:
     *
     * Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
     * Output: 27
     * Explanation:
     * Score  a=4, b=4, c=4, x=5, z=10
     * Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
     * Word "xxxz" only get a score of 25.
     *
     * Example 3:
     *
     * Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
     * Output: 0
     * Explanation:
     * Letter "e" can only be used once.
     */

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        HashMap<Character, Integer> alphabetCount = new HashMap<>();

        for(int i = 0; i < alphabet.length; i++) {
            alphabetCount.put(alphabet[i], 0);
        }

        for (char letter : letters) {
            alphabetCount.put(letter, alphabetCount.get(letter) + 1);
        }

        HashMap<Character, Integer> characterScoresMap = new HashMap<>();
        for(int i = 0; i < alphabet.length; i++) {
            characterScoresMap.put(alphabet[i], score[i]);
        }

        int maxSum = 0;

        for(String word : words) {
            int localCount = 0;
            for(char arrChar : word.toCharArray()) {

                if(alphabetCount.get(arrChar) > 0) {
                    localCount += characterScoresMap.get(arrChar);
                    alphabetCount.put(arrChar, alphabetCount.get(arrChar)-1);
                }
                else {
                    break;
                }

            }

            maxSum = Math.max(maxSum, localCount);

        }

        return maxSum;
    }
}
