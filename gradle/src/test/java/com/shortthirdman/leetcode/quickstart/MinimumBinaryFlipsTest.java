package com.shortthirdman.leetcode.quickstart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimumBinaryFlipsTest {

	MinimumBinaryFlips app;
	
	@BeforeEach
	public void setUp() {
		app = new MinimumBinaryFlips();
	}
	
	@Test
	public void testGetMinFlips_defaultScenario() {
		String firstPwd = "100110";
        String secondPwd = "101011";
        String thirdPwd = "1110011000";
        
        assertEquals(3, app.getMinFlips(firstPwd));
        assertEquals(2, app.getMinFlips(secondPwd));
        assertEquals(3, app.getMinFlips(thirdPwd));
	}
}
