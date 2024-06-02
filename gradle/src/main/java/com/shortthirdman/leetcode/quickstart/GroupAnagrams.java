package com.shortthirdman.leetcode.quickstart;

import java.util.*;

/**
 * @author shortthirdman
 * @apiNote Given an array of strings strs, you need to group all the anagrams together. You can return the answer in any order.
 */
public class GroupAnagrams {

    /**
     * <b>Group by Sorting</b><br/>
     * Time Complexity: O(n * \log k)O(n∗logk) (k is the length of largest string)<br/>
     * Space Complexity: O(n)O(n)<br/>
     *
     * @param contentArr
     * @return
     */
    public List<List<String>> categorizeBySorting(String[] contentArr) {

        if (contentArr == null) {
            throw new NullPointerException("Array input can not empty or null");
        }

        if (contentArr.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> stringAnagramsMap = new HashMap<>();
        for (String s : contentArr) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!stringAnagramsMap.containsKey(key)) {
                stringAnagramsMap.put(key, new ArrayList<>());
            }

            stringAnagramsMap.get(key).add(s);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
            resultList.add(stringAnagrams.getValue());
        }
        return resultList;
    }

    /**
     * <b>Group by Frequency</b><br/>
     * Time Complexity: O(n * k)O(n∗k) (k is the length of the largest string)<br/>
     * Space Complexity: O(n)O(n)<br/>
     *
     * @param contentArr the array content
     * @return
     */
    public List<List<String>> categorizeByFrequency(String[] contentArr) {
//        if (contentArr == null) {
//            throw new NullPointerException("Input array is null");
//        }

        // Check for empty inputs
        if (contentArr == null || contentArr.length == 0) {
            return new ArrayList<>();
        }

        boolean containsNull = Arrays.stream(contentArr).anyMatch(Objects::isNull);
        if (containsNull) {
            throw new IllegalArgumentException("Array contains null values");
        }

        Map<String, List<String>> frequencyStringsMap = new HashMap<>();
        for (String str : contentArr) {

            String frequencyString = getFrequencyString(str);

            // If the frequency string is present, add the string to the list
            if (frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            } else {
                // else create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringsMap.values());
    }

    private String getFrequencyString(String element) {
        // Frequency buckets
        int[] freq = new int[26];

        // Iterate over each character
        for (char c : element.toCharArray()) {
            freq[c - 'a']++;
        }

        // Start creating the frequency string
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }
}
