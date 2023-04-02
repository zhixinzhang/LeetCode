package Company.Google.Array.Interval_Meeting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2018/7/27.
 *  给一堆interval，和一个单独的，问你有没Overlap
 *  http://www.1point3acres.com/bbs/thread-430792-1-1.html
 *  follow up LC 435. Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals/discuss/91771/Java-Solution-with-clear-explain
 *
 *  根据 arrays。sort  end排序 然后对比end
 */
public class JudgeOverLapping_Interval {
    public class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public boolean solution(Interval[] intervals, Interval interval){
        if (intervals == null || intervals.length == 0)
            return false;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end){
                    return o1.end - o2.end;
                }else {
                    return o2.start - o1.start;
                }
            }
        });
        // [1, 4] [3, 2], [1,4] [ ]
        int end = Integer.MIN_VALUE;
        int left = interval.start;
        for (Interval inter : intervals){
            if (end <= inter.end){
                end = inter.end;
            }else{
                return true;
            }
            if (left > inter.start && left < inter.end)
                return true;
        }
        return false;
    }
}
