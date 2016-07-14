package com.ratiocinative.solutions.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children.containsKey(word.charAt(i))) {
                curr = curr.children.get(word.charAt(i));
            } else {
                TrieNode n = new TrieNode();
                curr.children.put(word.charAt(i), n);
                curr = n;
            }
            if (i == word.length() - 1) {
                curr.words.add(word);
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (root != null) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children.containsKey(word.charAt(i))) {
                    curr = curr.children.get(word.charAt(i));
                } else {
                    return false;
                }
                if (i == word.length() - 1) {
                    return curr.words.contains(word);
                }
            }
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (root != null) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (curr.children.containsKey(prefix.charAt(i))) {
                    curr = curr.children.get(prefix.charAt(i));
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}