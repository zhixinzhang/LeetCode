package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2017/12/17.
 */

public class _436_FindRightInterval_TreeMap {
    public static void main(String[] args){
        Interval[] i = new Interval[]{new Interval(1,4),new Interval(2,3),new Interval(3,4)};
        findRightInterval(i);
    }

     public int[] findRightInterval_TreeMap(Interval[] intervals) {
        int len = intervals.length;
        int nums[] = new int[len];
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i = 0; i < len; i++){
            map.put(intervals[i].start, i);
        }

        for(int i = 0; i < len; i++){
            Integer num = map.ceilingKey(intervals[i].end);
            if(num == null){
                nums[i] = -1;
            }else{
                nums[i] = map.get(num);
            }
        }
        return nums;
    }





    public static int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0 || intervals.length == 1) return new int[]{-1};
        int[] res = new int[intervals.length];
        int len = intervals.length;
        for(int i = 0 ;i<len;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                if(intervals[i].end<=intervals[j].start && j != i){
                    int dis = j - i;
                    min = Math.abs(min) > Math.abs(dis) ? dis : min;
                    int c = 0;
                }
                int c = 0;
            }
            if(min == Integer.MAX_VALUE){
                res[i] = -1;
            } else{
                res[i] = i + min;
            }
        }
        return res;
    }
}
