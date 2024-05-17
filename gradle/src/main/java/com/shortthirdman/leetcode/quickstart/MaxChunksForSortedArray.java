package com.shortthirdman.leetcode.quickstart;

import java.util.Stack;

/**
 * @author shortthirdman
 * @apiNote Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 *          After concatenating them, the result equals the sorted array. What is the most number of chunks required?
 * @implNote The key to solve this problem is using a stack to track the existing chunk. Each chunk is represented a min and max number.
 *           Each chunk is essentially an interval and the interval can not overlap.
 */
public class MaxChunksForSortedArray {

    public int maxChunksToSortArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int max = arr[i];

            while (!stack.isEmpty()) {
                int[] top = stack.peek();

                if (arr[i] < top[1]) {
                    min = Math.min(top[0], min);
                    max = Math.max(max, top[1]);
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new int[]{ min, max });
        }
        return stack.size();
    }
}
