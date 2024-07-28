package com.chrisparsons.leetcode75;

import com.chrisparsons.leetcode75.helpers.ListNode;
import com.chrisparsons.leetcode75.helpers.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class LeetCode75 {

    /**
     *
     * ########################################################################################
     * #################################    ARRAY / STRING    #################################
     * ########################################################################################
     *
     */

    /**
     *
     * 1768. Merge Strings Alternately
     *
     * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
     * If a string is longer than the other, append the additional letters onto the end of the merged string.
     *
     * Return the merged string.
     *
     *
     * Example 1:
     *
     * Input: word1 = "abc", word2 = "pqr"
     * Output: "apbqcr"
     * Explanation: The merged string will be merged as so:
     * word1:  a   b   c
     * word2:    p   q   r
     * merged: a p b q c r
     */

    public String mergeStringsAlternatively(String word1, String word2) {

        char[] word1chars = word1.toCharArray();
        char[] word2chars = word2.toCharArray();

        int word1ind = 0;
        int word2ind = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while(word1ind < word1.length() && word2ind < word2.length()) {

            if(word1ind == word2ind) {
                stringBuilder.append(word1chars[word1ind]);
                word1ind++;
            }

            else if(word2ind < word1ind) {
                stringBuilder.append(word2chars[word2ind]);
                word2ind++;
            }
        }

        if(word1ind == word1.length()) {
            stringBuilder.append(word2.substring(word2ind));
        }

        if(word2ind == word2.length()) {
            stringBuilder.append(word1.substring(word1ind));
        }

        return stringBuilder.toString();

    }


    /**
     * 1071. Greatest Common Divisor of Strings
     *
     * For two strings s and t, we say "t divides s" if and only if
     * s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     * Given two strings str1 and str2, return the largest string x such that x divides
     * both str1 and str2.
     *
     * Example 1:
     *
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     *
     * Example 2:
     *
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     *
     * Example 3:
     *
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     */
    public String gcdOfStrings(String str1, String str2) {
        String a = str1 + str2;
        String b = str2 + str1;
        if(!a.equals(b)) {
            return "";
        }

        if(str1.length() % str2.length() > 0) {
            int div = gcd(str1.length(), str2.length());
            str1 = str1.substring(0, div);
        }

        return str1.length() > str2.length() ? str2 : str1;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }



    public String gcdOfStrings2(String str1, String str2) {
        List<String> strLis = new ArrayList<>();

        for( char character : str2.toCharArray()) {
            if(strLis.isEmpty()) {
                strLis.add(String.valueOf(character));
            }
            else if(!String.valueOf(character).equals(strLis.get(0))) {
                strLis.add(String.valueOf(character));
            }
            else {
                break;
            }
        }

        for( char character : str1.toCharArray()) {
            if(!strLis.contains(String.valueOf(character))) {
                return "";
            }
        }

        return String.join("", strLis);

    }

    public String gcdOfStrings1(String str1, String str2) {
        String smallestword = str1.length() > str2.length() ? str2 : str1;
        String largestword = str1.length() > str2.length() ? str1 : str2;
        StringBuilder builder = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        for( char character : smallestword.toCharArray()) {
            if(!set.contains(String.valueOf(character))) {
                builder.append(character);
                set.add(String.valueOf(character));
            }
            else {
                break;
            }
        }

        return largestword.contains(builder.toString()) ? builder.toString() : "";

    }

    /**
     *
     * 1431. Kids With the Greatest Number of Candies
     *
     * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
     * and an integer extraCandies, denoting the number of extra candies that you have.
     *
     * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest
     * number of candies among all the kids, or false otherwise.
     *
     * Note that multiple kids can have the greatest number of candies.
     *
     *
     * Example 1:
     *
     * Input: candies = [2,3,5,1,3], extraCandies = 3
     * Output: [true,true,true,false,true]
     * Explanation: If you give all extraCandies to:
     * - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
     * - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     * - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
     * - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
     * - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     *
     * Example 2:
     *
     * Input: candies = [4,2,1,1,2], extraCandies = 1
     * Output: [true,false,false,false,false]
     * Explanation: There is only 1 extra candy.
     * Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
     */

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = 0;
        List<Boolean> returnValues = new ArrayList<>();

        for(int i=0; i< candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        for(int candy : candies) {
            returnValues.add(candy + extraCandies >= maxCandies);
        }

        return returnValues;
    }


    /**
     *
     * 605. Can Place Flowers
     *
     * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
     *
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: true
     *
     * Example 2:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: false
     *
     */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i=0;
        while(n > 0 && i < flowerbed.length) {
            if(flowerbed[i]==0) {
                if(flowerbed.length ==1) {
                    return true;
                }
                // Edge left
                if(i==0) {
                    if(flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                // Edge right
                else if(i==flowerbed.length - 1) {
                    if(flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else {
                    if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
            i++;
        }

        return n==0;
    }

    /**
     *
     * 345. Reverse Vowels of a String
     *
     * Given a string s, reverse only all the vowels in the string and return it.
     *
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "hello"
     * Output: "holle"
     *
     * Example 2:
     *
     * Input: s = "leetcode"
     * Output: "leotcede"
     *
     *
     */

    public String reverseVowels(String s) {

        int l = 0;
        int r = s.length() - 1;

        char[] charStr = s.toCharArray();

        List<String> vowels = List.of("a","A","e","E","i","I","o","O","u","U");

        while(l < r) {
            if(vowels.contains(String.valueOf(charStr[l])) && vowels.contains(String.valueOf(charStr[r]))) {
                var tmp = charStr[r];
                charStr[r] = charStr[l];
                charStr[l] = tmp;
                l++;
                r--;
            }
            else if(!vowels.contains(String.valueOf(charStr[l])) && vowels.contains(String.valueOf(charStr[r]))) {
                l++;
            }
            else {
                r--;
            }
        }
        return String.valueOf(charStr);

    }

    public String reverseVowels2(String s) {

        int l = 0;
        int r = s.length() - 1;

        List<String> vowelList = List.of("a", "A", "e", "E", "i", "I", "o", "O", "u", "U");

        char[] strArr = s.toCharArray();

        while( r > l ) {

            if(vowelList.contains(String.valueOf(strArr[l]))) {

                while( r > l ) {

                    if(vowelList.contains(String.valueOf(strArr[r]))) {

                        var tmp = strArr[r];
                        strArr[r] = strArr[l];
                        strArr[l] = tmp;
                        r--;
                        break;
                    }

                    r--;
                }
            }

            l++;

        }

        return String.valueOf(strArr);

    }

    /**
     *
     * 151. Reverse Words in a String
     *
     * Given an input string s, reverse the order of the words.
     *
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     *
     * Return a string of the words in reverse order concatenated by a single space.
     *
     * Note that s may contain leading or trailing spaces or multiple spaces between two words.
     * The returned string should only have a single space separating the words. Do not include any extra spaces.
     */

    public String reverseWords(String s) {

        String[] splitString = s.split("\\s+");

        int l = 0;
        int r = splitString.length -1;

        while(l < r) {
            var tmp = splitString[l];
            splitString[l] = splitString[r];
            splitString[r] = tmp;
            l++;
            r--;
        }

        return String.join(" ", splitString).strip();
    }

    /**
     *
     * 238. Product of Array Except Self
     *
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Example 2:
     *
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     *
     */

    public int[] productExceptSelf(int[] nums) {

        int[] resultsArray = new int[nums.length];

        int prefix = 1;
        for(int i=0; i < nums.length; i++) {
            resultsArray[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1; i>=0; i--) {
            resultsArray[i] *= postfix;
            postfix *= nums[i];
        }

        return resultsArray;

    }


    /**
     *
     * 334. Increasing Triplet Subsequence
     *
     * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
     * If no such indices exists, return false.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,5]
     * Output: true
     * Explanation: Any triplet where i < j < k is valid.
     *
     * Example 2:
     *
     * Input: nums = [5,4,3,2,1]
     * Output: false
     * Explanation: No triplet exists.
     *
     * Example 3:
     *
     * Input: nums = [2,1,5,0,4,6]
     * Output: true
     * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
     *
     *
     */

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num <= min) {

                min = num;

            }
            else if (num <= secMin) {

                secMin = num;

            }
            else if (num > secMin) {

                return true;

            }
        }
        return false;
    }

    public boolean increasingTripletMemoryEfficient(int[] nums) { // Memory efficient, Time inefficient.

        int i = 1;

        List<Integer> foundList1 = new ArrayList<>();
        List<Integer> foundList2 = new ArrayList<>();
        foundList1.add(nums[0]);
        while(i < nums.length) {

            for(Integer foundItem : foundList2) {
                if(nums[i] > foundItem) {
                    return true;
                }
            }

            for(Integer foundItem : foundList1) {
                if(nums[i] > foundItem) {
                    if(!foundList2.contains(nums[i])) {
                        foundList2.add(nums[i]);
                    }
                }
            }

            if(!foundList1.contains(nums[i])) {
                foundList1.add(nums[i]);
            }

            i++;

        }

        return false;

    }

    public boolean increasingTriplet2(int[] nums) { // Sequential ONLY.


        int i = 1;
        int found = 1;
        int foundNumber = nums[0];

        while(i < nums.length) {

            if(nums[i] > foundNumber) {

                found++;

            }
            else {

                found = 1;

            }

            if(found == 3) {
                return true;
            }

            foundNumber = nums[i];
            i++;

        }

        return false;

    }

    /**
     *
     * 443. String Compression
     *
     * Given an array of characters chars, compress it using the following algorithm:
     *
     * Begin with an empty string s. For each group of consecutive repeating characters in chars:
     *
     *     If the group's length is 1, append the character to s.
     *     Otherwise, append the character followed by the group's length.
     *
     * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
     * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
     *
     * After you are done modifying the input array, return the new length of the array.
     *
     * You must write an algorithm that uses only constant extra space.
     *
     * Example 1:
     *
     * Input: chars = ["a","a","b","b","c","c","c"]
     * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
     *
     * Example 2:
     *
     * Input: chars = ["a"]
     * Output: Return 1, and the first character of the input array should be: ["a"]
     * Explanation: The only group is "a", which remains uncompressed since it's a single character.
     *
     * Example 3:
     *
     * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
     *
     */

    public int compress(char[] chars) {

        char prevChar = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        // for each character
        for(int i=0; i< chars.length; i++) {

            if(prevChar == 0) {
                prevChar = chars[i];
            }

            // if count > 1, numberBool is true
            if(chars[i] == (prevChar)) {
                count++;
            }
            else {
                if(count > 1) {
                    stringBuilder.append(prevChar);
                    stringBuilder.append(count);
                    count = 1;
                }
                else if(count==1) {
                    stringBuilder.append(prevChar);
                }

            }

            if(i == chars.length-1) {
                if(count > 1) {
                    stringBuilder.append(chars[i]);
                    stringBuilder.append(count);
                }
                else {
                    stringBuilder.append(chars[i]);
                }

            }

            prevChar = chars[i];
        }

        for(int i=0; i<stringBuilder.toString().length(); i++) {
            chars[i] = stringBuilder.toString().charAt(i);
        }

        // return count of characters in new file.
        return stringBuilder.toString().length();
    }


    /**
     *
     * ######################################################################################
     * #################################    TWO POINTERS    #################################
     * ######################################################################################
     *
     */



    /**
     *
     * 283. Move Zeroes
     *
     *
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     *
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [0]
     */

    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for(int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {

        if(nums.length == 0 || nums.length == 1) {
            return;
        }
        for(int i=nums.length - 1; i>-1; i--) {
            if(nums[i] == 0) {
                int l = i;
                while(l < nums.length - 1) {
                    var tmp = nums[l+1];
                    nums[l+1] = nums[l];
                    nums[l] = tmp;
                    l++;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * 392. Is Subsequence
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

        int count = 0;

        if(s.isEmpty()) {
            return false;
        }

        for(int i=0; i < t.length(); i++) {

            if(t.charAt(i) == s.charAt(count)) {
                count++;
            }

            if(count == s.length()) {
                return true;
            }

        }

        return false;
    }


    /**
     *
     * 11. Container With Most Water
     *
     *
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
     * the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     *
     *
     * Example 1:
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     *
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
     * water (blue section) the container can contain is 49.
     *
     * Example 2:
     *
     * Input: height = [1,1]
     * Output: 1
     *
     *
     */

    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;

        int maxSum = 0;

        while(l < r) {
            maxSum = Math.max(maxSum, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return maxSum;
    }


    /**
     *
     * 1679. Max Number of K-Sum Pairs
     *
     *
     * You are given an integer array nums and an integer k.
     *
     * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
     *
     * Return the maximum number of operations you can perform on the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4], k = 5
     * Output: 2
     * Explanation: Starting with nums = [1,2,3,4]:
     * - Remove numbers 1 and 4, then nums = [2,3]
     * - Remove numbers 2 and 3, then nums = []
     * There are no more pairs that sum up to 5, hence a total of 2 operations.
     *
     * Example 2:
     *
     * Input: nums = [3,1,3,4,3], k = 6
     * Output: 1
     * Explanation: Starting with nums = [3,1,3,4,3]:
     * - Remove the first two 3's, then nums = [1,4,3]
     * There are no more pairs that sum up to 6, hence a total of 1 operation.
     */

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int count = 0;

        int l = 0, r = nums.length -1;

        while(l < r) {
            if(k - nums[r] < nums[l] ) {
                r--;
            }
            else if(k - nums[r] > nums[l]) {
                l++;
            }
            else {
                count++;
                l++;
                r--;
            }
        }

        return  count;
    }


    /**
     *
     * ########################################################################################
     * #################################    SLIDING WINDOW    #################################
     * ########################################################################################
     *
     */

    /**
     *
     * 643. Maximum Average Subarray I
     *
     * You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     *
     * Example 2:
     *
     * Input: nums = [5], k = 1
     * Output: 5.00000
     *
     */

    public double findMaxAverage(int[] nums, int k) {
        int window = 0;
        for(int j = 0; j < k; j++) {

            window = window + nums[j];

        }

        int maxSum= window;
        int index = 1;

        for(int i=k; i<nums.length; i++) {
            window = window - nums[index-1] + nums [i];
            maxSum = Math.max(maxSum, window);
            index++;

        }

        return (double) maxSum / k;
    }

    /**
     *
     * 1456. Maximum Number of Vowels in a Substring of Given Length
     *
     *
     * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
     *
     * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abciiidef", k = 3
     * Output: 3
     * Explanation: The substring "iii" contains 3 vowel letters.
     *
     * Example 2:
     *
     * Input: s = "aeiou", k = 2
     * Output: 2
     * Explanation: Any substring of length 2 contains 2 vowels.
     *
     * Example 3:
     *
     * Input: s = "leetcode", k = 3
     * Output: 2
     * Explanation: "lee", "eet" and "ode" contain 2 vowels.
     *
     *
     */

    public int maxVowels(String s, int k) {

        int count = 0;
        int maxSize = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxSize = Math.max(maxSize, count);

        int index = 0;
        for(int i=k; i<s.length(); i++) {
            if(isVowel(s.charAt(index))) {
                count = Math.max(0, count-1);
            }
            if(isVowel(s.charAt(i))) {
                count = Math.min(k, count+1);
            }

            maxSize = Math.max(maxSize, count);
            index++;
        }

        return maxSize;
    }

    public boolean isVowel(char ch){
        return (ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u')? true : false;
    }

    /**
     *
     * 1004. Max Consecutive Ones III
     *
     *
     * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     * Example 2:
     *
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * Output: 10
     * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     */

    public int longestOnes(int[] nums, int k) {

        int iterator = 0;
        int leftIndex = 0;
        while(iterator < nums.length){
            if(nums[iterator] == 0) {
                k--;
            }

            if(k < 0) {
                if(nums[leftIndex] == 0) {
                    /**
                     * If the start of the window was a 0, it's not anymore because we need to shift the window right, so we
                     * can give back a 0 to the pool.
                     */
                    k++;
                }

                /**
                 * We now shift the left index to the right to keep in line with the iterator, which is effectively
                 * setting the maximum found window as iterator - leftIndex.
                 *
                 * If we're not out of 0s to use, the left index just stays still which the iterator keeps increasing.
                 */
                leftIndex++;
            }
            iterator++;
        }
        return iterator-leftIndex;
    }


    /**
     *
     * 1493. Longest Subarray of 1's After Deleting One Element
     *
     *
     * Given a binary array nums, you should delete one element from it.
     *
     * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1]
     * Output: 3
     * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
     *
     * Example 2:
     *
     * Input: nums = [0,1,1,1,0,1,1,0,1]
     * Output: 5
     * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
     *
     * Example 3:
     *
     * Input: nums = [1,1,1]
     * Output: 2
     * Explanation: You must delete one element.
     *
     *
     */

    public int longestSubarray(int[] nums) {

        int k = 1;
        int iterator = 0;
        int leftIndex = 0;
        while(iterator < nums.length){
            if(nums[iterator] == 0) {
                k--;
            }

            if(k < 0) {
                if(nums[leftIndex] == 0) {
                    /**
                     * If the start of the window was a 0, it's not anymore because we need to shift the window right, so we
                     * can give back a 0 to the pool.
                     */
                    k++;
                }

                /**
                 * We now shift the left index to the right to keep in line with the iterator, which is effectively
                 * setting the maximum found window as iterator - leftIndex.
                 *
                 * If we're not out of 0s to use, the left index just stays still which the iterator keeps increasing.
                 */
                leftIndex++;
            }
            iterator++;
        }
        return iterator-leftIndex - 1;
    }


    /**
     *
     * ####################################################################################
     * #################################    PREFIX SUM    #################################
     * ####################################################################################
     *
     */

    /**
     *
     * 1732. Find the Highest Altitude
     *
     *
     * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
     *
     * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
     *
     *
     *
     * Example 1:
     *
     * Input: gain = [-5,1,5,0,-7]
     * Output: 1
     * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
     *
     * Example 2:
     *
     * Input: gain = [-4,-3,-2,-1,4,3,2]
     * Output: 0
     * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
     *
     */

    public int largestAltitude(int[] gain) {

        int total = 0;
        int maxAltitude = 0;

        for(int gainValue : gain) {

            total += gainValue;

            maxAltitude = Math.max(maxAltitude, total);

        }

        return maxAltitude;

    }

    /**
     *
     * 724. Find Pivot Index
     *
     *
     * Given an array of integers nums, calculate the pivot index of this array.
     *
     * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
     *
     * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
     *
     * Return the leftmost pivot index. If no such index exists, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,7,3,6,5,6]
     * Output: 3
     * Explanation:
     * The pivot index is 3.
     * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
     * Right sum = nums[4] + nums[5] = 5 + 6 = 11
     *
     * Example 2:
     *
     * Input: nums = [1,2,3]
     * Output: -1
     * Explanation:
     * There is no index that satisfies the conditions in the problem statement.
     *
     * Example 3:
     *
     * Input: nums = [2,1,-1]
     * Output: 0
     * Explanation:
     * The pivot index is 0.
     * Left sum = 0 (no elements to the left of index 0)
     * Right sum = nums[1] + nums[2] = 1 + -1 = 0
     *
     */

    public int pivotIndex(int[] nums) {

        int[] numsRight = new int[nums.length];
        int iterSum = 0;

        for(int i=nums.length -1; i > -1; i--) {

            numsRight[i] = i == nums.length -1 ? 0 : iterSum;
            iterSum += nums[i];

        }

        int[] numsLeft = new int[nums.length];
        iterSum = 0;

        for(int i=0; i < nums.length; i++) {

            numsLeft[i] = i == 0 ? 0 : iterSum;
            iterSum += nums[i];

        }

        for(int i=0; i < nums.length; i++) {

            if(numsLeft[i] == numsRight[i]) {
                return i;
            }

        }

        return -1;

    }


    /**
     *
     * ########################################################################################
     * #################################    HASHMAP / SET    ##################################
     * ########################################################################################
     *
     */

    /**
     *
     * 2215. Find the Difference of Two Arrays
     *
     * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
     *
     *     answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
     *     answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
     *
     * Note that the integers in the lists may be returned in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,3], nums2 = [2,4,6]
     * Output: [[1,3],[4,6]]
     * Explanation:
     * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
     * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
     *
     * Example 2:
     *
     * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
     * Output: [[3],[]]
     * Explanation:
     * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
     * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
     */

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {

            set1.add(nums1[i]);

        }

        for(int i = 0; i < nums2.length; i++) {

            set2.add(nums2[i]);

        }

        for(int i = 0; i < nums1.length; i++) {

            if(!set2.contains(nums1[i])) {

                list1.add(nums1[i]);

            }

        }

        for(int i = 0; i < nums2.length; i++) {

            if(!set1.contains(nums2[i])) {

                list2.add(nums2[i]);

            }

        }

        return List.of(list1.stream().toList(), list2.stream().toList());
    }

    public List<List<Integer>> findDifferencePoorPerformance(int[] nums1, int[] nums2) {

        HashSet<Integer> nums1list = new HashSet<>();
        HashSet<Integer> nums2list = new HashSet<>();

        for(Integer num1 : nums1) {
            boolean found = false;
            for(Integer num2 : nums2) {

                if(Objects.equals(num1, num2)) {
                    found = true;
                }
            }
            if(!found) {
                nums1list.add(num1);
            }
        }
        for(Integer num2 : nums2) {
            boolean found = false;
            for(Integer num1 : nums1) {

                if(Objects.equals(num2, num1)) {
                    found = true;
                }
            }
            if(!found) {
                nums2list.add(num2);
            }
        }

        return List.of(nums1list.stream().toList(), nums2list.stream().toList());
    }


    /**
     *
     * 1207. Unique Number of Occurrences
     *
     *
     * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or
     * false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [1,2,2,1,1,3]
     * Output: true
     * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
     *
     * Example 2:
     *
     * Input: arr = [1,2]
     * Output: false
     *
     * Example 3:
     *
     * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * Output: true
     */

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            int count = map.get(num) == null ? 0 : map.get(num) + 1;
            map.put(num, count);
        }

        Set<Integer> entries = new HashSet<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(!entries.add(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * 1657. Determine if Two Strings Are Close
     *
     *
     * Two strings are considered close if you can attain one from the other using the following operations:
     *
     *     Operation 1: Swap any two existing characters.
     *         For example, abcde -> aecdb
     *     Operation 2: Transform every occurrence of one existing character into another existing character,
     *     and do the same with the other character.
     *         For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
     *
     * You can use the operations on either string as many times as necessary.
     *
     * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
     *
     *
     * Example 1:
     *
     * Input: word1 = "abc", word2 = "bca"
     * Output: true
     * Explanation: You can attain word2 from word1 in 2 operations.
     * Apply Operation 1: "abc" -> "acb"
     * Apply Operation 1: "acb" -> "bca"
     *
     * Example 2:
     *
     * Input: word1 = "a", word2 = "aa"
     * Output: false
     * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
     *
     * Example 3:
     *
     * Input: word1 = "cabbba", word2 = "abbccc"
     * Output: true
     * Explanation: You can attain word2 from word1 in 3 operations.
     * Apply Operation 1: "cabbba" -> "caabbb"
     * Apply Operation 2: "caabbb" -> "baaccc"
     * Apply Operation 2: "baaccc" -> "abbccc"
     *
     */

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freqs1 = new int[26];
        int[] freqs2 = new int[26];

        /**
         *
         *
         *
         *
         */
        for (int i = 0; i < word1.length(); i++) {
            freqs1[word1.charAt(i) - 'a']++;
            freqs2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqs1[i] > 0 ^ freqs2[i] > 0) {
                return false;
            }
        }

        Arrays.sort(freqs1);
        Arrays.sort(freqs2);

        for (int i = 25; i >= 0; i--) {
            if (freqs1[i] == 0) {
                break;
            }

            if (freqs1[i] != freqs2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean closeStrings2(String word1, String word2) {

        if(word1.length() != word2.length()) {
            return false;
        }

        char[] word1array = word1.toCharArray();
        char[] word2array = word2.toCharArray();

        HashMap<Character, Integer> word1map = new HashMap();
        HashMap<Character, Integer> word2map = new HashMap();

        Set<Character> charSet1 = new HashSet<>();
        Set<Character> charSet2 = new HashSet<>();


        for(char charFound : word1array) {
            int count = word1map.get(charFound) == null ? 1 : word1map.get(charFound) + 1;
            word1map.put(charFound, count);
            charSet1.add(charFound);
        }

        for(char charFound : word2array) {
            int count = word2map.get(charFound) == null ? 1 : word2map.get(charFound) + 1;
            word2map.put(charFound, count);
            charSet2.add(charFound);
        }

        if(word2map.size() != word1map.size()) {
            return false;
        }

        List<Character> chars1 = charSet1.stream().sorted().toList();
        List<Character> chars2 = charSet2.stream().sorted().toList();

        // Check for unique characters
        int loop = 0;



        while(loop < chars1.size()) {
            if(!chars1.get(loop).equals(chars2.get(loop))) {
                return false;
            }
            loop++;
        }

        int[] countArray1 = new int[charSet1.size()];
        int[] countArray2 = new int[charSet2.size()];

        int index1 = 0;
        int index2 = 0;
        // Check the quantities are equal.
        for(Map.Entry <Character, Integer> mapentry : word1map.entrySet()) {
            countArray1[index1] = mapentry.getValue();
            index1++;
        }
        for(Map.Entry <Character, Integer> mapentry : word2map.entrySet()) {
            countArray2[index2] = mapentry.getValue();
            index2++;
        }

        Arrays.sort(countArray1);
        Arrays.sort(countArray2);

        for(int i=0; i < countArray1.length; i++) {
            if(countArray1[i] != countArray2[i]) {
                return false;
            }
        }


        return true;
    }


    /**
     *
     * 2352. Equal Row and Column Pairs
     *
     *
     * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj)
     * such that row ri and column cj are equal.
     *
     * A row and column pair is considered equal if they contain the same elements
     * in the same order (i.e., an equal array).
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
     * Output: 1
     * Explanation: There is 1 equal row and column pair:
     * - (Row 2, Column 1): [2,7,7]
     *
     * Example 2:
     *
     * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
     * Output: 3
     * Explanation: There are 3 equal row and column pairs:
     * - (Row 0, Column 0): [3,1,2,2]
     * - (Row 2, Column 2): [2,4,2,2]
     * - (Row 3, Column 2): [2,4,2,2]
     *
     *
     */

    public int equalPairs(int[][] grid) {

        HashMap<Integer, int[]> columns = new HashMap<>();
        int index = 0;

        // Get columns
        for(int j=0; j < grid.length; j++) {

            for(int i=0; i < grid[j].length; i++) {
                int[] foundList = columns.get(i) == null ? new int[grid.length] : columns.get(i);
                foundList[index] = grid[j][i];
                columns.put(i, foundList);
            }
            index++;
        }

        int count = 0;
        for(Map.Entry<Integer, int[]> entry : columns.entrySet()) {
            for(int j=0; j < grid.length; j++) {
                if(Arrays.equals(grid[j], entry.getValue())) {
                    count ++;
                }
            }
        }

        return count;
    }


    /**
     *
     * ########################################################################################
     * #####################################    STACK    ######################################
     * ########################################################################################
     *
     */


    /**
     *
     *
     * 2390. Removing Stars From a String
     *
     *
     * You are given a string s, which contains stars *.
     *
     * In one operation, you can:
     *
     *     Choose a star in s.
     *     Remove the closest non-star character to its left, as well as remove the star itself.
     *
     * Return the string after all stars have been removed.
     *
     * Note:
     *
     *     The input will be generated such that the operation is always possible.
     *     It can be shown that the resulting string will always be unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "leet**cod*e"
     * Output: "lecoe"
     * Explanation: Performing the removals from left to right:
     * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
     * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
     * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
     * There are no more stars, so we return "lecoe".
     *
     * Example 2:
     *
     * Input: s = "erase*****"
     * Output: ""
     * Explanation: The entire string is removed, so we return an empty string.
     *
     */

    public String removeStars(String s) {

        char[] chars = s.toCharArray();

        int index = 0;
        for(int i = 0; i < chars.length; i++) {

            if(chars[i] == '*') {
                if(i > 0) {
                    index -=2;
                }
            }
            else {
                chars[index] = chars[i];
            }
            index++;

        }

        for(int j = index; j < chars.length; j++) {
            chars[j] = ' ';
        }

        return String.valueOf(chars).replaceAll("\\s+","");
    }

    public String removeStarsBackwards(String s) {

        int count = 0;

        char[] charArray = s.toCharArray();

        for(int i = charArray.length-1; i > -1; i--) {

            if(charArray[i] == '*') {
                charArray[i] = ' ';
                count++;

            }

            else if(count > 0) {

                charArray[i] = ' ';
                count--;

            }

        }

        return String.valueOf(charArray).replaceAll("\\s+","");

    }


    /**
     *
     * 735. Asteroid Collision
     *
     *
     * We are given an array asteroids of integers representing asteroids in a row.
     *
     * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
     *
     * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
     *
     *
     *
     * Example 1:
     *
     * Input: asteroids = [5,10,-5]
     * Output: [5,10]
     * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
     *
     * Example 2:
     *
     * Input: asteroids = [8,-8]
     * Output: []
     * Explanation: The 8 and -8 collide exploding each other.
     *
     * Example 3:
     *
     * Input: asteroids = [10,2,-5]
     * Output: [10]
     * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
     *
     */

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {

            if(stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < asteroids[i] * -1) {
                    stack.pop();
                }

                if(!stack.isEmpty() && stack.peek() == asteroids[i] * -1) {
                    stack.pop();
                }
                else {
                    if(stack.isEmpty()  || stack.peek() < 0) {
                        stack.push(asteroids[i]);
                    }
                }
            }

        }
        int[] myArray = new int[stack.size()];

        int stackSize = stack.size();

        for(int i = 0; i < stackSize; i++) {

            myArray[i] = stack.get(i);

        }

        return myArray;

    }

    /**
     *
     * 394. Decode String
     *
     *
     * Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
     * repeated exactly k times. Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; there are no extra white spaces, square brackets
     * are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and
     * that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
     *
     * The test cases are generated so that the length of the output will never exceed 105.
     *
     * Example 1:
     *
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     *
     * Example 2:
     *
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     *
     * Example 3:
     *
     * Input: s = "2[abc]3[cd]ef"
     * Output: "abcabccdcdcdef"
     *
     *
     */

    public String decodeString(String s) {

        //TODO


        return s;
    }

    /**
     *
     * ###############################################################################
     * #################################    QUEUE    #################################
     * ###############################################################################
     *
     */

    /**
     *
     * 649. Dota2 Senate
     *
     *
     * In the world of Dota2, there are two parties: the Radiant and the Dire.
     *
     * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the
     * Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of
     * the two rights:
     *
     *     Ban one senator's right: A senator can make another senator lose all his rights in this and all the following
     *     rounds.
     *     Announce the victory: If this senator found the senators who still have rights to vote are all from the same
     *     party, he can announce the victory and decide on the change in the game.
     *
     * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant
     * party and the Dire party. Then if there are n senators, the size of the given string will be n.
     *
     * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will
     * last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
     *
     * Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will
     * finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
     *
     *
     * Example 1:
     *
     * Input: senate = "RD"
     * Output: "Radiant"
     * Explanation:
     * The first senator comes from Radiant and he can just ban the next senator's right in round 1.
     * And the second senator can't exercise any rights anymore since his right has been banned.
     * And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
     *
     * Example 2:
     *
     * Input: senate = "RDD"
     * Output: "Dire"
     * Explanation:
     * The first senator comes from Radiant and he can just ban the next senator's right in round 1.
     * And the second senator can't exercise any rights anymore since his right has been banned.
     * And the third senator comes from Dire and he can ban the first senator's right in round 1.
     * And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
     *
     *
     */

    public String predictPartyVictory(String senate) {

        char[] senateArray = senate.toCharArray();

        Queue<Integer> r_stack = new ArrayDeque<>();
        Queue<Integer> d_stack = new ArrayDeque<>();

        for(int i = 0; i < senateArray.length; i++) {

            if(senateArray[i] == 'R') {
                r_stack.add(i);
            }
            else {
                d_stack.add(i);
            }
        }

        while(r_stack.size() > 0 && d_stack.size() > 0) {
            int r_stack_item = r_stack.remove();
            int d_stack_item = d_stack.remove();
            if(r_stack_item > d_stack_item) {
                d_stack.add(d_stack_item + senateArray.length);
            }
            else {
                r_stack.add(r_stack_item + senateArray.length);
            }
        }

        return r_stack.size() > d_stack.size() ? "RADIANT" : "DIRE";
    }

    public String predictPartyVictory2(String senate) {

        char[] senateArray = senate.toCharArray();

        int radiantCount = 0;
        int direCount = 0;

        // if left is different to right, remove right.
        // if right is different to left, remove left.

        for(int i = 0; i < senateArray.length; i++) {

            if(i==0) {
                if(senateArray[i] == 'R') {
                    radiantCount++;
                }
                else {
                    direCount++;
                }
            }
            else if(senateArray[i] != senateArray[i-1]) {
                radiantCount++;
                direCount = Math.max(0, direCount-1);
            }
            else {
                direCount++;
                radiantCount = Math.max(0, radiantCount-1);
            }
        }

        return direCount > radiantCount ? "Dire" : "Radiant";

    }

    /**
     *
     * #####################################################################################
     * #################################    LINKED LIST    #################################
     * #####################################################################################
     *
     */

    /**
     *
     *
     * 2095. Delete the Middle Node of a Linked List
     *
     * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
     *
     * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
     *
     *     For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
     *
     *
     * Example 1:
     *
     * Input: head = [1,3,4,7,1,2,6]
     * Output: [1,3,4,1,2,6]
     * Explanation:
     * The above figure represents the given linked list. The indices of the nodes are written below.
     * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
     * We return the new list after removing this node.
     *
     * Example 2:
     *
     * Input: head = [1,2,3,4]
     * Output: [1,2,4]
     * Explanation:
     * The above figure represents the given linked list.
     * For n = 4, node 2 with value 3 is the middle node, which is marked in red.
     *
     * Example 3:
     *
     * Input: head = [2,1]
     * Output: [2]
     * Explanation:
     * The above figure represents the given linked list.
     * For n = 2, node 1 with value 1 is the middle node, which is marked in red.
     * Node 0 with value 2 is the only node remaining after removing node 1.
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the list is in the range [1, 105].
     *     1 <= Node.val <= 105
     *
     *
     */

    public ListNode deleteMiddle(ListNode head) {

        if(head.next == null) {
            return null;
        }

        ListNode slowCount = head;
        ListNode fastCount = head;

        boolean notMiddle = true;

        while(notMiddle) {

            fastCount = fastCount.next.next;
            if(fastCount == null || fastCount.next == null) {
                slowCount.next = slowCount.next.next;
                notMiddle = false;
            }
            else {
                slowCount = slowCount.next;
            }

        }

        return head;
    }

    /**
     *
     * 328. Odd Even Linked List
     *
     *
     * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices,
     * and return the reordered list.
     *
     * The first node is considered odd, and the second node is even, and so on.
     *
     * Note that the relative order inside both the even and odd groups should remain as it was in the input.
     *
     * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: head = [1,2,3,4,5]
     * Output: [1,3,5,2,4]
     *
     * Example 2:
     *
     * Input: head = [2,1,3,5,6,4,7]
     * Output: [2,3,6,7,1,5,4]
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the linked list is in the range [0, 104].
     *     -106 <= Node.val <= 106
     *
     *
     *
     */

    public ListNode oddEvenList(ListNode head) {

        if(head==null) {

            return head;

        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even!=null && even.next!=null) {

            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;

        }

        odd.next = evenHead;

        return head;
    }



    /**
     *
     * 206. Reverse Linked List
     *
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     *
     *
     * Example 1:
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
     * Example 2:
     *
     * Input: head = [1,2]
     * Output: [2,1]
     *
     * Example 3:
     *
     * Input: head = []
     * Output: []
     */

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     *
     * 2130. Maximum Twin Sum of a Linked List
     *
     *
     * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
     *
     * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
     *
     * The twin sum is defined as the sum of a node and its twin.
     *
     * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
     *
     *
     *
     * Example 1:
     *
     * Input: head = [5,4,2,1]
     * Output: 6
     * Explanation:
     * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
     * There are no other nodes with twins in the linked list.
     * Thus, the maximum twin sum of the linked list is 6.
     *
     * Example 2:
     *
     * Input: head = [4,2,2,3]
     * Output: 7
     * Explanation:
     * The nodes with twins present in this linked list are:
     * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
     * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
     * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
     *
     * Example 3:
     *
     * Input: head = [1,100000]
     * Output: 100001
     * Explanation:
     * There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the list is an even integer in the range [2, 105].
     *     1 <= Node.val <= 105
     */

    public int pairSum(ListNode head) {

        // Find the middle and set the nexts to the previous values

        int result = 0;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode current = head;

        while(fast !=null) {
            fast = fast.next.next;
            current = slow;
            slow = slow.next;
            current.next = prev;
            prev = current;
        }

        while(slow!=null) {
            result = Math.max(result, prev.val + slow.val);
            slow = slow.next;
            prev = prev.next;

        }

        return result;

    }


    /**
     *
     * ###########################################################################################
     * #################################    BINARY TREE / DFS    #################################
     * ###########################################################################################
     *
     */


    /**
     *
     * 104. Maximum Depth of Binary Tree
     *
     *
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     *
     * Example 2:
     *
     * Input: root = [1,null,2]
     * Output: 2
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the tree is in the range [0, 104].
     *     -100 <= Node.val <= 100
     *
     *
     */


    // Recursive DFS
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }


    // Iterative DFS
    public int maxDepthIterDFS(TreeNode root) {

        if(root == null) {
            return 0;
        }

        Stack<Map<TreeNode, Integer>> stack = new Stack<Map<TreeNode, Integer>>() {{
            push(Map.of(root, 1));
        }};

        while(stack != null) {

            Map<TreeNode, Integer> nodeMap = stack.pop();


        }


        return 0; //TODO


    }


    // Iterative BFS
    public int maxDepthBFS(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            for(TreeNode node : queue) {

                TreeNode queuedNode = queue.remove();
                if(queuedNode.left != null) {
                    queue.offer(queuedNode.left);
                }
                if(queuedNode.right != null) {
                    queue.offer(queuedNode.right);
                }

            }

            depth++;
        }

        return depth;
    }


    /**
     *
     * 872. Leaf-Similar Trees
     *
     *
     * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
     *
     * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
     *
     * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
     *
     * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     *
     *
     *
     * Example 1:
     *
     * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * Output: true
     *
     * Example 2:
     *
     * Input: root1 = [1,2,3], root2 = [1,3,2]
     * Output: false
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in each tree will be in the range [1, 200].
     *     Both of the given trees will have values in the range [0, 200].
     *
     */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> root1Leaves = getTreeLeaves(root1);
        List<Integer> root2Leaves = getTreeLeaves(root2);

        return root1Leaves.equals(root2Leaves);

    }

    private List<Integer> getTreeLeaves(TreeNode root) {

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        List<Integer> leavesFound = new ArrayList<>();


        while(!nodeStack.isEmpty()) {

            TreeNode node = nodeStack.pop();

            if(node.left != null) {

                nodeStack.push(node.left);

            }

            if(node.right != null) {

                nodeStack.push(node.right);

            }

            if(node.left == null && node.right == null) {

                leavesFound.add(node.val);

            }


        }

        return leavesFound;

    }


    /**
     *
     * 374. Guess Number Higher or Lower
     *
     *
     * We are playing the Guess Game. The game is as follows:
     *
     * I pick a number from 1 to n. You have to guess which number I picked.
     *
     * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
     *
     * You call a pre-defined API int guess(int num), which returns three possible results:
     *
     *     -1: Your guess is higher than the number I picked (i.e. num > pick).
     *     1: Your guess is lower than the number I picked (i.e. num < pick).
     *     0: your guess is equal to the number I picked (i.e. num == pick).
     *
     * Return the number that I picked.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 10, pick = 6
     * Output: 6
     *
     * Example 2:
     *
     * Input: n = 1, pick = 1
     * Output: 1
     *
     * Example 3:
     *
     * Input: n = 2, pick = 1
     * Output: 1
     *
     *
     *
     * Constraints:
     *
     *     1 <= n <= 231 - 1
     *     1 <= pick <= n
     *
     *
     *
     *
     */

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     */
//    int guess(int num) {
//        int target = 1;
//        if(num > target) {
//            return -1;
//        }
//        if(num < target) {
//            return 1;
//        }
//        return 0;
//    }
//
//    public int guessNumber(int n) {
//
//        int l = 0;
//        int r = n;
//        int myguess = n;
//
//        while(guess(myguess) != 0) {
//            myguess = (r + l) / 2;
//            if(guess(myguess) == -1) {
//                r=myguess;
//            }
//            else if(guess(myguess) == 1) {
//                l=myguess;
//            }
//        }
//
//        return myguess;
//
//    }


    /**
     *
     * 2300. Successful Pairs of Spells and Potions
     *
     *
     *
     * You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
     *
     * You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
     *
     * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
     *
     *
     *
     * Example 1:
     *
     * Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
     * Output: [4,0,3]
     * Explanation:
     * - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
     * - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
     * - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
     * Thus, [4,0,3] is returned.
     *
     * Example 2:
     *
     * Input: spells = [3,1,2], potions = [8,5,8], success = 16
     * Output: [2,0,2]
     * Explanation:
     * - 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
     * - 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
     * - 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
     * Thus, [2,0,2] is returned.
     *
     *
     *
     * Constraints:
     *
     *     n == spells.length
     *     m == potions.length
     *     1 <= n, m <= 105
     *     1 <= spells[i], potions[i] <= 105
     *     1 <= success <= 1010
     *
     *
     *
     */

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        //TODO

        return new int[]{};

    }



    /**
     *
     * 215. Kth Largest Element in an Array
     *
     *
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Can you solve it without sorting?
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     *
     * Example 2:
     *
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     *
     *
     *
     * Constraints:
     *
     *     1 <= k <= nums.length <= 105
     *     -104 <= nums[i] <= 104
     *
     *
     *
     */

    public int findKthLargest(int[] nums, int k) {

      PriorityQueue<Integer> queue = new PriorityQueue<>();

      for(int i = 0; i < k; i++) {

          queue.offer(nums[i]);

      }

      for(int j = k; j < nums.length; j++) {

        if(nums[j] > queue.peek()) {

            queue.remove();

            queue.offer(nums[j]);

        }

      }

      return queue.remove();

    }















    /**
     *
     * 1137. N-th Tribonacci Number
     *
     *
     * The Tribonacci sequence Tn is defined as follows:
     *
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     *
     * Given n, return the value of Tn.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 4
     * Output: 4
     * Explanation:
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     *
     * Example 2:
     *
     * Input: n = 25
     * Output: 1389537
     */

    public int tribonacci(int n) {

        return trib(n, new HashMap<>());

    }

    private int trib(int n, HashMap<Integer, Integer> memo) {
        if(memo.get(n) != null) {
            return memo.get(n);
        }

        if(n == 0) {
            return 0;
        }
        else if(n == 1 || n == 2 ) {
            return 1;
        }

        memo.put(n, trib(n-1, memo) + trib (n-2, memo) + trib (n-3, memo));
        return memo.get(n);
    }

}
