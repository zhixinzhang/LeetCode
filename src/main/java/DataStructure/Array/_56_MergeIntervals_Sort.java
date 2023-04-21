package DataStructure.Array;
import java.util.*;


/**
 * Created by zhang on 2021/4/13.
 */
public class _56_MergeIntervals_Sort {
    public static void main(String[] args){

        int[][] intervals = new int[][]{
                {1,4},{4,5}
        };
        merge(intervals);
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){       // [1, 7], [2, 4], [1, 7], [2, 8]
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            int[] arr = intervals[i];
            if (prev[1] >= arr[0]) {
                prev[1] = Math.max(arr[1], prev[1]);
            } else {
                res.add(prev);
                prev = arr;
            }

            if (i == intervals.length - 1) {
                res.add(prev);
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}
