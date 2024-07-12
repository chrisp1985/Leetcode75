package leetcode;

import com.chrisparsons.leetcode150.LeetCode150;
import com.chrisparsons.leetcode75.RecentCounter;
import org.junit.Assert;
import org.junit.Test;

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
    public void jumpTest() {
        Assert.assertEquals(2, this.leetCode150.jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(0, this.leetCode150.jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(0, this.leetCode150.jump(new int[]{3,2,1,4}));
        Assert.assertEquals(2, this.leetCode150.jump(new int[]{2,5,0,0}));
    }

    @Test
    public void isPalindromeTest() {
//        Assert.assertTrue(this.leetCode150.isPalindrome("A man, a plan, a canal: Panama"));
//        Assert.assertFalse(this.leetCode150.isPalindrome("race a car"));
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
//        Assert.assertEquals(2, this.leetCode150.climbStairs(2));
//        Assert.assertEquals(3, this.leetCode150.climbStairs(3));
        Assert.assertEquals(5, this.leetCode150.climbStairs(4));
        Assert.assertEquals(8, this.leetCode150.climbStairs(5));
        Assert.assertEquals(13, this.leetCode150.climbStairs(6));
        Assert.assertEquals(21, this.leetCode150.climbStairs(7));
        Assert.assertEquals(34, this.leetCode150.climbStairs(8));
        Assert.assertEquals(55, this.leetCode150.climbStairs(9));
        Assert.assertEquals(89, this.leetCode150.climbStairs(10));
    }
}
