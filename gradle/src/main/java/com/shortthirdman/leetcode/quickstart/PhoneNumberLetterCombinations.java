package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * (Check out your cellphone to see the mappings)
 * @author shortthirdman
 * @implNote Time complexity is O(k^n), where k is the biggest number of letters a digit can map (k=4) and n is the length of the digit string.
 * @version 1.0.0
 */
public class PhoneNumberLetterCombinations {

    public List<String> letterCombinationsByDFS(String digits) {
        Map<Character, char[]> dict = new HashMap<>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        char[] arr = new char[digits.length()];
        helper(digits, 0, new HashMap<>(dict), result, arr);

        return result;
    }

    private void helper(String digits, int index, HashMap<Character, char[]> dict,
                        List<String> result, char[] arr){
        if (index == digits.length()) {
            result.add(new String(arr));
            return;
        }

        char number = digits.charAt(index);
        char[] candidates = dict.get(number);
        for (int i = 0; i < candidates.length; i++) {
            arr[index] = candidates[i];
            helper(digits, index + 1, dict, result, arr);
        }
    }

    public List<String> letterCombinationsByBFS(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> l = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return l;
        }

        l.add("");

        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            String option = map.get(digits.charAt(i));

            for (int j = 0; j < l.size(); j++) {
                for (int p = 0; p < option.length(); p++) {
                    temp.add(new StringBuilder(l.get(j)).append(option.charAt(p)).toString());
                }
            }

            l.clear();
            l.addAll(temp);
        }

        return l;
    }
}
