package leetcode;

import com.chrisparsons.Leetcode;
import com.chrisparsons.leetcode150.helpers.TreeNode;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    @Ignore
    public void reverseTest() {
        Assert.assertEquals(345, this.leetcode.reverse(543));
        Assert.assertEquals(-52, this.leetcode.reverse(-250));
        Assert.assertEquals(1981, this.leetcode.reverse(1891));
        //Assert.assertEquals(1981, this.leetcode.reverse(9646324351));
    }


    @Test
    public void subsetXORSumTest() {
        Assert.assertEquals(28,this.leetcode.subsetXORSum(new int[]{2,5,6}));
    }

    @Test
    public void fizzBuzzTest() {
        List<String> res = this.leetcode.fizzBuzz(30);
        System.out.println();
    }

    @Test
    public void binaryTreePathsTest() {
        TreeNode nodeRight2_2 = new TreeNode(5); // Level 3
        TreeNode nodeLeft_2 = new TreeNode(2, null, nodeRight2_2); // Level 2
        TreeNode nodeRight_2 = new TreeNode(3); // Level 2
        TreeNode nodeHead_2 = new TreeNode(1, nodeLeft_2, nodeRight_2); // Level 1
        Assert.assertEquals(List.of("1->2->5","1->3"), this.leetcode.binaryTreePaths(nodeHead_2));
    }

    @Test
    public void binarySearchTest() {
        Assert.assertEquals(3, this.leetcode.search(new int[] {-1,0,2,4,6,8}, 4));
        Assert.assertEquals(-1, this.leetcode.search(new int[] {-1,0,2,4,6,8}, 3));
        Assert.assertEquals(4, this.leetcode.search(new int[] {-1,0,3,5,9,12}, 9));
    }

    /*
        HARD PROBLEMS
     */

    @Test
    public void longestObstacleCourseAtEachPositionTest() {
        Assert.assertArrayEquals(new int[]{1,2,3,3}, this.leetcode.longestObstacleCourseAtEachPosition(new int[]{1,2,3,2}));
        Assert.assertArrayEquals(new int[]{1,2,1}, this.leetcode.longestObstacleCourseAtEachPosition(new int[]{2,2,1}));
        Assert.assertArrayEquals(new int[]{1,1,2,3,2,2}, this.leetcode.longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2}));
        Assert.assertArrayEquals(new int[]{1}, this.leetcode.longestObstacleCourseAtEachPosition(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1,2}, this.leetcode.longestObstacleCourseAtEachPosition(new int[]{1,2}));
    }

    @Test
    public void maxScoreWordsTest() {


        Assert.assertEquals(23, this.leetcode.maxScoreWords(
                new String[]{"dog","cat","dad","good"},
                new char[] {'a','a','c','d','d','d','g','o','o'},
                new int[] {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
