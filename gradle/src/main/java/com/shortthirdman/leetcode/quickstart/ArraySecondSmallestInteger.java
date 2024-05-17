package com.shortthirdman.leetcode.quickstart;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ArraySecondSmallestInteger {

    public int findUsingArraySort(int[] arr) {
        Arrays.sort(arr);
        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != smallest) {
                return arr[i];
            }
        }

        return -1;
    }

    public int findUsingSinglePassThrough(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            return -1;
        } else {
            return secondSmallest;
        }
    }

    /**
     * A min-heap is a priority queue where the element with the minimum value always resides at the root.
     * By default, PriorityQueue implements a min-heap, so the element with the minimum value is at the root.
     *
     * @param arr
     * @return
     */
    public int findUsingMinHeap(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            if (minHeap.isEmpty() || num != minHeap.peek()) {
                minHeap.offer(num);
            }
        }
        // all elements were the same if minHeap size is less than 2
        if (minHeap.size() < 2) {
            return -1;
        }
        minHeap.poll(); // Remove the smallest element
        return minHeap.peek(); // Second smallest element is at the root
    }
}
