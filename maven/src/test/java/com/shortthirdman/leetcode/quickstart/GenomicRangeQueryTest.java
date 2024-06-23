package com.shortthirdman.leetcode.quickstart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenomicRangeQueryTest {

    GenomicRangeQuery app;

    @BeforeEach
    void setUp() {
        app = new GenomicRangeQuery();
    }

    @Test
    void emptyString() {
        String S = "";
        int[] P = {};
        int[] Q = {};
        assertArrayEquals(new int[] {}, app.minimalNucleotideInDNA(S, P, Q));
        assertArrayEquals(new int[] {}, app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void singleCharacter() {
        String S = "A";
        int[] P = {0};
        int[] Q = {0};
        assertArrayEquals(new int[] {1}, app.minimalNucleotideInDNA(S, P, Q));
        assertArrayEquals(new int[] {1}, app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void allCharacters() {
        String S = "CAGCCTA";
        int[] P = {0};
        int[] Q = {6};
        assertArrayEquals(new int[]{1}, app.minimalNucleotideInDNA(S, P, Q));
        assertArrayEquals(new int[]{1}, app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void specificRange() {
        String S = "CAGCCTA";
        int[] P = {2};
        int[] Q = {4};
        assertArrayEquals(new int[]{2}, app.minimalNucleotideInDNA(S, P, Q));
        assertArrayEquals(new int[]{2}, app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void invalidNucleotide() {
        String S = "CAGCXTA";
        int[] P = {0};
        int[] Q = {6};
        assertThrows(IllegalArgumentException.class, () -> app.minimalNucleotideInDNA(S, P, Q));
        assertThrows(IllegalArgumentException.class, () -> app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void invalidStartIndex() {
        String S = "CAGCCTA";
        int[] P = {-1};
        int[] Q = {4};
        assertThrows(IndexOutOfBoundsException.class, () -> app.minimalNucleotideInDNA(S, P, Q));
        assertThrows(IndexOutOfBoundsException.class, () -> app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void invalidEndIndex() {
        String S = "CAGCCTA";
        int[] P = {0};
        int[] Q = {7};
        assertThrows(IndexOutOfBoundsException.class, () -> app.minimalNucleotideInDNA(S, P, Q));
        assertThrows(IndexOutOfBoundsException.class, () -> app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void emptyQueryArray() {
        String S = "CAGCCTA";
        int[] P = {};
        int[] Q = {};
        assertArrayEquals(new int[] {}, app.minimalNucleotideInDNA(S, P, Q));
        assertArrayEquals(new int[] {}, app.findMinimalNucleotide(S, P, Q));
    }

    @Test
    void startGreaterThanEnd() {
        String S = "CAGCCTA";
        int[] P = {4};
        int[] Q = {2};
        assertThrows(IllegalArgumentException.class, () -> app.minimalNucleotideInDNA(S, P, Q));
        assertThrows(IllegalArgumentException.class, () -> app.findMinimalNucleotide(S, P, Q));
    }
}