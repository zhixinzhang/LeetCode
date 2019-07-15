package company.uber;

import DataStructure.Array.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2018/9/14.
 */
public class _252_MeetingRooms_sort {
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
