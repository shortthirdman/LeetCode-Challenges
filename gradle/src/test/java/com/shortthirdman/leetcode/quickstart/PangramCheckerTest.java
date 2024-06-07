package com.shortthirdman.leetcode.quickstart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PangramCheckerTest {

    PangramChecker app;

    @BeforeEach
    void setUp() {
        app = new PangramChecker();
    }

    @AfterEach
    void tearDown() {
        app = null;
    }

    @Test
    void testIsPangram_PositiveCase() {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        assertTrue(app.isPangram(sentence));
    }

    @Test
    void testIsPangram_NegativeCase() {
        String sentence = "thequickbrwnfxjumpsverthelazydg"; // Missing 'o'
        assertFalse(app.isPangram(sentence));
    }

    @Test
    void testIsPangram_EmptyString() {
        String sentence = "";
        assertFalse(app.isPangram(sentence));
    }

    @Test
    void testIsPangram_AllLettersButOne() {
        String sentence = "abcdefghijklmnopqrstuvwyz"; // Missing 'x'
        assertFalse(app.isPangram(sentence));
    }

    @Test
    void testIsPangram_AllUpperCase() {
        String sentence = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
        assertTrue(app.isPangram(sentence));
    }

    @Test
    void testIsPangram_SpecialCharacters() {
        String sentence = "the quick brown fox jumps over the lazy dog";
        assertFalse(app.isPangram(sentence)); // Contains spaces
    }

    @Test
    void testIsPangram_OnlySpecialCharacters() {
        String sentence = "!@#$%^&*()_+-=[]{}|;':,.<>?/~`";
        assertFalse(app.isPangram(sentence)); // No alphabetic characters
    }

    @Test
    void testIsPangram_OneLetter() {
        String sentence = "a";
        assertFalse(app.isPangram(sentence)); // Only one letter
    }

    @Test
    void testIsPangram_ExceptionCase() {
        String sentence = null;
        assertThrows(NullPointerException.class, () -> app.isPangram(sentence));
    }
}