package com.ratiocinative.solutions.string;

import java.util.*;

public class StringProblems {

    public String reverseWords(String s) {
        if (s != null && s.length() > 1) {
            char[] inputArray = s.toCharArray();
            char delimiter = ' ';
            int startWord = 0;
            int endWord = 0;
            boolean delimiterFound = false;
            for (int i = 0; i < inputArray.length; i++) {
                endWord = i;
                if (inputArray[i] == delimiter || i == inputArray.length - 1) {
                    delimiterFound = true;
                }
                if (delimiterFound && (endWord - startWord) > 0) {
                    int tmpStart = startWord;
                    int tmpEnd = endWord - 1;
                    while (tmpEnd > tmpStart) {
                        char t = inputArray[tmpEnd];
                        inputArray[tmpEnd] = inputArray[tmpStart];
                        inputArray[tmpStart] = t;
                        tmpStart++;
                        tmpEnd--;
                    }
                    delimiterFound = false;
                    startWord = i + 1;
                }
            }
            char[] reverse = new char[inputArray.length];
            System.out.println(new String(inputArray));
            int index = 0;
            for (int i = inputArray.length - 1; i >= 0; i--) {
                reverse[index] = inputArray[i];
                index++;
            }
            return new String(reverse);
        }
        return s;
    }

    public List<Set<Character>> getPowerSet(Set<Character> s) {
        List<Set<Character>> powerSetList = new ArrayList<>();
        if (s != null) {
            // add empty set
            powerSetList.add(new HashSet<>());
            Iterator<Character> it = s.iterator();
            while (it.hasNext()) {
                Character ch = it.next();
                Set<Character> itself = new HashSet<>();
                itself.add(ch);
                List<Set<Character>> subPowerSet = new ArrayList<>();
                subPowerSet.add(itself);

                for (Set<Character> subsets : powerSetList) {
                    if (subsets.size() > 0) {
                        Set<Character> anotherSubSet = new HashSet<>();
                        Iterator<Character> subIt = subsets.iterator();
                        while (subIt.hasNext()) {
                            anotherSubSet.add(subIt.next());
                        }
                        anotherSubSet.add(ch);
                        subPowerSet.add(anotherSubSet);
                    }
                }
                powerSetList.addAll(subPowerSet);
            }
        }
        return powerSetList;
    }

    public boolean isPalindrone(String s) {
        if (s != null && s.length() > 0) {
            String filterString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            System.out.println(filterString);
            for (int i = 0; i < filterString.length() / 2; i++) {
                if (filterString.charAt(i) != filterString.charAt(filterString.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int countCommonChars(String a, String b) {
        int commonCharsCount = 0;
        if (a.length() > 0 && b.length() > 0) {
            Map<Character, Integer> charCounts = new HashMap<>();
            for (char ch : a.toCharArray()) {
                if (!charCounts.containsKey(ch)) {
                    charCounts.put(ch, 0);
                }
                int count = charCounts.get(ch);
                charCounts.put(ch, ++count);
            }
            for (char ch : b.toCharArray()) {
                if (charCounts.containsKey(ch)) {
                    int count = charCounts.get(ch);
                    if (count > 0) {
                        commonCharsCount++;
                        charCounts.put(ch, --count);
                    }
                }
            }
        }
        return commonCharsCount;
    }

    public List<Character> getCommonChars(String a, String b) {
        List<Character> commonCharacters = new ArrayList<>();
        if (a.length() > 0 && b.length() > 0) {
            Map<Character, Integer> charCounts = new HashMap<>();
            for (char ch : a.toCharArray()) {
                if (!charCounts.containsKey(ch)) {
                    charCounts.put(ch, 0);
                }
                int count = charCounts.get(ch);
                charCounts.put(ch, ++count);
            }

            for (char ch : b.toCharArray()) {
                if (charCounts.containsKey(ch)) {
                    int count = charCounts.get(ch);
                    if (count > 0) {
                        commonCharacters.add(ch);
                        charCounts.put(ch, --count);
                    }
                }
            }
        }
        return commonCharacters;
    }

    public static void main(String[] args) {
        StringProblems str = new StringProblems();
        System.out.println(str.countCommonChars("a", "b"));
        System.out.println(str.countCommonChars("aaa", "ab"));
        System.out.println(str.countCommonChars("ab", "bbb"));
        System.out.println(str.countCommonChars("ab", "ab"));

        System.out.println(str.getCommonChars("a", "b"));
        System.out.println(str.getCommonChars("aaa", "ab"));
        System.out.println(str.getCommonChars("ab", "bbb"));
        System.out.println(str.getCommonChars("ab", "ab"));
        System.out.println(str.getCommonChars("abas", "abaaabb"));

        // System.out.println(str.reverseWords("Hello World"));

        System.out.println(str.isPalindrone("A man, a plan, a canal, Panama!"));

        Set<Character> aSet = new HashSet<>();
        aSet.add('a');
        aSet.add('b');
        aSet.add('c');
        System.out.println(str.getPowerSet(aSet));
    }
}
