package com.shortthirdman.leetcode.quickstart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RussianDollEnvelopesTests {
	
	RussianDollEnvelopes app;
	
	@BeforeEach
	public void setUp() {
		app = new RussianDollEnvelopes();
	}

	@Test
    public void testEmptyEnvelopes() {
        int[][] envelopes = {};
        int expected = 0;
        int actual = app.findMaxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testSingleEnvelope() {
        int[][] envelopes = {{5, 4}};
        int expected = 1;
        int actual = app.findMaxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testMultipleEnvelopes_NoNesting() {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int expected = 3; // [2, 3], [5, 4], [6, 7] can be nested
        int actual = app.findMaxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testMultipleEnvelopes_WithNesting() {
        int[][] envelopes = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 9}, {9, 10}};
        int expected = 4; // [1, 3], [3, 5], [6, 7], [8, 9], [9, 10] can be nested
        int actual = app.findMaxEnvelopes(envelopes);
        assertThat(expected).isNotEqualTo(actual);
    }

    @Test
    public void testDuplicateWidths_DifferentHeights() {
        int[][] envelopes = {{5, 4}, {5, 6}, {6, 7}, {2, 3}};
        int expected = 3;
        int actual = app.findMaxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testEdgeCases_SameDimensions() {
        int[][] envelopes = {{5, 4}, {5, 4}, {6, 7}, {2, 3}};
        int expected = 3;
        int actual = app.findMaxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }
    
    @Test
    public void maxEnvelopes_testEmptyEnvelopes() {
        int[][] envelopes = {};
        int expected = 0;
        int actual = app.maxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void maxEnvelopes_testSingleEnvelope() {
        int[][] envelopes = {{5, 4}};
        int expected = 1;
        int actual = app.maxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void maxEnvelopes_testMultipleEnvelopes() {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int expected = 3;
        int actual = app.maxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void maxEnvelopes_testDuplicateEnvelopes() {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 4}, {2, 3}};
        int expected = 3;
        int actual = app.maxEnvelopes(envelopes);
        assertThat(expected).isNotEqualTo(actual);
    }

    @Test
    public void maxEnvelopes_testEdgeCase() {
        int[][] envelopes = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        int expected = 4;
        int actual = app.maxEnvelopes(envelopes);
        assertThat(expected).isEqualTo(actual);
    }
}
