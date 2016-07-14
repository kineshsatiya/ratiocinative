package com.ratiocinative.solutions.heap;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>((i, p) -> -1 * Integer.compare(i, p));
        min = new PriorityQueue<>((i, p) -> Integer.compare(i, p));
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (max.isEmpty()) {
            max.add(num);
        } else {
            if (num > max.peek()) {
                min.add(num);
            } else {
                max.add(num);
            }

            if (Math.abs((max.size() - min.size())) > 1) {
                if (max.size() > min.size()) {
                    min.add(max.poll());
                } else {
                    max.add(min.poll());
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (Math.abs(max.size() - min.size()) > 0) {
            if (max.size() > min.size()) {
                return max.peek();
            }
            return min.peek();
        }
        return ((double) (max.peek() + min.peek()) / 2);
    }
}