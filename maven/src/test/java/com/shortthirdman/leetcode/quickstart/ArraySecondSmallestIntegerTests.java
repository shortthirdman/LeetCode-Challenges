package com.shortthirdman.leetcode.quickstart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArraySecondSmallestIntegerTests {

    ArraySecondSmallestInteger app;

    @BeforeEach
    public void setUp() {
        app = new ArraySecondSmallestInteger();
    }

    @Test
    public void test_findSecondSmallestInteger_usingArraySort() {
        assertEquals(4, app.findUsingArraySort(new int[]{5, 3, 8, 9, 6, 8, 4, 4}));
        assertEquals(-1, app.findUsingArraySort(new int[]{5}));
        assertNotEquals(3, app.findUsingArraySort(new int[]{5, 3}));
        assertEquals(-1, app.findUsingArraySort(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    public void test_findSecondSmallestInteger_usingSinglePassThrough() {
        assertEquals(4, app.findUsingSinglePassThrough(new int[]{5, 3, 8, 9, 6, 8, 4, 4}));
        assertEquals(-1, app.findUsingSinglePassThrough(new int[]{5}));
        assertNotEquals(3, app.findUsingSinglePassThrough(new int[]{5, 3}));
        assertEquals(-1, app.findUsingSinglePassThrough(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    public void test_findSecondSmallestInteger_usingMinHeap() {
        assertEquals(4, app.findUsingMinHeap(new int[]{5, 3, 8, 9, 6, 8, 4, 4}));
        assertEquals(-1, app.findUsingMinHeap(new int[]{5}));
        assertNotEquals(3, app.findUsingMinHeap(new int[]{5, 3}));
        assertEquals(-1, app.findUsingMinHeap(new int[]{5, 5, 5, 5, 5}));
    }
}
