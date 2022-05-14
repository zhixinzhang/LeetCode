package Company.uber;

import DataStructure.Array.Interval;

import java.util.*;

/**
 * Created by zhang on 2018/9/17.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=353866&ctid=201324
 * follw up 是需要返回 meeting room的房间号
 */
public class _253_MeetingRoom_followup {
    public static void main(String[] args){
        Interval[] i = new Interval[6];
        //[0, 30],[0,15],[5, 10],[15, 20], [40, 50] [60, 70]
        i[0] = new Interval(0,30);
        i[1] = new Interval(15,20);
        i[2] = new Interval(0,15);
        i[3] = new Interval(5,10);
        i[4] = new Interval(40,50);
        i[5] = new Interval(60,70);
//        i[0] = new Interval(0,5);
//        i[1] = new Interval(10,15);
//        i[2] = new Interval(20,50);
//        i[3] = new Interval(20,30);
//        i[4] = new Interval(30,40);
//        i[5] = new Interval(40,70);
        minMeetingRooms(i);
    }

    public static List<Integer> minMeetingRooms(Interval[] intervals) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o2.end - o1.end;
                else
                    return o1.start - o2.start;
            }
        });
        //[0, 30],[0,15],[5, 10],[15, 20], [40, 50] [60, 70]
        // o(n)
        int idx = 0;
        int count = 0;
        int n = intervals.length;
        for (int i = 0; i < n;){
            int c = 1;
            Interval cur = intervals[i];
            i++;
            while (i < n){
                Interval next = intervals[i];
                if (next.start >= cur.start && next.start <= cur.end){
                    c++;
                    i++;
                }else {
                    break;
                }
            }
            if (c > count){
                count = c;
                idx = i - c;
            }
        }
        int end = idx + count;
        for (int i = idx; i < end; i++){
            res.add(i);
        }
        return res;
    }
}
