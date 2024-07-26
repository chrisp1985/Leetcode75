package com.chrisparsons;

import com.chrisparsons.leetcode150.helpers.TreeNode;

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
}
