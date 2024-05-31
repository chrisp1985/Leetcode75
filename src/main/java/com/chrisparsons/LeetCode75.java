package com.chrisparsons;

import java.util.*;

public class LeetCode75 {

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
     * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
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
}
