package com.shortthirdman.leetcode.quickstart;

import java.util.stream.Stream;

/**
 * Find longest sequence of zeros in binary representation of an integer.
 * <br/><br/>
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros
 * that is surrounded by ones at both ends in the binary representation of N.
 * 
 * @author shortthirdman
 * @version 1.0.0
 * 
 */
public class BinaryGap {
	
	public int findLongestSequence(int N) {
        if (N == 1) {
            return 0;
        }

        // Convert to binary string and trim trailing zeros
        String binaryString = Integer.toBinaryString(N).replaceAll("0+$", "");

        // Find the longest gap length using streams
        return Stream.of(binaryString.split("1+"))
                    .filter(gap -> !gap.isEmpty())
                    .mapToInt(String::length)
                    .max()
                    .orElse(0);
    }
}
