package com.shortthirdman.leetcode.quickstart;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsGenerator {

    public String reverseWords(String srcText) {
        if (srcText == null || srcText.isEmpty()) {
            throw new UnsupportedOperationException("Input source text can not be blank or null");
        }

        String reversedText = Arrays.stream(srcText.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));

        String resultText = Arrays.stream(reversedText.split(" "))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));

        return resultText;
    }
}
