package Company.Turo;

import java.util.Arrays;
import java.util.Comparator;

public class _435_NonOverlappingIntervals_ArraySort {
    public static void main(String[] args){
        // eraseOverlapIntervals(new int[][]{{1,100}, {11,22}, {1, 11}, {2, 12}});
        eraseOverlapIntervals_OnlysortStart(new int[][]{{1,100}, {11,22}, {1, 11}, {2, 12}});
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare (int[] e1, int[] e2){
                if (e1[1] != e2[1]) {
                    return e1[1] - e2[1];    //first sort by end
                } else {
                    return e2[0] - e1[0];   // //second sort by start
                }
            }
        });
        // {1,11}, {2,12}, {11, 22}, {1, 100}
        int ans = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if (cur[0] >= end) {
                end = cur[1];
            } else {
                ans++; 
            }
        }
        
        return ans;
    }

    // [1, 11], [2, 12] 有overlap 的时候 删除后面的
    public static int eraseOverlapIntervals_OnlysortStart(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0] );
        int[] pre=intervals[0];
        int res=0;
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            if(cur[0]<pre[1]){ //overlapping
                res++;
                if(pre[1]<=cur[1])
                    continue;
            }
            pre=cur;
        }
        return res;
    }
}
