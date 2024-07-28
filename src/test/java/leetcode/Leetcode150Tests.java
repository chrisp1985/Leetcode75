package leetcode;

import com.chrisparsons.leetcode150.LeetCode150;
import com.chrisparsons.leetcode150.helpers.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Leetcode150Tests {


    LeetCode150 leetCode150;

    public Leetcode150Tests() {
        this.leetCode150 = new LeetCode150();
    }

    @Test
    public void rotateTest() {
        this.leetCode150.rotate(new int[] {1,2,3,4,5,6,7}, 3);
        this.leetCode150.rotate(new int[] {-1}, 2);
    }

    @Test
    public void maxProfitTest() {
        Assert.assertEquals(7, this.leetCode150.maxProfit(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(4, this.leetCode150.maxProfit(new int[] {1,2,3,4,5}));
        Assert.assertEquals(0, this.leetCode150.maxProfit(new int[] {7,6,4,3,1}));
    }

    @Test
    public void findMedianSortedArraysTest() {
        Assert.assertEquals(2.0000, this.leetCode150.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0);
        Assert.assertEquals(2.5000, this.leetCode150.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0);
    }

    @Test
    public void scoreOfStringTest() {

        Assert.assertEquals(13, this.leetCode150.scoreOfString("hello"));
    }

    @Test
    public void canJumpTest() {
        Assert.assertTrue(this.leetCode150.canJump(new int[]{2,3,1,1,4}));
        Assert.assertFalse(this.leetCode150.canJump(new int[]{3,2,1,0,4}));
        Assert.assertTrue(this.leetCode150.canJump(new int[]{0}));
        Assert.assertTrue(this.leetCode150.canJump(new int[]{2,5,0,0}));
        Assert.assertFalse(this.leetCode150.canJump(new int[]{0,2,5,0,0}));
        Assert.assertFalse(this.leetCode150.canJump(new int[]{0,1}));
        Assert.assertTrue(this.leetCode150.canJump(new int[]{1,2}));
    }

    @Test
    public void jumpTest() { //TODO
        Assert.assertEquals(2, this.leetCode150.jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(1, this.leetCode150.jump(new int[]{3,2,1,4}));
        Assert.assertEquals(2, this.leetCode150.jump(new int[]{2,5,0,0}));
        Assert.assertEquals(5, this.leetCode150.jump(new int[]{2,5,0,0,1,2,0,3,2,1,1,5}));
        Assert.assertEquals(4, this.leetCode150.jump(new int[]{2,3,1,1,1,4,1,0,0}));
        Assert.assertEquals(1, this.leetCode150.jump(new int[]{2,3,1}));
        Assert.assertEquals(3, this.leetCode150.jump(new int[]{1,1,1,1}));
    }

    @Test
    public void groupAnagramsTest() {
        Assert.assertEquals(List.of(
                List.of("bat"),
                List.of("nat","tan"),
                List.of("ate","eat","tea")),
                this.leetCode150.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

        Assert.assertEquals(List.of(
                List.of("")),
                this.leetCode150.groupAnagrams(new String[]{""}));

        Assert.assertEquals(List.of(
                        List.of("a")),
                this.leetCode150.groupAnagrams(new String[]{"a"}));
    }

    @Test
    public void isIsomorphicTest() {
        Assert.assertTrue(this.leetCode150.isIsomorphic("egg", "add"));
        Assert.assertFalse(this.leetCode150.isIsomorphic("foo", "bar"));
        Assert.assertTrue(this.leetCode150.isIsomorphic("paper", "title"));
        Assert.assertTrue(this.leetCode150.isIsomorphic("p", "t"));
        Assert.assertTrue(this.leetCode150.isIsomorphic("ppppp", "ttttt"));
        Assert.assertFalse(this.leetCode150.isIsomorphic("ppppr", "ttttt"));
        Assert.assertFalse(this.leetCode150.isIsomorphic("ppppp", "ttttr"));
    }

    @Test
    public void mergeTest() {
        Assert.assertEquals(new int[][]{{1,6}, {8,10}, {15,18}}, this.leetCode150.merge(new int[][]{{1,3}, {2,6},{8,10},{15,18}}));
        Assert.assertEquals(new int[][]{{1,18}}, this.leetCode150.merge(new int[][]{{1,18}, {2,6},{8,10},{15,18}}));
        Assert.assertEquals(new int[][]{{1,18}}, this.leetCode150.merge(new int[][]{{1,4}, {2,6},{8,10},{1,18}}));
        Assert.assertEquals(new int[][]{{1,18}}, this.leetCode150.merge(new int[][]{{1,4}, {2,6},{8,10},{1,18}}));
    }

    @Test
    public void canConstructTest() { // TODO
        Assert.assertTrue(this.leetCode150.canConstruct("aa", "aab"));
        Assert.assertFalse(this.leetCode150.canConstruct("aa", "ab"));
        Assert.assertTrue(this.leetCode150.canConstruct("aabbccl", "caabblc"));
        Assert.assertTrue(this.leetCode150.canConstruct("az", "ab"));
    }

    @Test
    public void isValidTest() {
        Assert.assertTrue(this.leetCode150.isValid("()[]{}"));
        Assert.assertTrue(this.leetCode150.isValid("{([])}"));
        Assert.assertFalse(this.leetCode150.isValid("()[{}"));
    }

    @Test
    public void simplifyPathTest() {
        Assert.assertEquals("/home/foo", this.leetCode150.simplifyPath("/home//foo/"));
        Assert.assertEquals("/home/user/Pictures", this.leetCode150.simplifyPath("/home/user/Documents/../Pictures"));
        Assert.assertEquals("/.../b/d", this.leetCode150.simplifyPath("/.../a/../b/c/../d/./"));
        Assert.assertEquals("/", this.leetCode150.simplifyPath("/../"));
        Assert.assertEquals("/home", this.leetCode150.simplifyPath("/home/"));
        Assert.assertEquals("/chris/trial/new/again/chris/pop", this.leetCode150.simplifyPath("/home/../chris/trial/new//trial/../again/chris/pop/this/one/../../"));
        Assert.assertEquals("/c", this.leetCode150.simplifyPath("/a/../../b/../c//.//"));
        Assert.assertEquals("/", this.leetCode150.simplifyPath("/"));
        Assert.assertEquals("/", this.leetCode150.simplifyPath("/home/../../.."));
    }

    @Test
    public void evalRPNTest() {
        Assert.assertEquals(9, this.leetCode150.evalRPN(new String[]{"2","1","+","3","*"}));
        Assert.assertEquals(6, this.leetCode150.evalRPN(new String[]{"4","13","5","/","+"}));
        Assert.assertEquals(22, this.leetCode150.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        Assert.assertEquals(20, this.leetCode150.evalRPN(new String[]{"4","6","+","4","6","+","+"}));
        Assert.assertEquals(18, this.leetCode150.evalRPN(new String[]{"18"}));
        Assert.assertEquals(9, this.leetCode150.evalRPN(new String[]{"3","11","+","5","-"}));
        Assert.assertEquals(-13, this.leetCode150.evalRPN(new String[]{"3","11","5","+","-"}));
    }

    @Test
    public void threeSumTest() {
        this.leetCode150.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    @Test
    public void letterCombinationsTest() {
        Assert.assertEquals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf"), this.leetCode150.letterCombinations("23"));
    }

    @Test
    public void combineTest() {
        Assert.assertEquals(List.of(
                List.of(1,2),
                List.of(1,3),
                List.of(1,4),
                List.of(2,3),
                List.of(2,4),
                List.of(3,4)),
                this.leetCode150.combine(4, 2));
    }

    @Test
    public void combinationSumTest() {
//        Assert.assertEquals(List.of(
//                List.of(2,2,3),
//                List.of(7)), this.leetCode150.combinationSum(new int[]{2,3,6,7}, 7));
//
//        Assert.assertEquals(List.of(
//                List.of(2,2,2,2),
//                List.of(2,3,3),
//                List.of(3,5)), this.leetCode150.combinationSum(new int[]{2,3,5}, 8));

        Assert.assertEquals(List.of(
                List.of(8,3),
                List.of(7,4),
                List.of(4,4,3)), this.leetCode150.combinationSum(new int[]{8,7,4,3}, 11));
    }

    @Test
    public void permuteTest() {
        Assert.assertEquals(List.of(
                List.of(1,2,3),
                List.of(1,3,2),
                List.of(2,1,3),
                List.of(2,3,1),
                List.of(3,1,2),
                List.of(3,2,1)),
                this.leetCode150.permute(new int[] {1,2,3}));
    }

    @Test
    public void longestConsecutiveTest() {
        Assert.assertEquals(9, this.leetCode150.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        Assert.assertEquals(4, this.leetCode150.longestConsecutive(new int[]{100,4,200,1,3,2}));
        Assert.assertEquals(6, this.leetCode150.longestConsecutive(new int[]{12,100,4,7,10,200,1,3,2,8,11,9}));
    }

    @Test
    public void isHappyTest() {
        Assert.assertTrue(this.leetCode150.isHappy(1));
        Assert.assertFalse(this.leetCode150.isHappy(2));
        Assert.assertFalse(this.leetCode150.isHappy(3));
        Assert.assertFalse(this.leetCode150.isHappy(4));
        Assert.assertFalse(this.leetCode150.isHappy(5));
        Assert.assertFalse(this.leetCode150.isHappy(6));
        Assert.assertTrue(this.leetCode150.isHappy(7));
        Assert.assertFalse(this.leetCode150.isHappy(8));
        Assert.assertFalse(this.leetCode150.isHappy(9));
        Assert.assertTrue(this.leetCode150.isHappy(10));
        Assert.assertFalse(this.leetCode150.isHappy(11));
        Assert.assertFalse(this.leetCode150.isHappy(12));
        Assert.assertTrue(this.leetCode150.isHappy(13));
        Assert.assertFalse(this.leetCode150.isHappy(14));
        Assert.assertTrue(this.leetCode150.isHappy(19));
    }

    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(this.leetCode150.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(this.leetCode150.isPalindrome("race a car"));
        Assert.assertTrue(this.leetCode150.isPalindrome(" "));
    }

    @Test
    public void isSubsequenceTest() {
        Assert.assertTrue(this.leetCode150.isSubsequence("abc", "ahbgdc"));
        Assert.assertFalse(this.leetCode150.isSubsequence("axc", "ahbgdc"));
        Assert.assertTrue(this.leetCode150.isSubsequence("e", "christopherparsons"));
        Assert.assertTrue(this.leetCode150.isSubsequence("", "christopherparsons"));
    }

    @Test
    public void climbStairsTest() {
        Assert.assertEquals(2, this.leetCode150.climbStairs(2));
        Assert.assertEquals(3, this.leetCode150.climbStairs(3));
        Assert.assertEquals(5, this.leetCode150.climbStairs(4));
        Assert.assertEquals(8, this.leetCode150.climbStairs(5));
        Assert.assertEquals(13, this.leetCode150.climbStairs(6));
        Assert.assertEquals(21, this.leetCode150.climbStairs(7));
        Assert.assertEquals(34, this.leetCode150.climbStairs(8));
        Assert.assertEquals(55, this.leetCode150.climbStairs(9));
        Assert.assertEquals(89, this.leetCode150.climbStairs(10));
    }

    @Test
    public void reverseWordsTest() {
        Assert.assertEquals("blue is sky the", this.leetCode150.reverseWords("the sky is blue"));
        Assert.assertEquals("world hello", this.leetCode150.reverseWords("  hello world  "));
        Assert.assertEquals("example good a", this.leetCode150.reverseWords("a good   example"));
    }

    @Test
    public void convertTest() {
        Assert.assertEquals("PAHNAPLSIIGYIR", this.leetCode150.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", this.leetCode150.convert("PAYPALISHIRING", 4));
        Assert.assertEquals("A", this.leetCode150.convert("A", 1));
    }

    @Test
    public void longestCommonPrefixTest() {
//        Assert.assertEquals("fl", this.leetCode150.longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        Assert.assertEquals("", this.leetCode150.longestCommonPrefix(new String[]{"dog","racecar","car"}));
//        Assert.assertEquals("", this.leetCode150.longestCommonPrefix(new String[]{""}));
        Assert.assertEquals("a", this.leetCode150.longestCommonPrefix(new String[]{"a"}));
    }

    @Test
    public void canCompleteCircuitTest() {
        Assert.assertEquals(3, this.leetCode150.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[] {3,4,5,1,2}));
        Assert.assertEquals(3, this.leetCode150.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[] {3,4,5,1,2}));
        Assert.assertEquals(-1, this.leetCode150.canCompleteCircuit(new int[]{2,3,4}, new int[] {3,4,3}));
        Assert.assertEquals(4, this.leetCode150.canCompleteCircuit(new int[]{2,3,4,3,5}, new int[] {3,4,3,4,1}));
        Assert.assertEquals(-1, this.leetCode150.canCompleteCircuit(new int[]{2,3,4,3,5}, new int[] {5,6,3,4,1}));
        Assert.assertEquals(0, this.leetCode150.canCompleteCircuit(new int[]{2}, new int[] {2}));
        Assert.assertEquals(1, this.leetCode150.canCompleteCircuit(new int[]{2,5}, new int[] {3,2}));
        Assert.assertEquals(2, this.leetCode150.canCompleteCircuit(new int[]{1,1,9,1,1}, new int[] {3,3,1,4,1}));
        Assert.assertEquals(0, this.leetCode150.canCompleteCircuit(new int[]{3,1,1}, new int[] {1,2,2}));
        Assert.assertEquals(-1, this.leetCode150.canCompleteCircuit(new int[]{4}, new int[] {5}));
        Assert.assertEquals(0, this.leetCode150.canCompleteCircuit(new int[]{5}, new int[] {4}));
    }

    @Test
    public void intToRomanTest() {
        Assert.assertEquals("MMI", this.leetCode150.intToRoman(2001));
        Assert.assertEquals("XVIII", this.leetCode150.intToRoman(18));
    }

    @Test
    public void isSameTreeTest() {
        TreeNode nodeLeft3 = new TreeNode(4); // Level 4
        TreeNode nodeRight3 = new TreeNode(12); // Level 4
        TreeNode nodeLeft2 = new TreeNode(14, nodeLeft3, nodeRight3); // Level 3
        TreeNode nodeRight2 = new TreeNode(12); // Level 3
        TreeNode nodeLeft = new TreeNode(10, nodeLeft2, nodeRight2); // Level 2
        TreeNode nodeRight = new TreeNode(9); // Level 2
        TreeNode nodeHead = new TreeNode(8, nodeLeft, nodeRight); // Level 1


        TreeNode nodeLeft3_2 = new TreeNode(4); // Level 4
        TreeNode nodeRight3_2 = new TreeNode(12); // Level 4
        TreeNode nodeLeft2_2 = new TreeNode(14, nodeLeft3_2, nodeRight3_2); // Level 3
        TreeNode nodeRight2_2 = new TreeNode(12); // Level 3
        TreeNode nodeLeft_2 = new TreeNode(10, nodeLeft2_2, nodeRight2_2); // Level 2
        TreeNode nodeRight_2 = new TreeNode(9); // Level 2
        TreeNode nodeHead_2 = new TreeNode(8, nodeLeft_2, nodeRight_2); // Level 1

        Assert.assertTrue(this.leetCode150.isSameTree(nodeHead, nodeHead_2));
    }

    @Test
    public void isSameTreeTest2() {
        TreeNode nodeLeft = new TreeNode(1); // Level 2
        TreeNode nodeRight = new TreeNode(2); // Level 2
        TreeNode nodeHead = new TreeNode(1, nodeLeft, nodeRight); // Level 1

        TreeNode nodeLeft_2 = new TreeNode(2); // Level 2
        TreeNode nodeRight_2 = new TreeNode(1); // Level 2
        TreeNode nodeHead_2 = new TreeNode(1, nodeLeft_2, nodeRight_2); // Level 1

        Assert.assertFalse(this.leetCode150.isSameTree(nodeHead, nodeHead_2));
    }

    @Test
    public void strStrTest() {
        Assert.assertEquals(0, this.leetCode150.strStr("sadbutsad", "sad"));
        Assert.assertEquals(-1, this.leetCode150.strStr("leetcode", "leeto"));
        Assert.assertEquals(0, this.leetCode150.strStr("a", "a"));
        Assert.assertEquals(-1, this.leetCode150.strStr("abc", "abcd"));
        Assert.assertEquals(4, this.leetCode150.strStr("mississippi", "issip"));
        Assert.assertEquals(-1, this.leetCode150.strStr("mississippi", "issipi"));
    }

    @Test
    public void twoSumTest() {
        Assert.assertTrue(Arrays.equals(this.leetCode150.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        Assert.assertTrue(Arrays.equals(this.leetCode150.twoSum(new int[]{2,3,4}, 6), new int[]{1,3}));
        Assert.assertTrue(Arrays.equals(this.leetCode150.twoSum(new int[]{-1,0},  -1), new int[]{1,2}));
    }

    @Test
    public void minSubArrayLenTest() {
        Assert.assertEquals(2, this.leetCode150.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        Assert.assertEquals(1, this.leetCode150.minSubArrayLen(4, new int[]{1,4,4}));
        Assert.assertEquals(0, this.leetCode150.minSubArrayLen(10, new int[]{1,1,1,1,1,1,1,1}));
        Assert.assertEquals(1, this.leetCode150.minSubArrayLen(10, new int[]{10,5,5,4,6,3,3,4}));
        Assert.assertEquals(1, this.leetCode150.minSubArrayLen(10, new int[]{10,5,5,4,6,3,3,4}));
        Assert.assertEquals(1, this.leetCode150.minSubArrayLen(10, new int[]{10}));
        Assert.assertEquals(0, this.leetCode150.minSubArrayLen(11, new int[]{10}));
        Assert.assertEquals(3, this.leetCode150.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    @Test
    public void wordPatternTest() {
        Assert.assertTrue(this.leetCode150.wordPattern("abba", "dog cat cat dog"));
        Assert.assertFalse(this.leetCode150.wordPattern("abba", "dog cat cat fish"));
        Assert.assertFalse(this.leetCode150.wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertFalse(this.leetCode150.wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertFalse(this.leetCode150.wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertFalse(this.leetCode150.wordPattern("abba", "dog dog dog dog"));
        Assert.assertTrue(this.leetCode150.wordPattern("jbkjb", "i am what i am"));
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        Assert.assertEquals(5, this.leetCode150.lengthOfLongestSubstring("abcbfkjbc"));
        Assert.assertEquals(1, this.leetCode150.lengthOfLongestSubstring("bbbbbbbb"));
        Assert.assertEquals(4, this.leetCode150.lengthOfLongestSubstring("abcabcabl"));
        Assert.assertEquals(1, this.leetCode150.lengthOfLongestSubstring(" "));
        Assert.assertEquals(2, this.leetCode150.lengthOfLongestSubstring("au"));
    }
}
