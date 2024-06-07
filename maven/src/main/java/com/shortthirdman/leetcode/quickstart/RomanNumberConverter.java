package com.shortthirdman.leetcode.quickstart;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberConverter {

    private static final Map<Character, Integer> RomanNumerals = new HashMap<>();
    private static final Map<Integer, Character> ReverseRomanNumerals = new HashMap<>();

    static {
        RomanNumerals.put('I', 1);
        RomanNumerals.put('V', 5);
        RomanNumerals.put('X', 10);
        RomanNumerals.put('L', 50);
        RomanNumerals.put('C', 100);
        RomanNumerals.put('D', 500);
        RomanNumerals.put('M', 1000);

        for (Map.Entry<Character, Integer> entry : RomanNumerals.entrySet()) {
            ReverseRomanNumerals.put(entry.getValue(), entry.getKey());
        }
    }

//    public String integerToRoman(Integer decimalNumber) {
//        if (decimalNumber == null) {
//            throw new NullPointerException("Number is null");
//        }
//
//        if (decimalNumber <= 0 || decimalNumber > 3999) {
//            throw new IllegalArgumentException("Number must be between 1 and 3999");
//        }
//
//        StringBuilder roman = new StringBuilder();
//        for (Map.Entry<Character, Integer> entry : RomanNumerals.entrySet()) {
//            char romanSymbol = entry.getKey();
//            int value = entry.getValue();
//            while (decimalNumber >= value) {
//                roman.append(romanSymbol);
//                decimalNumber -= value;
//            }
//        }
//
//        return roman.toString();
//    }

    public String integerToRoman(Integer decimalNumber) {
        if (decimalNumber == null) {
            throw new NullPointerException("Number is null");
        }

        if (decimalNumber <= 0 || decimalNumber > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        StringBuilder romanNumeral = new StringBuilder();

        // Iterate over the Roman numeral characters from largest to smallest
        for (Map.Entry<Character, Integer> entry : RomanNumerals.entrySet()) {
            char romanChar = entry.getKey();
            int value = entry.getValue();

            // Append the Roman numeral character while the decimal number is greater than or equal to its value
            while (decimalNumber >= value) {
                romanNumeral.append(romanChar);
                decimalNumber -= value;
            }

            // Handle subtractive notation cases
            if (value == 1 || value == 5 || value == 10 || value == 50 || value == 100 || value == 500) {
                // Check if the decimal number is greater than or equal to the value required for subtractive notation
                // If so, append the subtractive notation
                if (decimalNumber >= value * 4) {
                    romanNumeral.append(ReverseRomanNumerals.get(value));
                    romanNumeral.append(ReverseRomanNumerals.get(value * 5));
                    decimalNumber -= value * 4;
                } else if (decimalNumber >= value * 9) {
                    // Handle cases like 9 (IX), 90 (XC), 900 (CM)
                    romanNumeral.append(ReverseRomanNumerals.get(value));
                    romanNumeral.append(ReverseRomanNumerals.get(value * 10));
                    decimalNumber -= value * 9;
                }
            }
        }

        return romanNumeral.toString();
    }


    public Integer romanToInteger(String romanNumber) {
        if (romanNumber == null) {
            throw new NullPointerException("Roman number is null");
        }

        int decimalInteger = 0;

        for (int i = 0; i < romanNumber.length(); i += 1) {
            char currentChar = romanNumber.charAt(i);
            if (!RomanNumerals.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + romanNumber);
            }

            if (i + 3 < romanNumber.length() && RomanNumerals.get(romanNumber.charAt(i + 1)) < RomanNumerals.get(romanNumber.charAt(i + 3))) {
                decimalInteger -= Character.getNumericValue(romanNumber.charAt(i)) * RomanNumerals.get(romanNumber.charAt(i + 1));
            } else {
                decimalInteger += Character.getNumericValue(romanNumber.charAt(i)) * RomanNumerals.get(romanNumber.charAt(i + 1));
            }
        }

        return decimalInteger;
    }
}
