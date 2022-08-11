package com.shortthirdman.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Test cases for LeetCode
 */
public class LeetCodeTest {

    private static final Logger logger = LogManager.getLogger(LeetCodeTest.class);

    @Test
    public void kthSmallestElementMatrix() {
        logger.info("Running test case for kth smallest element in a matrix");
        int[][] inputMatrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int expected = 13;

        KthSmallestElementMatrix ref = new KthSmallestElementMatrix();
        int result = ref.kthSmallest(inputMatrix, k);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void maxChunksToSortArray() {
        logger.info("Running test case for maximum chunks to make sorted array");
        int arr[] = { 2, 0, 1 };
        int expected = 1;

        MaxChunksForSortedArray ref = new MaxChunksForSortedArray();
        int result = ref.maxChunksToSortArray(arr);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void groupAnagramsCategorizeBySorting() {
        logger.info("Running test case for group anagrams categorized by sorting");
        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ref = new GroupAnagrams();

        List<List<String>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
        expectedList.add(new ArrayList<>(Arrays.asList("tan", "nat")));
        expectedList.add(new ArrayList<>(Arrays.asList("bat")));
        List<Integer> expectedGroupLengths = new ArrayList<>();
        for (List<String> strings : expectedList) {
            expectedGroupLengths.add(strings.size());
        }

        List<List<String>> actualList = ref.categorizeBySorting(strArr);
        List<Integer> actualGroupLengths = new ArrayList<>();
        for (List<String> strings : actualList) {
            actualGroupLengths.add(strings.size());
        }

        Collections.sort(expectedGroupLengths);
        Collections.sort(actualGroupLengths);
        assertEquals(expectedGroupLengths.toString(), actualGroupLengths.toString());
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test
    public void groupAnagramsCategorizeByFrequency() {
        logger.info("Running test case for group anagrams categorized by frequency");
        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ref = new GroupAnagrams();

        List<List<String>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
        expectedList.add(new ArrayList<>(Arrays.asList("tan", "nat")));
        expectedList.add(new ArrayList<>(Arrays.asList("bat")));
        List<Integer> expectedGroupLengths = new ArrayList<>();
        for (List<String> strings : expectedList) {
            expectedGroupLengths.add(strings.size());
        }

        List<List<String>> actualList = ref.categorizeByFrequency(strArr);
        List<Integer> actualGroupLengths = new ArrayList<>();
        for (List<String> strings : actualList) {
            actualGroupLengths.add(strings.size());
        }

        Collections.sort(expectedGroupLengths);
        Collections.sort(actualGroupLengths);
        assertEquals(expectedGroupLengths.toString(), actualGroupLengths.toString());
        assertEquals(expectedList.size(), actualList.size());
    }
}
