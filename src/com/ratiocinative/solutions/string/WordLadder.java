package com.ratiocinative.solutions.string;

import java.util.*;

public class WordLadder {

    char[] allChars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static class Value {
        public String word;
        Value parent;
        int level;

        public Value(String w, int level, Value parent) {
            this.word = w;
            this.level = level;
            this.parent = parent;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Deque<Value> queue = new ArrayDeque<>();

        int currentLevel = 1;
        Value start = new Value(beginWord, currentLevel, null);
        int shortestPathLen = Integer.MAX_VALUE;
        wordList.remove(beginWord);
        List<Value> endValues = new ArrayList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Value v = queue.poll();
            if (v.level != currentLevel) {
                currentLevel++;
            }
            if (v.level < shortestPathLen) {
                for (int i = 0; i < v.word.length(); i++) {
                    for (char ch : allChars) {
                        String newWord;
                        if (i == 0) {
                            newWord = ch + v.word.substring(i + 1, v.word.length());
                        } else {
                            newWord = v.word.substring(0, i) + ch + v.word.substring(i + 1, v.word.length());
                        }
                        if (newWord.equals(endWord)) {
                            endValues.add(new Value(endWord, currentLevel + 1, v));
                            shortestPathLen = currentLevel + 1;
                        } else {
                            if (wordList.contains(newWord) && !newWord.equals(v.word)) {
                                Value nextValue = new Value(newWord, currentLevel + 1, v);
                                if (nextValue.level < shortestPathLen) {
                                    queue.add(nextValue);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Value v : endValues) {
            List<String> result = new ArrayList<>();
            Deque<String> stack = new ArrayDeque<>();
            while (v != null) {
                stack.push(v.word);
                v = v.parent;
            }
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
            results.add(result);
        }

        return results;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        Set<String> dict = new HashSet<>(Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        List<List<String>> results = wl.findLadders("red", "tax", dict);
        for (List<String> result : results) {
            System.out.println(result);
        }

    }
}
