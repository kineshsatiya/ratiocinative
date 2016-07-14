package com.ratiocinative.solutions.heap;

import java.util.*;

public class TopKNumbers {

    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (o1, o2) ->
                o1.getValue().compareTo(o2.getValue()));

        // count all unique numbers
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int n : nums) {
            if (!numCount.containsKey(n)) {
                numCount.put(n, 0);
            }
            int count = numCount.get(n);
            numCount.put(n, ++count);
        }

        int added = 0;
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (added == k) {
                Map.Entry<Integer, Integer> lowestCountKey = pq.peek();
                if (lowestCountKey.getValue() < entry.getValue()) {
                    pq.remove();
                    pq.add(entry);
                }
            } else {
                pq.add(entry);
                ++added;
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = pq.iterator();
        List<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next().getKey());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

