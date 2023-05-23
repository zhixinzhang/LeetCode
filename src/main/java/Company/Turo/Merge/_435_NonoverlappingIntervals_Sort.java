package Company.Turo.Merge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2018/7/27.
 * https://leetcode.com/problems/non-overlapping-intervals/discuss/91771/Java-Solution-with-clear-explain
 */
public class _435_NonoverlappingIntervals_Sort {
    public static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1)  return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) 
                    return o1.end - o2.end;  //first sort by end
                return o2.start - o1.start;  //second sort by start
            }
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end)
                end = interval.end;
            else
                count++;
        }

        return count;
    }

    public static void main(String[] args){
        eraseOverlapIntervals(new Interval[]{new Interval(1,100),new Interval(11,22),new Interval(1,11),
                new Interval(2,12)});
    }
}
