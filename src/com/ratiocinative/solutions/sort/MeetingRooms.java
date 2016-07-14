package com.ratiocinative.solutions.sort;

import java.util.Arrays;

public class MeetingRooms {

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

    /**
     * basically find overlap
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> ((Integer) i1.start).compareTo(i2.start));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (i + 1 < intervals.length) {
                if (intervals[i].start == intervals[i + 1].start || intervals[i].end > intervals[i + 1].start) {
                    return false;
                }
            }
        }
        return true;
    }
}
