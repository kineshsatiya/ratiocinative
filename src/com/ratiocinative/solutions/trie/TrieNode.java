package com.ratiocinative.solutions.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {

    Map<Character, TrieNode> children;
    List<String> words;

    public TrieNode() {
        children = new HashMap<>();
        words = new ArrayList<>();
    }
}
