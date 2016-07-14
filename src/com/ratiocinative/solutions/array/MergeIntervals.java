package com.ratiocinative.solutions.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    //Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, (v1, v2) -> {
            if (v1.start > v2.start) {
                return 1;
            }
            if (v1.start < v2.start) {
                return -1;
            }
            return 0;
        });

        Interval prev = null;
        if (intervals.size() > 0) {
            result.add(intervals.get(0));
            prev = intervals.get(0);
        }

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= prev.end) {
                if (interval.end > prev.end) {
                    prev.end = interval.end;
                }
            } else {
                result.add(interval);
                prev = interval;
            }
        }

        return result;
    }
}
