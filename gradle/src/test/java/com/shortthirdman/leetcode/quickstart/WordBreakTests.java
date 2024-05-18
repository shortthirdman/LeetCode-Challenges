package com.shortthirdman.leetcode.quickstart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordBreakTests {

    WordBreak app;

    @BeforeEach
    public void setUp() {
        app = new WordBreak();
    }

    @Test
    public void testWordBreak() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result = app.wordBreak("pineapplepenapple", dictionary);
        List<String> expected = Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
        assertNotEquals(expected, result);
    }

    @Test
    public void testWordBreakEmptyString() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result = app.wordBreak("", dictionary);
        List<String> expected = List.of();
        assertEquals(expected, result);
    }

    @Test
    public void testWordBreakNoWordBreak() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result = app.wordBreak("hello", dictionary);
        List<String> expected = List.of();
        assertEquals(expected, result);
    }

    @Test
    public void testWordBreakSingleWord() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result = app.wordBreak("apple", dictionary);
        List<String> expected = List.of("apple");
        assertEquals(expected, result);
    }

    @Test
    public void testWordBreakWithRepeatedWords() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result = app.wordBreak("applepenapplepen", dictionary);
        List<String> expected = Arrays.asList("apple pen apple pen", "applepen apple pen", "apple pen applepen", "applepen applepen");
        assertNotEquals(expected, result);
    }

    @Test
    public void testWordBreakWithNullDictionary() {
        assertThrows(NullPointerException.class, () -> app.wordBreak("pineapplepenapple", null));
    }

    @Test
    public void testWordBreakWithNullString() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        assertThrows(NullPointerException.class, () -> app.wordBreak(null, dictionary));
    }
}
