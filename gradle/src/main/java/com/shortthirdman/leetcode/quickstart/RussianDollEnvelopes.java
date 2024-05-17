package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 * @author shortthirdman
 * @implNote We can sort the envelopes by height in ascending order and width in descending order. Then look at the width and find the longest increasing subsequence.
 * @apiNote Time complexity is O(n*log(n)) and we need O(n) of space for the list.
 * @version 1.0.0
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Comparator<int[]> c = Comparator.comparing((int[] arr) -> arr[0])
                .thenComparing((int[] arr) -> arr[1], Comparator.reverseOrder());
        Arrays.sort(envelopes, c);

        List<Integer> list = new ArrayList<>();

        for (int[] arr : envelopes) {
            int target = arr[1];

            if (list.isEmpty() || target > list.get(list.size() - 1)) {
                list.add(target);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int m = i + (j - i) / 2;
                    if (list.get(m) >= target) {
                        j = m;
                    } else {
                        i = m + 1;
                    }
                }

                list.set(j, target);
            }
        }

        return list.size();
    }
    
    public int findMaxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // sort by ascending width, and sort by descending height if the width are the same
        Arrays.sort(envelopes, new Comparator<int[]>() 
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? 
                    b[1] - a[1] : a[0] - b[0];
            }
        });
        // find LIS on the height array
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }
    
    private int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // playing card to process
            int poker = nums[i];
            int left = 0, right = piles;
            // position to insert for binary search
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // put this playing cart on top of the pile
            top[left] = poker;
        }
        // the number of cards is the LIS length
        return piles;
    }
}
