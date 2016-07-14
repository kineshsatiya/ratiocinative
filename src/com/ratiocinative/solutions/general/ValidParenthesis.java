package com.ratiocinative.solutions.general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Map<Character, Character> myMap = new HashMap<>();
        myMap.put('}', '{');
        myMap.put(')', '(');
        myMap.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for(Character ch : s.toCharArray()) {
            if(myMap.containsKey(ch)) {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    Character checkOpen = stack.pop();
                    if(myMap.get(ch) != checkOpen) {
                        return false;
                    }
                }
            } else {
                stack.push(ch);
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
