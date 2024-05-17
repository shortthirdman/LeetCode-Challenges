package com.shortthirdman.leetcode.quickstart;

import java.util.function.Function;
import java.util.stream.IntStream;

public class SeriesTypeChecker {

    public boolean isArithmeticSeries(int[] arr) {
        int length = arr.length;
        if (length < 2) return false;

        int commonDifference = arr[1] - arr[0];

        return IntStream.range(2, length)
                .allMatch(i -> arr[i] - arr[i - 1] == commonDifference);
    }

    public boolean isGeometricSeries(int[] arr) {
        int length = arr.length;
        if (length < 2) return false;

        int commonRatio = arr[1] / arr[0];

        return IntStream.range(2, length)
                .allMatch(i -> arr[i] / arr[i - 1] == commonRatio);
    }

    public boolean isFibonacciSeries(int[] arr) {
        int length = arr.length;
        if (length < 3) return false;

        Function<Integer, Integer> fibonacci = n -> {
            if (n <= 1) return n;
            int a = 0, b = 1, result = 0;
            for (int i = 2; i <= n; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        };

        return IntStream.range(2, length)
                .allMatch(i -> arr[i - 1] + arr[i - 2] == arr[i] || arr[i] == fibonacci.apply(i));
    }
}
