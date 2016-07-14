package com.ratiocinative.solutions.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public List<String> getAllPermutations(String s) {
        if (s.isEmpty() || s == null) {
            return new ArrayList<>();
        }
        return getAllPermutations("", s);
    }

    private List<String> getAllPermutations(String prefix, String s) {
        List<String> combination = new ArrayList<>();
        if (s.length() == 0) {
            combination.add(prefix);
            return combination;
        } else {
            for (int i = 0; i < s.length(); i++) {
                combination.addAll(
                        getAllPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length())));
            }
            return combination;
        }
    }

    public static void main(String[] args) {
        StringPermutations permutation = new StringPermutations();
        List<String> all = permutation.getAllPermutations("abc");
        for (String string : all) {
            System.out.println(string);
        }
    }
}
