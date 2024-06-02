package com.shortthirdman.leetcode.quickstart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroupAnagramsTests {

    GroupAnagrams app;

    @BeforeEach
    public void setUp() {
        app = new GroupAnagrams();
    }

    @Test
    void testCategorizeBySorting_NormalCase() {
        String[] contentArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedResult = Arrays.asList(
                Arrays.asList("eat", "tea", "ate"),
                List.of("bat"),
                Arrays.asList("tan", "nat")
        );

        assertEquals(expectedResult, app.categorizeBySorting(contentArr));
    }

    @Test
    void testCategorizeBySorting_EmptyInput() {
        String[] contentArr = {};
        List<List<String>> expectedResult = Collections.emptyList();

        assertEquals(expectedResult, app.categorizeBySorting(contentArr));
    }

    @Test
    void testCategorizeBySorting_NullInput() {
        final List<List<String>> expectedResult = Collections.emptyList();
        assertThrows(NullPointerException.class, () -> app.categorizeBySorting(null));
    }

    @Test
    void testCategorizeBySorting_SingleElement() {
        String[] contentArr = {"hello"};
        List<List<String>> expectedResult = Collections.singletonList(Collections.singletonList("hello"));

        assertEquals(expectedResult, app.categorizeBySorting(contentArr));
    }

    @Test
    void testCategorizeBySorting_AllSameStrings() {
        String[] contentArr = {"aaa", "aaa", "aaa"};
        List<List<String>> expectedResult = Collections.singletonList(Arrays.asList("aaa", "aaa", "aaa"));

        assertEquals(expectedResult, app.categorizeBySorting(contentArr));
    }

    @Test
    void testCategorizeBySorting_SpecialCharacters() {
        String[] contentArr = {"$%^", "^%$", "#@!"};
        List<List<String>> expectedResult = Collections.singletonList(Arrays.asList("$%^", "^%$", "#@!"));

        assertNotEquals(expectedResult, app.categorizeBySorting(contentArr));
    }

    @Test
    void testCategorizeBySorting_ExceptionCase() {
        assertThrows(NullPointerException.class, () -> app.categorizeBySorting(null));
    }

    @Test
    public void testCategorizeByFrequency() {
        // Test case with different frequency strings
        String[] contentArr = {"hello", "world", "hell", "cats", "dogs", "cat"};
        List<List<String>> expectedResult = Arrays.asList(
                List.of("hello"),
                List.of("hell"),
                List.of("world"),
                List.of("cat"),
                List.of("cats"),
                List.of("dogs")
        );
        assertNotEquals(expectedResult, app.categorizeByFrequency(contentArr));
    }

    @Test
    public void testCategorizeByFrequency_EmptyInput() {
        // Test case with empty input array
        String[] contentArr = {};
        List<List<String>> expectedResult = new ArrayList<>();
        assertEquals(expectedResult, app.categorizeByFrequency(contentArr));
    }

    @Test
    public void testCategorizeByFrequency_NullInput() {
        // Test case with null input array
        List<List<String>> expectedResult = new ArrayList<>();
        assertEquals(expectedResult, app.categorizeByFrequency(null));
    }

    @Test
    public void testCategorizeByFrequency_SpecialCharacters() {
        // Test case with special characters
        String[] contentArr = {"$hello", "world!", "he@@ll", "cat$%", "dogs"};
        List<List<String>> expectedResult = Arrays.asList(
                List.of("$hello"),
                List.of("world!"),
                List.of("he@@ll"),
                List.of("cat$%"),
                List.of("dogs")
        );
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> app.categorizeByFrequency(contentArr), "Index out of bounds");
    }

    @Test
    public void testCategorizeByFrequency_AllSameStrings() {
        // Test case with all strings being the same
        String[] contentArr = {"hello", "hello", "hello", "hello"};
        List<List<String>> expectedResult = List.of(
                Arrays.asList("hello", "hello", "hello", "hello")
        );
        assertEquals(expectedResult, app.categorizeByFrequency(contentArr));
        compareListOfLists(expectedResult, app.categorizeByFrequency(contentArr));
    }

    @Test
    public void testCategorizeByFrequency_ThrowException() {
        // Test case for throwing an exception with invalid input
        String[] contentArr = {"hello", null, "world"};
        assertThrows(IllegalArgumentException.class, () -> app.categorizeByFrequency(contentArr));
    }

    private void compareListOfLists(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size(), "Outer lists should have the same size");

        for (int i = 0; i < expected.size(); i++) {
            List<String> expectedInner = expected.get(i);
            List<String> actualInner = actual.get(i);
            assertEquals(expectedInner.size(), actualInner.size(), "Inner lists should have the same size");

            for (int j = 0; j < expectedInner.size(); j++) {
                assertEquals(expectedInner.get(j), actualInner.get(j), "Element at position (" + i + ", " + j + ") should be equal");
            }
        }
    }
}
