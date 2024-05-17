package com.shortthirdman.leetcode.quickstart;

/**
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 *
 * @author shortthirdman
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        int count = 1;


        for (int i = 1, j = 0; i < nums.length; j = i, i++) {
            if (nums[j] < nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                    i++;
                }
            } else if (nums[j] > nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                    i++;
                }
            }
        }

        return count;
    }
}
