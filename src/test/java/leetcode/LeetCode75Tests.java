package leetcode;

import com.chrisparsons.LeetCode75;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCode75Tests {

    LeetCode75 leetCode75;

    public LeetCode75Tests() {
        this.leetCode75 = new LeetCode75();
    }

    @Test
    public void mergeStringsAlternativelyTest() {
        System.out.println(this.leetCode75.mergeStringsAlternatively("temp", "football"));
        System.out.println(this.leetCode75.mergeStringsAlternatively("t", "football"));
        System.out.println(this.leetCode75.mergeStringsAlternatively("temporary", "f"));
        System.out.println(this.leetCode75.mergeStringsAlternatively("temporary", ""));
        System.out.println(this.leetCode75.mergeStringsAlternatively("", "football"));
    }

    @Test
    public void gcdOfStringsTest() {
        System.out.println(this.leetCode75.gcdOfStrings("hahhaha", "haha"));
        System.out.println(this.leetCode75.gcdOfStrings("piece", "cake"));
        System.out.println(this.leetCode75.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(this.leetCode75.gcdOfStrings("ABCDEF", "ABC"));
        System.out.println(this.leetCode75.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        System.out.println(this.leetCode75.gcdOfStrings("ABABABAB", "ABAB"));
    }

    @Test
    public void kidsWithCandiesTest() {
        System.out.println(this.leetCode75.kidsWithCandies(new int[]{0,1,2,2,3,0,4,2}, 5));
        System.out.println(this.leetCode75.kidsWithCandies(new int[]{0,1,2,2,3,0,4,2}, 1));
        System.out.println(this.leetCode75.kidsWithCandies(new int[]{0,1,2,2,3,0,4,2}, 3));
        System.out.println(this.leetCode75.kidsWithCandies(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(this.leetCode75.kidsWithCandies(new int[]{0,1,2,2,3,0,4,2}, 0));
    }

    @Test
    public void canPlaceFlowersTest() {
        Assert.assertTrue(this.leetCode75.canPlaceFlowers(new int[]{0,0,0,0,1,1,0,1,0,1,1,0,0}, 2)); // true
        Assert.assertFalse(this.leetCode75.canPlaceFlowers(new int[]{1,0,0,0,1}, 2)); // false
        Assert.assertTrue(this.leetCode75.canPlaceFlowers(new int[]{0,0,1,0,1,1,0,1,0,1,1,0,0}, 2)); // true
        Assert.assertTrue(this.leetCode75.canPlaceFlowers(new int[]{0}, 1)); // true
        Assert.assertFalse(this.leetCode75.canPlaceFlowers(new int[]{1,1,1,1,1,1,1,1,1,1,1}, 1)); // false
        Assert.assertFalse(this.leetCode75.canPlaceFlowers(new int[]{0,1,0,1,0,1,0,1,0}, 1)); // false
    }

    @Test
    public void reverseVowelsTest() {
        System.out.println(this.leetCode75.reverseVowels("hello"));
        System.out.println(this.leetCode75.reverseVowels("abacus"));
        System.out.println(this.leetCode75.reverseVowels("horacio"));
        System.out.println(this.leetCode75.reverseVowels("portabello"));
        System.out.println(this.leetCode75.reverseVowels("zoomer"));
        System.out.println(this.leetCode75.reverseVowels("aA"));
    }

    @Test
    public void reverseWordsTest() {
        System.out.println(this.leetCode75.reverseWords("the sky is blue"));
        System.out.println(this.leetCode75.reverseWords("  hello world  "));
        System.out.println(this.leetCode75.reverseWords("a good   example"));
    }

    @Test
    public void productExceptSelfTest() {
        System.out.println(Arrays.toString(this.leetCode75.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    @Test
    public void increasingTripletTest2() {
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{1, 2, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{1, 2, 2, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{1, 2, 8, 3, 4}));
        Assert.assertFalse(this.leetCode75.increasingTriplet2(new int[]{1, 2, 1, 3, 2}));
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{1, 7, 6, 9, 8, 10, 9, 11, 12}));
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{1,2,3,4,5}));
        Assert.assertFalse(this.leetCode75.increasingTriplet2(new int[]{5,4,3,2,1}));
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{2,1,5,0,4,6}));
        Assert.assertTrue(this.leetCode75.increasingTriplet2(new int[]{20,100,10,12,5,13}));
    }

    @Test
    public void increasingTripletMemoryTest() {
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{1, 2, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{1, 2, 2, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{1, 2, 8, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{1, 2, 1, 3, 2}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{1, 7, 6, 9, 8, 10, 9, 11, 12}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{1,2,3,4,5}));
        Assert.assertFalse(this.leetCode75.increasingTripletMemoryEfficient(new int[]{5,4,3,2,1}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{2,1,5,0,4,6}));
        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{20,100,10,12,5,13}));

        Assert.assertTrue(this.leetCode75.increasingTripletMemoryEfficient(new int[]{20,100,10,12,5,13}));
    }

    @Test
    public void increasingTripletTest() {
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{1, 2, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{1, 2, 2, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{1, 2, 8, 3, 4}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{1, 2, 1, 3, 2}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{1, 7, 6, 9, 8, 10, 9, 11, 12}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{1,2,3,4,5}));
        Assert.assertFalse(this.leetCode75.increasingTriplet(new int[]{5,4,3,2,1}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{2,1,5,0,4,6}));
        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{20,100,10,12,5,13}));

        Assert.assertTrue(this.leetCode75.increasingTriplet(new int[]{20,100,10,12,5, 15,13}));
    }

    @Test
    public void compressTest() {
        Assert.assertEquals(6, this.leetCode75.compress("fdfdsf".toCharArray()));
        Assert.assertEquals(6, this.leetCode75.compress("abbbbbbbbbbbbbbccc".toCharArray()));
        Assert.assertEquals(6, this.leetCode75.compress("aabbccc".toCharArray()));
        Assert.assertEquals(11, this.leetCode75.compress("abababababa".toCharArray()));
        Assert.assertEquals(8, this.leetCode75.compress("eeeeeeeeeerrrrrrrtuuuuuu".toCharArray())); // e10r7tu6
        Assert.assertEquals(0, this.leetCode75.compress("".toCharArray()));
        Assert.assertEquals(1, this.leetCode75.compress("a".toCharArray()));
    }

    @Test
    public void moveZeroesTest() {
        this.leetCode75.moveZeroes(new int[]{1, 0, 6, 9, 8, 0, 9, 11, 12});
        this.leetCode75.moveZeroes(new int[]{0});
        this.leetCode75.moveZeroes(new int[]{1, 0, 6, 9, 8, 0, 9, 0, 0});
        this.leetCode75.moveZeroes(new int[]{0,1,0,3,12});
        this.leetCode75.moveZeroes(new int[]{0,1,0,3,0});
        this.leetCode75.moveZeroes(new int[]{0,1,0});
        this.leetCode75.moveZeroes(new int[]{0,0,1});
        this.leetCode75.moveZeroes(new int[]{0,0,0});
    }

    @Test
    public void isSubsequenceTest() {
        Assert.assertTrue(this.leetCode75.isSubsequence("abc", "ahbgdc"));
        Assert.assertFalse(this.leetCode75.isSubsequence("axc", "ahbgdc"));
        Assert.assertTrue(this.leetCode75.isSubsequence("bababababab", "babababababababababa"));
        Assert.assertTrue(this.leetCode75.isSubsequence("b", "ahbgdc"));
        Assert.assertTrue(this.leetCode75.isSubsequence("aaa", "ahbaaadc"));
        Assert.assertTrue(this.leetCode75.isSubsequence("bbb", "abhbgbdcb"));
        Assert.assertFalse(this.leetCode75.isSubsequence("", "abhbgbdcb"));
    }

    @Test
    public void maxAreaTest() {
        Assert.assertEquals(49, this.leetCode75.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(4, this.leetCode75.maxArea(new int[]{1,2,4,3}));
        Assert.assertEquals(1, this.leetCode75.maxArea(new int[]{1,1}));
        Assert.assertEquals(30, this.leetCode75.maxArea(new int[]{300, 20, 1, 4, 5, 6}));
        Assert.assertEquals(200, this.leetCode75.maxArea(new int[]{300, 200, 1, 0, 1, 2}));
    }

    @Test
    public void maxOperationsTest() {
        Assert.assertEquals(2, this.leetCode75.maxOperations(new int[]{1,2,3,4}, 5));
        Assert.assertEquals(1, this.leetCode75.maxOperations(new int[]{3,1,3,4,3}, 6));
        Assert.assertEquals(4, this.leetCode75.maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
    }

    @Test
    public void findMaxAverageTest() {
        Assert.assertEquals(12.75, this.leetCode75.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 0.0001);
        Assert.assertEquals(5.0, this.leetCode75.findMaxAverage(new int[]{5}, 1), 0.0001);
        Assert.assertEquals(4.0, this.leetCode75.findMaxAverage(new int[]{0,4,0,3,2}, 1), 0.0001);
    }

    @Test
    public void maxVowelsTest() {
        Assert.assertEquals(3, this.leetCode75.maxVowels("abciiidef", 3));
        Assert.assertEquals(2, this.leetCode75.maxVowels("aeiou", 2));
        Assert.assertEquals(2, this.leetCode75.maxVowels("leetcode", 3));
    }

    @Test
    public void longestOnesTest() {
        Assert.assertEquals(6, this.leetCode75.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        Assert.assertEquals(10, this.leetCode75.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        Assert.assertEquals(10, this.leetCode75.longestOnes(new int[]{1,1,1,1,1,1,1,1,1,1}, 3));
        Assert.assertEquals(3, this.leetCode75.longestOnes(new int[]{0,0,0,0,0,0,0,0,0,0}, 3));
    }

    @Test
    public void longestSubarrayTest() {
        Assert.assertEquals(3, this.leetCode75.longestSubarray(new int[]{1,1,0,1}));
        Assert.assertEquals(5, this.leetCode75.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        Assert.assertEquals(2, this.leetCode75.longestSubarray(new int[]{1,1,1}));
    }

    @Test
    public void largestAltitudeTest() {
        Assert.assertEquals(1, this.leetCode75.largestAltitude(new int[]{-5,1,5,0,-7}));
        Assert.assertEquals(0, this.leetCode75.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    @Test
    public void pivotIndexTest() {
        Assert.assertEquals(3, this.leetCode75.pivotIndex(new int[]{1,7,3,6,5,6}));
        Assert.assertEquals(-1, this.leetCode75.pivotIndex(new int[]{1,2,3}));
        Assert.assertEquals(0, this.leetCode75.pivotIndex(new int[]{2,1,-1}));
        Assert.assertEquals(0, this.leetCode75.pivotIndex(new int[]{1}));
        Assert.assertEquals(0, this.leetCode75.pivotIndex(new int[]{0,0}));
    }

    @Test
    public void findDifferenceTest() {
        Assert.assertEquals(List.of(List.of(1,3), List.of(4,6)), this.leetCode75.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        Assert.assertEquals(List.of(List.of(3), List.of()), this.leetCode75.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    @Test
    public void uniqueOccurrencesTest() {
        Assert.assertTrue(this.leetCode75.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        Assert.assertFalse(this.leetCode75.uniqueOccurrences(new int[]{1,2}));
        Assert.assertTrue(this.leetCode75.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    @Test
    public void closeStringsTest() {
        Assert.assertTrue(this.leetCode75.closeStrings("abc", "bca"));
        Assert.assertFalse(this.leetCode75.closeStrings("a", "aa"));
        Assert.assertTrue(this.leetCode75.closeStrings("cabbba", "abbccc"));
        Assert.assertFalse(this.leetCode75.closeStrings("mkmczky", "cckcmmy"));
        Assert.assertFalse(this.leetCode75.closeStrings("uau", "ssx"));
    }

    @Test
    public void equalPairsTest() {
        Assert.assertEquals(1, this.leetCode75.equalPairs(new int[][]{  {3,2,1},
                                                                                {1,7,6},
                                                                                {2,7,7} }));

        Assert.assertEquals(3, this.leetCode75.equalPairs(new int[][]{  {3,1,2,2},
                                                                                {1,4,4,5},
                                                                                {2,4,2,2},
                                                                                {2,4,2,2} }));
    }





    @Test
    public void tribonacciTest() {
        Assert.assertEquals(1389537, this.leetCode75.tribonacci(25));
        Assert.assertEquals(4, this.leetCode75.tribonacci(4));
    }

}
