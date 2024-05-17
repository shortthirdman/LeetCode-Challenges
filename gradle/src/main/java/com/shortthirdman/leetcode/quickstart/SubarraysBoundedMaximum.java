package com.shortthirdman.leetcode.quickstart;

/**
 * Given an array A of positive integers, and two positive integers L and R (L <= R).
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
 *
 * @apiNote Time is O(N) and space is O(1).
 * @author shortthirdman
 * @version 1.0.0
 */
public class SubarraysBoundedMaximum {

    public int subarrayBoundedMax(int[] A, int L, int R) {
        return countBelowBoundary(A, R) - countBelowBoundary(A, L - 1);
    }

    private int countBelowBoundary(int[] A, int bound) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int count = 0;
        int temp = 0;

        for (int a : A) {
            if (a <= bound) {
                temp = temp + 1;
                count += temp;
            } else {
                temp = 0;
            }
        }
        return count;
    }
}
