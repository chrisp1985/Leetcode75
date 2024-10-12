package com.chrisparsons.leetcode75;

import com.chrisparsons.leetcode75.helpers.ListNode;
import com.chrisparsons.leetcode75.helpers.TreeNode;

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

    /**
     *
     * #####################################################################################
     * #################################    LINKED LIST    #################################
     * #####################################################################################
     *
     */

    /**
     *
     * 2095. Delete the Middle Node of a Linked List
     *
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
     * 1448. Count Good Nodes in Binary Tree
     *
     *
     * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
     *
     * Return the number of good nodes in the binary tree.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [3,1,4,3,null,1,5]
     * Output: 4
     * Explanation: Nodes in blue are good.
     * Root Node (3) is always a good node.
     * Node 4 -> (3,4) is the maximum value in the path starting from the root.
     * Node 5 -> (3,4,5) is the maximum value in the path
     * Node 3 -> (3,1,3) is the maximum value in the path.
     *
     * Example 2:
     *
     * Input: root = [3,3,null,4,2]
     * Output: 3
     * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
     *
     * Example 3:
     *
     * Input: root = [1]
     * Output: 1
     * Explanation: Root is considered as good.
     *
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public int goodNodes(TreeNode root) {

        //TODO
        return 0;
    }

    /**
     * 437. Path Sum III
     *
     *
     * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
     *
     * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
     *
     *
     *
     * Example 1:
     *
     * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * Output: 3
     * Explanation: The paths that sum to 8 are shown.
     *
     * Example 2:
     *
     * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * Output: 3
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the tree is in the range [0, 1000].
     *     -109 <= Node.val <= 109
     *     -1000 <= targetSum <= 1000
     *
     */

    public int pathSum(TreeNode root, int targetSum) {

        //TODO
        return 0;
    }

    /**
     * 1372. Longest ZigZag Path in a Binary Tree
     *
     * You are given the root of a binary tree.
     *
     * A ZigZag path for a binary tree is defined as follow:
     *
     *     Choose any node in the binary tree and a direction (right or left).
     *     If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
     *     Change the direction from right to left or from left to right.
     *     Repeat the second and third steps until you can't move in the tree.
     *
     * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
     *
     * Return the longest ZigZag path contained in that tree.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
     * Output: 3
     * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
     *
     * Example 2:
     *
     * Input: root = [1,1,1,null,1,null,null,1,1,null,1]
     * Output: 4
     * Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
     *
     * Example 3:
     *
     * Input: root = [1]
     * Output: 0
     *
     */

    public int longestZigZag(TreeNode root) {

        //TODO
        return 0;

    }

    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     *
     *
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     *
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     *
     * Example 2:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     *
     * Example 3:
     *
     * Input: root = [1,2], p = 1, q = 2
     * Output: 1
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the tree is in the range [2, 105].
     *     -109 <= Node.val <= 109
     *     All Node.val are unique.
     *     p != q
     *     p and q will exist in the tree.
     *
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //TODO
        return new TreeNode();
    }

    /**
     *
     * ###########################################################################################
     * #################################    BINARY TREE / BFS    #################################
     * ###########################################################################################
     *
     */

    /**
     * 199. Binary Tree Right Side View
     *
     * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [1,2,3,null,5,null,4]
     * Output: [1,3,4]
     *
     * Example 2:
     *
     * Input: root = [1,null,3]
     * Output: [1,3]
     *
     * Example 3:
     *
     * Input: root = []
     * Output: []
     *
     *
     *
     * Constraints:
     *
     *     The number of nodes in the tree is in the range [0, 100].
     *     -100 <= Node.val <= 100
     *
     */

    public List<Integer> rightSideView(TreeNode root) {

        //TODO
        return List.of(1);
    }

    /**
     * 1161. Maximum Level Sum of a Binary Tree
     *
     * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
     *
     * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [1,7,0,7,-8,null,null]
     * Output: 2
     * Explanation:
     * Level 1 sum = 1.
     * Level 2 sum = 7 + 0 = 7.
     * Level 3 sum = 7 + -8 = -1.
     * So we return the level with the maximum sum which is level 2.
     *
     * Example 2:
     *
     * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
     * Output: 2
     *
     *
     */

    public int maxLevelSum(TreeNode root) {

        //TODO
        return 0;

    }


    /**
     *
     * ###########################################################################################
     * #################################    BINARY SEARCH TREE    ################################
     * ###########################################################################################
     *
     */

    /**
     *
     * 700. Search in a Binary Search Tree
     *
     * You are given the root of a binary search tree (BST) and an integer val.
     *
     * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [4,2,7,1,3], val = 2
     * Output: [2,1,3]
     *
     * Example 2:
     *
     * Input: root = [4,2,7,1,3], val = 5
     * Output: []
     *
     *
     *
     */

    public TreeNode searchBST(TreeNode root, int val) {

        //TODO
        return new TreeNode();
    }

    /**
     * 450. Delete Node in a BST
     *
     * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
     *
     * Basically, the deletion can be divided into two stages:
     *
     *     Search for a node to remove.
     *     If the node is found, delete the node.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [5,3,6,2,4,null,7], key = 3
     * Output: [5,4,6,2,null,null,7]
     * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
     * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
     * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
     *
     * Example 2:
     *
     * Input: root = [5,3,6,2,4,null,7], key = 0
     * Output: [5,3,6,2,4,null,7]
     * Explanation: The tree does not contain a node with value = 0.
     *
     * Example 3:
     *
     * Input: root = [], key = 0
     * Output: []
     */

    public TreeNode deleteNode(TreeNode root, int key) {

        //TODO
        return new TreeNode();

    }

    /**
     *
     * ###########################################################################################
     * #################################    GRAPHS DFS    ################################
     * ###########################################################################################
     *
     */

    /**
     * 841. Keys and Rooms
     *
     * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
     *
     * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
     *
     * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: rooms = [[1],[2],[3],[]]
     * Output: true
     * Explanation:
     * We visit room 0 and pick up key 1.
     * We then visit room 1 and pick up key 2.
     * We then visit room 2 and pick up key 3.
     * We then visit room 3.
     * Since we were able to visit every room, we return true.
     *
     * Example 2:
     *
     * Input: rooms = [[1,3],[3,0,1],[2],[0]]
     * Output: false
     * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
     *
     *
     */

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        //TODO
        return false;

    }

    /**
     * 547. Number of Provinces
     *
     * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
     *
     * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
     *
     * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
     *
     * Return the total number of provinces.
     *
     *
     *
     * Example 1:
     *
     * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * Output: 2
     *
     * Example 2:
     *
     * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * Output: 3
     *
     *
     *
     */

    public int findCircleNum(int[][] isConnected) {

        //TODO
        return 0;
    }

    /**
     * 1466. Reorder Routes to Make All Paths Lead to the City Zero
     *
     * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
     *
     * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
     *
     * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
     *
     * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
     *
     * It's guaranteed that each city can reach city 0 after reorder.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
     * Output: 3
     * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
     *
     * Example 2:
     *
     * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
     * Output: 2
     * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
     *
     * Example 3:
     *
     * Input: n = 3, connections = [[1,0],[2,0]]
     * Output: 0
     *
     */

    public int minReorder(int n, int[][] connections) {

        //TODO
        return 0;
    }

    /**
     * 399. Evaluate Division
     *
     * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
     *
     * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
     *
     * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
     *
     * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
     *
     * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
     *
     *
     *
     * Example 1:
     *
     * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * Explanation:
     * Given: a / b = 2.0, b / c = 3.0
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
     * note: x is undefined => -1.0
     *
     * Example 2:
     *
     * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * Output: [3.75000,0.40000,5.00000,0.20000]
     *
     * Example 3:
     *
     * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
     * Output: [0.50000,2.00000,-1.00000,-1.00000]
     *
     *
     */

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //TODO
        return new double[]{0.0};
    }

    /**
     *
     * ###########################################################################################
     * #################################    GRAPHS BFS    ################################
     * ###########################################################################################
     *
     */

    /**
     * 1926. Nearest Exit from Entrance in Maze
     *
     * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
     *
     * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
     *
     * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
     *
     *
     *
     * Example 1:
     *
     * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
     * Output: 1
     * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
     * Initially, you are at the entrance cell [1,2].
     * - You can reach [1,0] by moving 2 steps left.
     * - You can reach [0,2] by moving 1 step up.
     * It is impossible to reach [2,3] from the entrance.
     * Thus, the nearest exit is [0,2], which is 1 step away.
     *
     * Example 2:
     *
     * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
     * Output: 2
     * Explanation: There is 1 exit in this maze at [1,2].
     * [1,0] does not count as an exit since it is the entrance cell.
     * Initially, you are at the entrance cell [1,0].
     * - You can reach [1,2] by moving 2 steps right.
     * Thus, the nearest exit is [1,2], which is 2 steps away.
     *
     * Example 3:
     *
     * Input: maze = [[".","+"]], entrance = [0,0]
     * Output: -1
     * Explanation: There are no exits in this maze.
     */

    public int nearestExit(char[][] maze, int[] entrance) {

        //TODO
        return 0;

    }

    /**
     * 994. Rotting Oranges
     *
     * You are given an m x n grid where each cell can have one of three values:
     *
     *     0 representing an empty cell,
     *     1 representing a fresh orange, or
     *     2 representing a rotten orange.
     *
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     *
     * Example 2:
     *
     * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1
     * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
     *
     * Example 3:
     *
     * Input: grid = [[0,2]]
     * Output: 0
     * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
     */

    public int orangesRotting(int[][] grid) {

        //TODO
        return 0;
    }

    /**
     *
     * ###########################################################################################
     * #################################    HEAP/PRIORITY QUEUE    ###############################
     * ###########################################################################################
     *
     */

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
     * 2336. Smallest Number in Infinite Set
     *
     * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
     *
     * Implement the SmallestInfiniteSet class:
     *
     *     SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
     *     int popSmallest() Removes and returns the smallest integer contained in the infinite set.
     *     void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
     *
     *
     *
     * Example 1:
     *
     * Input
     * ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
     * [[], [2], [], [], [], [1], [], [], []]
     * Output
     * [null, null, 1, 2, 3, null, 1, 4, 5]
     *
     * Explanation
     * SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
     * smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
     * smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
     * smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
     * smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
     * smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
     * smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
     *                                    // is the smallest number, and remove it from the set.
     * smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
     * smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
     */


    /**
     * 2542. Maximum Subsequence Score
     *
     * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
     *
     * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
     *
     *     The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
     *     It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
     *
     * Return the maximum possible score.
     *
     * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
     * Output: 12
     * Explanation:
     * The four possible subsequence scores are:
     * - We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
     * - We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
     * - We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
     * - We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
     * Therefore, we return the max score, which is 12.
     *
     * Example 2:
     *
     * Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
     * Output: 30
     * Explanation:
     * Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
     */

    public long maxScore(int[] nums1, int[] nums2, int k) {

        //TODO
        return 0L;
    }

    /**
     *
     * 2462. Total Cost to Hire K Workers
     *
     * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
     *
     * You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
     *
     *     You will run k sessions and hire exactly one worker in each session.
     *     In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
     *         For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
     *         In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
     *     If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
     *     A worker can only be chosen once.
     *
     * Return the total cost to hire exactly k workers.
     *
     *
     *
     * Example 1:
     *
     * Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
     * Output: 11
     * Explanation: We hire 3 workers in total. The total cost is initially 0.
     * - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
     * - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
     * - In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
     * The total hiring cost is 11.
     *
     * Example 2:
     *
     * Input: costs = [1,2,4,1], k = 3, candidates = 3
     * Output: 4
     * Explanation: We hire 3 workers in total. The total cost is initially 0.
     * - In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
     * - In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
     * - In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
     * The total hiring cost is 4.
     */

    public long totalCost(int[] costs, int k, int candidates) {

        //TODO
        return 0L;
    }

    /**
     *
     * ###########################################################################################
     * #################################    BINARY SEARCH    ###############################
     * ###########################################################################################
     *
     */

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

    public int guessedNumberTarget = 1;

    int guess(int num) {
        if(num > guessedNumberTarget) {
            return -1;
        }
        if(num < guessedNumberTarget) {
            return 1;
        }
        return 0;
    }

    public int guessNumber(int n) {

        int l = 0;
        int r = n;
        int myguess = n;

        while(guess(myguess) != 0) {
            myguess = l + (r - l) / 2;
            if(guess(myguess) == -1) {
                r=myguess;
            }
            else if(guess(myguess) == 1) {
                l=myguess;
            }
        }

        return myguess;

    }

    /**
     * 2300. Successful Pairs of Spells and Potions
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
     */

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] res = new int[spells.length];

        for(int i = 0; i < spells.length; i++) {

            int l = 0;
            int r = potions.length -1;

            while (l <= r) {
                int mid = l + (r-l) /2;

                long result = (long) spells[i] * potions[mid];
                if(result >= success) {

                    r = mid -1;
                }

                else {
                    l = mid + 1;
                }
            }
            res[i] = potions.length - l;
        }

        return res;
    }

    /**
     *
     * 162. Find Peak Element
     *
     * A peak element is an element that is strictly greater than its neighbors.
     *
     * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
     *
     * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
     *
     * You must write an algorithm that runs in O(log n) time.
     */

    public int findPeakElement(int[] nums) { // O(n)

        int l = 0;
        int r = nums.length;

        if(nums.length ==1) {
            return 0;
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]) == nums[0] ? 0 : 1;
        }

        while(l < r) {
            int mid = l + (r-l) /2;

            if(mid == 0) {
                return Math.max(nums[0], nums[1]) == nums[0] ? 0 : 1;
            }

            if(mid == nums.length -1) {
                return Math.max(nums[mid], nums[mid-1]) == nums[mid] ? mid : mid-1;
            }

            if(nums[mid-1] > nums[mid]) {
                r = mid-1;
            }
            else if (nums[mid+1] > nums[mid]) {
                l = mid +1;
            }
            else {
                return mid;
            }
        }
        return l;
    }

    /**
     * 875. Koko Eating Bananas
     *
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
     *
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
     * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     *
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     *
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     *
     *
     *
     * Example 1:
     *
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     *
     * Example 2:
     *
     * Input: piles = [30,11,23,4,20], h = 5
     * Output: 30
     *
     * Example 3:
     *
     * Input: piles = [30,11,23,4,20], h = 6
     * Output: 23
     */

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int k = 0;

        int l = 1;
        int r = piles[piles.length-1];
        int res = r;

        while(l <= r) {
            long hoursNeeded = 0;
            k = l + (r-l) /2;
            for(int i = 0; i < piles.length; i++) {

                hoursNeeded += (long) Math.ceil((double) piles[i] / k);

            }
            if(hoursNeeded <= h) {
                res = Math.min(res, k);
                r = k-1;
            }
            else {
                l = k+1;
            }
        }

        return res;
    }

    /**
     *
     * ###########################################################################################
     * ###################################    BACKTRACKING    ####################################
     * ###########################################################################################
     *
     */

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

    /**
     *
     * 746. Min Cost Climbing Stairs
     *
     *
     * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
     *
     * You can either start from the step with index 0, or the step with index 1.
     *
     * Return the minimum cost to reach the top of the floor.
     *
     *
     *
     * Example 1:
     *
     * Input: cost = [10,15,20]
     * Output: 15
     * Explanation: You will start at index 1.
     * - Pay 15 and climb two steps to reach the top.
     * The total cost is 15.
     *
     * Example 2:
     *
     * Input: cost = [1,100,1,1,1,100,1,1,100,1]
     * Output: 6
     * Explanation: You will start at index 0.
     * - Pay 1 and climb two steps to reach index 2.
     * - Pay 1 and climb two steps to reach index 4.
     * - Pay 1 and climb two steps to reach index 6.
     * - Pay 1 and climb one step to reach index 7.
     * - Pay 1 and climb two steps to reach index 9.
     * - Pay 1 and climb one step to reach the top.
     * The total cost is 6.
     *
     *
     *
     */

    public int minCostClimbingStairs(int[] cost) {

        int opt1 = cost[0];
        int opt2 = cost[1];

        if(cost.length == 2) {
            return Math.min(opt1, opt2);
        }

        for(int i = 2; i < cost.length -1; i++) {

            var tmp = Math.min(opt1 + cost[i], opt2 + cost[i]);
            opt1 = opt2;
            opt2 = tmp;

        }

        return Math.min(opt1 + cost[cost.length -1], opt2);
    }

    /**
     * 198. House Robber
     *
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     *
     * Example 2:
     *
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     *
     */

    public int rob(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        for(int i = 0; i < nums.length; i++) {

            var tmp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = tmp;

        }

        return rob2;
    }

    /**
     * 790. Domino and Tromino Tiling
     *
     * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
     *
     * Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
     *
     * In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 3
     * Output: 5
     * Explanation: The five different ways are show above.
     *
     * Example 2:
     *
     * Input: n = 1
     * Output: 1
     *
     */

    public int numTilings(int n) {

        //TODO
        return 0;

    }

    /**
     *
     * ###########################################################################################
     * ##############################    DP MULTIDIMENSIONAL    ##################################
     * ###########################################################################################
     *
     */

    /**
     * 62. Unique Paths
     *
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     *
     *
     *
     * Example 1:
     *
     * Input: m = 3, n = 7
     * Output: 28
     *
     * Example 2:
     *
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     *
     *
     *
     * Constraints:
     *
     *     1 <= m, n <= 100
     */

    public int uniquePaths(int m, int n) {

        //TODO
        return 0;

    }


    /**
     * 1143. Longest Common Subsequence
     *
     * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without
     * changing the relative order of the remaining characters.
     *
     *     For example, "ace" is a subsequence of "abcde".
     *
     * A common subsequence of two strings is a subsequence that is common to both strings.
     *
     *
     *
     * Example 1:
     *
     * Input: text1 = "abcde", text2 = "ace"
     * Output: 3
     * Explanation: The longest common subsequence is "ace" and its length is 3.
     *
     * Example 2:
     *
     * Input: text1 = "abc", text2 = "abc"
     * Output: 3
     * Explanation: The longest common subsequence is "abc" and its length is 3.
     *
     * Example 3:
     *
     * Input: text1 = "abc", text2 = "def"
     * Output: 0
     * Explanation: There is no such common subsequence, so the result is 0.
     */

    public int longestCommonSubsequence(String text1, String text2) {

        int count = 0;

        String shortStr = text1.length() > text2.length() ? text2 : text1;
        String longStr = text1.length() > text2.length() ? text1 : text2;

        for(int i=0; i < longStr.length(); i++) {
            if(longStr.charAt(i) == shortStr.charAt(count)) {
                count++;
            }

            if(count == text2.length()) {
                return count;
            }
        }

        return count;

        //TODO

    }

    /**
     * 714. Best Time to Buy and Sell Stock with Transaction Fee
     *
     * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
     *
     * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
     *
     * Note:
     *
     *     You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
     *     The transaction fee is only charged once for each stock purchase and sale.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [1,3,2,8,4,9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * - Buying at prices[0] = 1
     * - Selling at prices[3] = 8
     * - Buying at prices[4] = 4
     * - Selling at prices[5] = 9
     * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     *
     * Example 2:
     *
     * Input: prices = [1,3,7,5,10,3], fee = 3
     * Output: 6
     */

    public int maxProfit(int[] prices, int fee) {

        //TODO
        return 0;

    }

    /**
     * 72. Edit Distance
     *
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     *
     * You have the following three operations permitted on a word:
     *
     *     Insert a character
     *     Delete a character
     *     Replace a character
     *
     *
     *
     * Example 1:
     *
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explanation:
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     *
     * Example 2:
     *
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     * Explanation:
     * intention -> inention (remove 't')
     * inention -> enention (replace 'i' with 'e')
     * enention -> exention (replace 'n' with 'x')
     * exention -> exection (replace 'n' with 'c')
     * exection -> execution (insert 'u')
     */

    public int minDistance(String word1, String word2) {

        //TODO
        return 0;

    }

    /**
     *
     * ###########################################################################################
     * ##############################    BIT MANIPULATION    ##################################
     * ###########################################################################################
     *
     */

    /**
     * 338. Counting Bits
     *
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: [0,1,1]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     *
     * Example 2:
     *
     * Input: n = 5
     * Output: [0,1,1,2,1,2]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */

    public int[] countBits(int n) {

        //TODO
        return new int[]{0};
    }

    /**
     * 136. Single Number
     *
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,2,1]
     * Output: 1
     *
     * Example 2:
     *
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     *
     * Example 3:
     *
     * Input: nums = [1]
     * Output: 1
     */

    public int singleNumber(int[] nums) {

        //TODO
        return 0;

    }

    /**
     * 1318. Minimum Flips to Make a OR b Equal to c
     *
     * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
     * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
     *
     *
     *
     * Example 1:
     *
     * Input: a = 2, b = 6, c = 5
     * Output: 3
     * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
     *
     * Example 2:
     *
     * Input: a = 4, b = 2, c = 7
     * Output: 1
     *
     * Example 3:
     *
     * Input: a = 1, b = 2, c = 3
     * Output: 0
     */

    public int minFlips(int a, int b, int c) {

        //TODO
        return 0;

    }

    /**
     *
     * ###########################################################################################
     * ##############################    TRIE    ##################################
     * ###########################################################################################
     *
     */

    /**
     * 208. Implement Trie (Prefix Tree)
     *
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
     *
     * Implement the Trie class:
     *
     *     Trie() Initializes the trie object.
     *     void insert(String word) Inserts the string word into the trie.
     *     boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
     *     boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * Output
     * [null, null, true, false, true, null, true]
     *
     * Explanation
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // return True
     * trie.search("app");     // return False
     * trie.startsWith("app"); // return True
     * trie.insert("app");
     * trie.search("app");     // return True
     */


    /**
     * 1268. Search Suggestions System
     *
     * You are given an array of strings products and a string searchWord.
     *
     * Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
     *
     * Return a list of lists of the suggested products after each character of searchWord is typed.
     *
     *
     *
     * Example 1:
     *
     * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
     * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
     * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
     * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
     * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
     *
     * Example 2:
     *
     * Input: products = ["havana"], searchWord = "havana"
     * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
     * Explanation: The only word "havana" will be always suggested while typing the search word.
     */

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        //TODO
        return List.of(List.of(""));
    }

    /**
     *
     * ###########################################################################################
     * ##############################    INTERVALS    ##################################
     * ###########################################################################################
     *
     */

    /**
     *
     * 435. Non-overlapping Intervals
     *
     * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
     * you need to remove to make the rest of the intervals non-overlapping.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     *
     * Example 2:
     *
     * Input: intervals = [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
     *
     * Example 3:
     *
     * Input: intervals = [[1,2],[2,3]]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     *
     *
     */

    public int eraseOverlapIntervals2(int[][] intervals) {

        //TODO

        List<int[]> listOfIntervalsFound = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {

            boolean found = false;

            for(int j = 0; j < listOfIntervalsFound.size(); j++) {

                if((intervals[i][0] > listOfIntervalsFound.get(j)[0] && intervals[i][1] < listOfIntervalsFound.get(j)[1]) // over the middle
                        || (intervals[i][0] < listOfIntervalsFound.get(j)[0] && intervals[i][1] > listOfIntervalsFound.get(j)[0]) // over the left boundary
                        || (intervals[i][0] < listOfIntervalsFound.get(j)[1] && intervals[i][1] > listOfIntervalsFound.get(j)[1]) // over the right boundary
                        || (intervals[i][0] < listOfIntervalsFound.get(j)[0] && intervals[i][1] > listOfIntervalsFound.get(j)[1]) // enveloping
                || (intervals[i][0] == listOfIntervalsFound.get(j)[0] && intervals[i][1] == listOfIntervalsFound.get(j)[1])) { // the same
                    found = true;
                    break;
                }
            }

            if(!found) {
                listOfIntervalsFound.add(intervals[i]);
            }

        }

        return intervals.length - listOfIntervalsFound.size();
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        /**
         * NOTE: Needs to be 1 so the smaller intervals take priority over one that's massive and engulfs the others.
         *
         * If it's a[0], it will mean that [1,100], [2,12], [12, 15] would be 1 valid interval rather than 2:
         *  order: [1,100], [2,12], [12, 15]
         * If it's a[1], it will mean that [1,100], [2,12], [12, 15] would be 2 valid intervals rather than 1.
         *  order: [2,12], [12, 15], [1,100]
         *
          */

        int prevInterval = 0;
        List<int[]> overlappingIntervals = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prevInterval][1]) {
                prevInterval = i;
                overlappingIntervals.add(intervals[i]);
            }
        }
        return intervals.length - (overlappingIntervals.size() + 1); // Because we start at int=1
    }

    /**
     *
     * 452. Minimum Number of Arrows to Burst Balloons
     *
     *
     * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
     *
     * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
     *
     * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
     *
     *
     *
     * Example 1:
     *
     * Input: points = [[10,16],[2,8],[1,6],[7,12]]
     * Output: 2
     * Explanation: The balloons can be burst by 2 arrows:
     * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
     * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
     *
     * Example 2:
     *
     * Input: points = [[1,2],[3,4],[5,6],[7,8]]
     * Output: 4
     * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
     *
     * Example 3:
     *
     * Input: points = [[1,2],[2,3],[3,4],[4,5]]
     * Output: 2
     * Explanation: The balloons can be burst by 2 arrows:
     * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
     * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
     */

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int prev = points[0][1];
        int arrowCount = points.length;

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] <= prev) {
                arrowCount--;
                prev = Math.min(points[i][1], prev);
            } else {
                prev = points[i][1];
            }

        }

        return arrowCount;
    }

    /**
     *
     * ###########################################################################################
     * ##############################    MONOTONIC STACK    ##################################
     * ###########################################################################################
     *
     */

    /**
     * 739. Daily Temperatures
     *
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
     *
     *
     *
     * Example 1:
     *
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     *
     * Example 2:
     *
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     *
     * Example 3:
     *
     * Input: temperatures = [30,60,90]
     * Output: [1,1,0]
     */

    public int[] dailyTemperatures(int[] temperatures) {

        //TODO
        return new int[]{0};
    }

    /**
     * 901. Online Stock Span
     *
     * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
     *
     * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
     *
     *     For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
     *     Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
     *
     * Implement the StockSpanner class:
     *
     *     StockSpanner() Initializes the object of the class.
     *     int next(int price) Returns the span of the stock's price given that today's price is price.
     *
     *
     *
     * Example 1:
     *
     * Input
     * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
     * [[], [100], [80], [60], [70], [60], [75], [85]]
     * Output
     * [null, 1, 1, 1, 2, 1, 4, 6]
     *
     * Explanation
     * StockSpanner stockSpanner = new StockSpanner();
     * stockSpanner.next(100); // return 1
     * stockSpanner.next(80);  // return 1
     * stockSpanner.next(60);  // return 1
     * stockSpanner.next(70);  // return 2
     * stockSpanner.next(60);  // return 1
     * stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
     * stockSpanner.next(85);  // return 6
     */

    // Needs new class.

}
