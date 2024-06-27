package leetcode;

import com.chrisparsons.Leetcode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetcodeTests {

    Leetcode leetcode;

    public LeetcodeTests() {
        this.leetcode = new Leetcode();
    }

    @Test
    public void twoSumTest() {
        Assert.assertTrue(Arrays.equals(new int[] {0, 1}, this.leetcode.twoSum(new int[]{2,7,11,15}, 9 )));
        Assert.assertTrue(Arrays.equals(new int[] {1, 2}, this.leetcode.twoSum(new int[]{3,2,4}, 6 )));
        Assert.assertTrue(Arrays.equals(new int[] {0, 1}, this.leetcode.twoSum(new int[]{3,3}, 6 )));
    }

    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(this.leetcode.isPalindrome(6000006));
        Assert.assertFalse(this.leetcode.isPalindrome(-6000006));
        Assert.assertTrue(this.leetcode.isPalindrome(6987896));
    }

    @Test
    public void minMovesToSeatTest() {
        Assert.assertEquals(4, this.leetcode.minMovesToSeat(new int[] {3,1,5}, new int[] {2,7,4}));
        Assert.assertEquals(7, this.leetcode.minMovesToSeat(new int[] {4,1,5,9}, new int[] {1,3,2,6}));
        Assert.assertEquals(4, this.leetcode.minMovesToSeat(new int[] {2,2,6,6}, new int[] {1,3,2,6}));
    }
}
