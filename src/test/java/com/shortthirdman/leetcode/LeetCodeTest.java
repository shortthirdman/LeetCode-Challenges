package com.shortthirdman.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for LeetCode
 */
public class LeetCodeTest {

    private static final Logger logger = LogManager.getLogger(LeetCodeTest.class);

    @Test
    public void kthSmallestElementMatrix() {
        logger.info("Running test case for kth Smallest Element in a Matrix");
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
        logger.info("Running test case for Maximum chunks to make Sorted Array");
        int arr[] = { 2, 0, 1 };
        int expected = 1;

        MaxChunksForSortedArray ref = new MaxChunksForSortedArray();
        int result = ref.maxChunksToSortArray(arr);

        assertThat(result).isEqualTo(expected);
    }
}
