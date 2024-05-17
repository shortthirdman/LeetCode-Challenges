package com.shortthirdman.leetcode.quickstart;

import java.util.Stack;
import java.util.function.BooleanSupplier;

public class MinStack {

	private Stack<Integer> stack;
    private int minElement;
    
    public MinStack() {
        stack = new Stack<>();
        minElement = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= minElement) {
            // Push current minimum twice to track the previous minimum later.
            stack.push(minElement);
            minElement = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek() == minElement) {
            // If popping the min, update minEle to the previously stored minimum.
        	minElement = stack.pop();
            stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minElement;
    }

	public BooleanSupplier isEmpty() {
		BooleanSupplier supplier = () -> stack.empty();
		return supplier;
	}
}
