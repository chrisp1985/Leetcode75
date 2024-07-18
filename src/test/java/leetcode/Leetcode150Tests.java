package leetcode;

import com.chrisparsons.leetcode150.LeetCode150;
import com.chrisparsons.leetcode75.RecentCounter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void intToRomanTest() {
        Assert.assertEquals("MMI", this.leetCode150.intToRoman(2001));
        Assert.assertEquals("XVIII", this.leetCode150.intToRoman(18));
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
