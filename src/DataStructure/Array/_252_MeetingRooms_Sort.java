package DataStructure.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Luke Zhang
 * @Date 2021-04-28 18:30
 */
public class _252_MeetingRooms_Sort {
    public static void main(String[] args){
        canAttendMeetings(new int[][] {{0, 30}, {5, 10}, {15, 20}});
    }
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if (cur[1] <= prev[1] || prev[1] > cur[0])
                return false;
            prev = cur;
        }
        return true;
    }
}
