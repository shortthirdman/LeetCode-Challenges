package com.shortthirdman.leetcode.quickstart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberConverterTest {

    RomanNumberConverter app;

    @BeforeEach
    void setUp() {
        app = new RomanNumberConverter();
    }

    @AfterEach
    void tearDown() {
        app = null;
    }

    @Test
    public void testIntegerToRoman() {
        assertEquals("I", app.integerToRoman(1));
        assertEquals("III", app.integerToRoman(3));
        assertNotEquals("IV", app.integerToRoman(4));
        assertEquals("V", app.integerToRoman(5));
        assertEquals("IX", app.integerToRoman(9));
        assertEquals("X", app.integerToRoman(10));
        assertEquals("XL", app.integerToRoman(40));
        assertEquals("L", app.integerToRoman(50));
        assertEquals("XC", app.integerToRoman(90));
        assertEquals("C", app.integerToRoman(100));
        assertEquals("CD", app.integerToRoman(400));
        assertEquals("D", app.integerToRoman(500));
        assertEquals("CM", app.integerToRoman(900));
        assertEquals("M", app.integerToRoman(1000));
        assertEquals("MMMCMXCIX", app.integerToRoman(3999));
    }

    @Test
    public void testIntegerToRoman_NullInput() {
        assertThrows(NullPointerException.class, () -> app.integerToRoman(null));
    }

    @Test
    public void testIntegerToRoman_OutOfRangeInput() {
        assertThrows(IllegalArgumentException.class, () -> app.integerToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> app.integerToRoman(4000));
    }

    @Test
    public void testRomanToInteger() {
        assertEquals(1, app.romanToInteger("I"));
        assertEquals(3, app.romanToInteger("III"));
        assertEquals(4, app.romanToInteger("IV"));
        assertEquals(5, app.romanToInteger("V"));
        assertEquals(9, app.romanToInteger("IX"));
        assertEquals(10, app.romanToInteger("X"));
        assertEquals(40, app.romanToInteger("XL"));
        assertEquals(50, app.romanToInteger("L"));
        assertEquals(90, app.romanToInteger("XC"));
        assertEquals(100, app.romanToInteger("C"));
        assertEquals(400, app.romanToInteger("CD"));
        assertEquals(500, app.romanToInteger("D"));
        assertEquals(900, app.romanToInteger("CM"));
        assertEquals(1000, app.romanToInteger("M"));
        assertEquals(3999, app.romanToInteger("MMMCMXCIX"));
    }

    @Test
    public void testRomanToInteger_NullInput() {
        assertThrows(NullPointerException.class, () -> app.romanToInteger(null));
    }

    @Test
    public void testRomanToInteger_InvalidRomanNumber() {
        assertThrows(IllegalArgumentException.class, () -> app.romanToInteger("IIII"));
        assertThrows(IllegalArgumentException.class, () -> app.romanToInteger("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> app.romanToInteger("VV"));
        assertThrows(IllegalArgumentException.class, () -> app.romanToInteger("LL"));
        assertThrows(IllegalArgumentException.class, () -> app.romanToInteger("DD"));
    }
}