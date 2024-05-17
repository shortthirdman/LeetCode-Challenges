package com.shortthirdman.leetcode.quickstart;

import java.util.*;

public class WordLadders {

    private static class Node {
        public String word;
        public int depth;
        public Node prev;

        public Node(String word, int depth, Node prev) {
            this.word = word;
            this.depth = depth;
            this.prev = prev;
        }
    }

    private static class WordNode {
        String word;
        int numSteps;

        public WordNode(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    /**
     * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end,
     * such that only one letter can be changed at a time and each intermediate word must exist in the dictionary.
     * @param beginWord the word to begin with
     * @param endWord the word to end with
     * @param wordList the list of words
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        HashSet<String> unvisited = new HashSet<>(wordList);

        LinkedList<Node> queue = new LinkedList<>();
        Node node = new Node(beginWord, 0, null);
        queue.offer(node);

        int minLen = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node top = queue.poll();

            //top if have shorter result already
            if (result.size() > 0 && top.depth > minLen) {
                return result;
            }

            for (int i = 0; i < top.word.length(); i++) {
                char c = top.word.charAt(i);
                char[] arr = top.word.toCharArray();
                for (char j = 'z'; j >= 'a'; j--) {
                    if (j == c) {
                        continue;
                    }
                    arr[i] = j;
                    String t = new String(arr);

                    if (t.equals(endWord)) {
                        //add to result
                        List<String> aResult = new ArrayList<>();
                        aResult.add(endWord);
                        Node p = top;
                        while (p != null) {
                            aResult.add(p.word);
                            p = p.prev;
                        }

                        Collections.reverse(aResult);
                        result.add(aResult);

                        //stop if get shorter result
                        if (top.depth <= minLen) {
                            minLen = top.depth;
                        } else {
                            return result;
                        }
                    }

                    if (unvisited.contains(t)) {
                        Node n = new Node(t, top.depth + 1, top);
                        queue.offer(n);
                        unvisited.remove(t);
                    }
                }
            }
        }

        return result;
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if (word.equals(endWord)) {
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (wordDict.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordDict.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }

        return 0;
    }
}
