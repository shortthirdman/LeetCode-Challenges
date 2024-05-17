package com.shortthirdman.leetcode.quickstart;

/**
 * A password string, pwd, consists of binary characters (0s and 1s). A cyber-security expert is trying to determine the
 * minimum number of changes required to make the password secure.
 * <br/>
 * To do so, it must be divided into substrings of non-overlapping, even length substrings. Each substring can only contain 1s or 0s,
 * not a mix. This helps to ensure that the password is strong and less vulnerable to hacking attacks.
 * <br/>
 * @author shortthirdman
 */
public class MinimumBinaryFlips {

	/**
	 * Find the minimum number of characters that must be flipped in the password string,
	 * i.e. changed from 0 to 1 or 1 to 0 to allow the string to be divided as described.
	 * 
	 * @param text the binary string
	 * @return the minimum number of flips to make the division possible 
	 */
	public Integer getMinFlips(String text) {
		int minFlips = Integer.MAX_VALUE;

        int len = text.length();

        int flipsToMakeAllZeros = flipsToMakeAllSame(text, '0');
        int flipsToMakeAllOnes = flipsToMakeAllSame(text, '1');

        minFlips = Math.min(flipsToMakeAllZeros, flipsToMakeAllOnes);

        for (int i = 2; i < len - 1; i += 2) {
            String part1 = text.substring(0, i);
            String part2 = text.substring(i);

            int flipsToZeroPart1 = flipsToMakeAllSame(part1, '0');
            int flipsToOnePart1 = flipsToMakeAllSame(part1, '1');

            int flipsToZeroPart2 = flipsToMakeAllSame(part2, '0');
            int flipsToOnePart2 = flipsToMakeAllSame(part2, '1');

            minFlips = Math.min(minFlips, Math.min(flipsToZeroPart1 + flipsToOnePart2, flipsToOnePart1 + flipsToZeroPart2));
        }

        return Integer.valueOf(minFlips);
	}
	
	
	public int flipsToMakeAllSame(String str, char targetChar) {
        int flips = 0;
        for (char c : str.toCharArray()) {
            if (c != targetChar) {
                flips++;
            }
        }
        return flips;
    }
}
