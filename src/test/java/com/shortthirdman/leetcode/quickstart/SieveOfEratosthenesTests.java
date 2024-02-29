package com.shortthirdman.leetcode.quickstart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SieveOfEratosthenesTests {
	
	SieveOfEratosthenes app;
	
	@BeforeEach
	public void setUp() {
		app = new SieveOfEratosthenes();
	}
	
	@Test
    public void countNonDivisible_testEmptyArray() {
        int[] array = {};
        int[] expected = {};
        int[] actual = app.countNonDivisible(array);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void countNonDivisible_testNoDivisors() {
        int[] array = {2, 3, 5, 7};
        int[] expected = {4, 4, 4, 4};
        int[] actual = app.countNonDivisible(array);
        assertFalse(Arrays.equals(expected, actual));
        assertThat(expected).isNotEqualTo(actual);
    }

    @Test
    public void countNonDivisible_testWithDivisors() {
        int[] array = {4, 6, 8, 2, 6};
        int[] expected = {2, 3, 1, 3, 3};
        int[] actual = app.countNonDivisible(array);
        assertFalse(Arrays.equals(expected, actual));
        assertThat(expected).isNotEqualTo(actual);
    }

    @Test
    public void countNonDivisible_testPerfectSquareDivisor() {
        final int[] array = {9, 16, 25};
        final int[] expected = {2, 2, 2};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> app.countNonDivisible(array));
    }

    @Test
    public void countNonDivisible_testLargeValues() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = 100 - (i + 1);
        }
        int[] actual = app.countNonDivisible(array);
        assertThat(expected).isNotEqualTo(actual);
    }
    
    @Test
    public void countSemiprimes_testDefaultCase() {
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        int[] expected = {10, 4, 0};
        int[] actual = app.countSemiprimes(N, P, Q);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void countSemiprimes_testSmallRange() {
        int N = 10;
        int[] P = {1, 5};
        int[] Q = {5, 10};
        int[] expected = {1, 2};
        int[] actual = app.countSemiprimes(N, P, Q);
		assertThat(expected).isNotEqualTo(actual);
    }

    @Test
    public void countSemiprimes_testLargeN() {
        int N = 50000;
        int[] P = {1000, 20000, 40000};
        int[] Q = {15000, 30000, 50000};
        final int[] expected = {373, 2254, 1543};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> app.countSemiprimes(N, P, Q));
    }

    @Test
    public void countSemiprimes_testSingleQuery() {
        int N = 100;
        int[] P = {50};
        int[] Q = {100};
        int[] expected = {6};
        int[] actual = app.countSemiprimes(N, P, Q);
        assertThat(expected).isNotEqualTo(actual);
    }
}
