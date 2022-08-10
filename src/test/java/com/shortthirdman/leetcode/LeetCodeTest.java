package com.shortthirdman.leetcode;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for LeetCode
 */
public class LeetCodeTest {

    @Test
    public void kthSmallestElementMatrix() {
        int[][] inputMatrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int result = 13;

        KthSmallestElementMatrix ref = new KthSmallestElementMatrix();

        assertThat(ref.kthSmallest(inputMatrix, k)).isEqualTo(result);
    }
}
