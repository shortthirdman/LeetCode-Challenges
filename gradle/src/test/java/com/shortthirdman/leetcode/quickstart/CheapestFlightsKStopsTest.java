package com.shortthirdman.leetcode.quickstart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheapestFlightsKStopsTest {

	CheapestFlightsKStops app;
	
	@BeforeEach
	public void setUp() {
		app = new CheapestFlightsKStops();
	}
	
	@Test
	public void test_findCheapestPrice_success() {
		int n = 3, src = 0, dest = 2, k = 1;
		int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		
		int expected = 200;
		
		int actual = app.findCheapestPrice(n, edges, src, dest, k);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_findCheapestPrice_Ok() {
		int n = 3, src = 0, dest = 2, k = 0;
		int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		
		int expected = 500;
		
		int actual = app.findCheapestPrice(n, edges, src, dest, k);
		
		assertEquals(expected, actual);
	}
}
