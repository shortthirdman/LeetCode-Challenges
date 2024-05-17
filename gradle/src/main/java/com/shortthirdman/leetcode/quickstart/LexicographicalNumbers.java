package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * @author shortthirdman
 * @version 1.0.0
 */
public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }

        Collections.sort(list, (a, b) -> {
            int i = 0;
            while (i < a.length() && i < b.length()) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
                i++;
            }

            if (i >= a.length()) {
                return -1;
            }

            return 1;
        });

        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}
