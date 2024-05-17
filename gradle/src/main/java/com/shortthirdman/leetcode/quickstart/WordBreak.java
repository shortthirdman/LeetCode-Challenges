package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 */
public class WordBreak {


    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<String> wordBreak(String s, Set<String> dict) {
        ArrayList[] dp = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null)
                continue;

            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<>();
                    }
                    dp[end].add(word);
                }
            }
        }

        List<String> result = new LinkedList<>();
        if (dp[s.length()] == null) {
            return result;
        }

        ArrayList<String> temp = new ArrayList<>();
        dfs(dp, s.length(), result, temp);

        return result;
    }

    public void dfs(List<String>[] dp, int end, List<String> result, ArrayList<String> tmp) {
        if (end <= 0) {
            StringBuilder path = new StringBuilder(tmp.get(tmp.size() - 1));
            for (int i = tmp.size() - 2; i >= 0; i--) {
                path.append(" ").append(tmp.get(i));
            }

            result.add(path.toString());
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
