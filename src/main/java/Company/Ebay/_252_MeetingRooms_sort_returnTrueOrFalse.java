package Company.Ebay;

import DataStructure.Array.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2018/9/14.
 */
public class _252_MeetingRooms_sort_returnTrueOrFalse {
    //ONLogN
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return true;

        //nlogn
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0])
                    return a[0] - b[0];
                else
                    return a[1] - b[1];
            }
        });

        int l = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(l > intervals[i][0])
                return false;
            l = intervals[i][1];
        }
        return true;
    }


    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1)
            return true;

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                if(a.start != b.start){
                    return a.start - b.start;
                }else{
                    return a.end - b.end;
                }
            }
        });
        Interval prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            Interval cur = intervals[i];
            if(prev.end >= cur.start)
                return false;
            prev = cur;
        }
        return true;
    }
}
