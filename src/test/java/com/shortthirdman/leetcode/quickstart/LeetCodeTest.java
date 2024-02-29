package com.shortthirdman.leetcode.quickstart;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test cases for LeetCode
 */
public class LeetCodeTest {

    @Test
    public void kthSmallestElementMatrix() {
        int[][] inputMatrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int expected = 13;

        final KthSmallestElementMatrix ref = new KthSmallestElementMatrix();
        final int result = ref.kthSmallest(inputMatrix, k);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void maxChunksToSortArray() {
        final int[] arr = { 2, 0, 1 };
        final int expected = 1;

        final MaxChunksForSortedArray ref = new MaxChunksForSortedArray();
        final int result = ref.maxChunksToSortArray(arr);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void groupAnagramsCategorizeBySorting() {
        final String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final GroupAnagrams ref = new GroupAnagrams();

        List<List<String>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
        expectedList.add(new ArrayList<>(Arrays.asList("tan", "nat")));
        expectedList.add(new ArrayList<>(Arrays.asList("bat")));
        List<Integer> expectedGroupLengths = new ArrayList<>();
        for (List<String> strings : expectedList) {
            expectedGroupLengths.add(strings.size());
        }

        List<List<String>> actualList = ref.categorizeBySorting(strArr);
        List<Integer> actualGroupLengths = new ArrayList<>();
        for (List<String> strings : actualList) {
            actualGroupLengths.add(strings.size());
        }

        Collections.sort(expectedGroupLengths);
        Collections.sort(actualGroupLengths);
        assertEquals(expectedGroupLengths.toString(), actualGroupLengths.toString());
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test
    public void groupAnagramsCategorizeByFrequency() {
        final String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ref = new GroupAnagrams();

        List<List<String>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
        expectedList.add(new ArrayList<>(Arrays.asList("tan", "nat")));
        expectedList.add(new ArrayList<>(Arrays.asList("bat")));
        List<Integer> expectedGroupLengths = new ArrayList<>();
        for (List<String> strings : expectedList) {
            expectedGroupLengths.add(strings.size());
        }

        List<List<String>> actualList = ref.categorizeByFrequency(strArr);
        List<Integer> actualGroupLengths = new ArrayList<>();
        for (List<String> strings : actualList) {
            actualGroupLengths.add(strings.size());
        }

        Collections.sort(expectedGroupLengths);
        Collections.sort(actualGroupLengths);
        assertEquals(expectedGroupLengths.toString(), actualGroupLengths.toString());
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test
    public void phoneNumberCombinations() {
        final String inputDigits = "23";
        final List<String> expectedCombinations = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        final PhoneNumberLetterCombinations ref = new PhoneNumberLetterCombinations();

        List<String> actualCombinations = ref.letterCombinationsByDFS(inputDigits);
        assertEquals(actualCombinations, expectedCombinations);
        assertTrue(actualCombinations.size() == expectedCombinations.size() && actualCombinations.containsAll(expectedCombinations) && expectedCombinations.containsAll(actualCombinations));

        actualCombinations.clear();
        actualCombinations = ref.letterCombinationsByBFS(inputDigits);
        assertEquals(actualCombinations, expectedCombinations);
        assertTrue(actualCombinations.size() == expectedCombinations.size() && actualCombinations.containsAll(expectedCombinations) && expectedCombinations.containsAll(actualCombinations));
    }

    @Test
    public void lexicographicalNumbers() {
        final int inputNumber = 13;
        final List<Integer> expectedNumbers = Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);

        final LexicographicalNumbers ref = new LexicographicalNumbers();

        final List<Integer> actualNumbers = ref.lexicalOrder(inputNumber);
        assertEquals(actualNumbers, expectedNumbers);
        assertTrue(actualNumbers.size() == expectedNumbers.size() && expectedNumbers.containsAll(actualNumbers) && actualNumbers.containsAll(expectedNumbers));
    }

    @Test
    public void subArraysBoundedMaximum() {
        final int[] inputArray = {2, 1, 4, 3};
        final int leftIndex = 2;
        final int rightIndex = 3;
        final int expectedCount = 3;

        final SubarraysBoundedMaximum ref = new SubarraysBoundedMaximum();
        final int actualCount = ref.subarrayBoundedMax(inputArray, leftIndex, rightIndex);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testWiggleSort() {
        final int[] inputArray = {3, 5, 2, 1, 6, 4};
        final int[] expectedArray = {3, 5, 1, 6, 2, 4};

        final WiggleSort ref = new WiggleSort();
        ref.wiggleSort(inputArray);

        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testWiggleSubsequence() {
    }

    @Test
    public void testMinimumWageWorkers() {
        final int[] quality = {10, 20, 5};
        final int[] wage = {70, 50, 30};
        final int k = 2;
        double expectedMinCost = 105.00000;

        final HireWorkersMinimumWage ref = new HireWorkersMinimumWage();
        final double actualMinCost = ref.minCostToHireWorkers(quality, wage, k);

        assertEquals(expectedMinCost, actualMinCost, 0);
    }

    @Test
    public void testWordLadders() {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int expectedLength = 5;

        final WordLadders ref = new WordLadders();

        final int actualLength = ref.ladderLength(start, end, new HashSet<>(wordList));
        assertEquals(actualLength, expectedLength);

        List<List<String>> expectedList = new ArrayList<>();
        List<String> firstList = Arrays.asList("hit", "hot", "dot", "dog", "cog");
        List<String> secondList = Arrays.asList("hit", "hot", "lot", "log", "cog");
        expectedList.addAll(0, Collections.singletonList(firstList));
        expectedList.addAll(1, Collections.singletonList(secondList));

        final List<List<String>> actualList = ref.findLadders(start, end, wordList);
        assertTrue(actualList.size() == expectedList.size() && expectedList.containsAll(actualList) && actualList.containsAll(expectedList));
    }

    @Test
    public void testWordSearch() {
    }

    @Test
    public void testSeriesTypeChecker() {
        int[] arr1 = {1, 2, 3, 4, 5};
        final SeriesTypeChecker ref = new SeriesTypeChecker();

        boolean checkSeries = ref.isArithmeticSeries(arr1);
        assertTrue(checkSeries);

        checkSeries = ref.isGeometricSeries(arr1);
        assertFalse(checkSeries);
    }

    @Test
    public void testReverseWordsGenerator() {
        final String inputText = "Hello world";
        final String expectedText = "OlleH Dlrow";

        final ReverseWordsGenerator ref = new ReverseWordsGenerator();
        final String actualText = ref.reverseWords(inputText);

        assertEquals(expectedText, actualText);
    }
}
