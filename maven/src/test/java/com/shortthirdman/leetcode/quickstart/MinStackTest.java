package com.shortthirdman.leetcode.quickstart;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinStackTest {

	@Test
    public void testBasicOperations() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        Assertions.assertEquals(-3, minStack.getMin());
        Assertions.assertEquals(-3, minStack.top());

        minStack.pop();

        Assertions.assertEquals(-3, minStack.getMin());
        Assertions.assertEquals(0, minStack.top());
    }

    @Test
    public void testPopEmptyStack() {
        MinStack minStack = new MinStack();
        Assertions.assertThrows(EmptyStackException.class, () -> minStack.pop());
        Assertions.assertTrue(minStack.isEmpty());
        Assertions.assertThrows(EmptyStackException.class, () -> minStack.top());
    }
    
    @Test
    public void testSingleElement() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        Assertions.assertFalse(minStack.isEmpty());
        Assertions.assertEquals(10, minStack.top());
        Assertions.assertEquals(10, minStack.getMin());
    }

    @Test
    public void testPushPopTop() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(5);

        Assertions.assertEquals(5, minStack.top());
        Assertions.assertEquals(5, minStack.getMin());

        minStack.pop();

        Assertions.assertEquals(10, minStack.top());
        Assertions.assertNotEquals(10, minStack.getMin());
        Assertions.assertEquals(5, minStack.getMin());
    }

    @Test
    public void testDuplicateMinimum() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(3);
        minStack.push(2);
        minStack.push(3);

        Assertions.assertEquals(2, minStack.getMin());

        minStack.pop(); // Remove top 3

        Assertions.assertEquals(2, minStack.getMin());
    }
    
    @Test
    public void testMinimumAfterPop() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(20);
        minStack.push(5);

        minStack.pop(); // Pop 5

        Assertions.assertNotEquals(10, minStack.getMin());
        Assertions.assertEquals(5, minStack.getMin());
        Assertions.assertEquals(20, minStack.top());
    }
    
    @Test
    public void testLargeValues() {
        MinStack minStack = new MinStack();
        minStack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MIN_VALUE);

        Assertions.assertEquals(Integer.MIN_VALUE, minStack.getMin());
        Assertions.assertNotEquals(Integer.MAX_VALUE, minStack.top());
    }
}
