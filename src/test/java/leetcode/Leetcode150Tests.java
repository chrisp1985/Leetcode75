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
}
