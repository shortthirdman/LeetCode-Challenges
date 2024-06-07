package com.shortthirdman.leetcode.quickstart;

import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean isPangram(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Sentence to be checked is null");
        }

        Set<Character> charSet = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            if (Character.isLowerCase(c)) {
                charSet.add(c);
            } else {
                charSet.add(Character.toLowerCase(c));
            }
        }

        return charSet.size() == 26;
    }
}
