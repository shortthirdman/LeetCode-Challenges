package com.shortthirdman.leetcode.quickstart;

import lombok.Data;

@Data
public class Node {
    private int value;
    private int start;

    private int end;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, int start, int end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }
}
