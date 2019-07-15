package DataStructure.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


/**
 * Created by zhang on 2017/10/13.
 */
/*重写了一个方法  compare
* */
public class _57_InsertInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null)
            return intervals;

        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);            }
        });

        for(int i = 0;i<intervals.size();i++){
            if (i+1<intervals.size()){
                Interval i1 = intervals.get(i);
                Interval i2 = intervals.get(i+1);
                if(i1.end >= i2.start){
                    if(i2.end >= i1.end){
                        i1.end = i2.end;
                    }
                    if(i1.start >= i2.start){
                        i1.start = i2.start;
                    }
                    intervals.remove(i+1);
                    i--;
                }
            }
        }
        return intervals;
    }



    public  static  void main(String args[]){
        int [] nums = {1,2,3,5,6,7,8,10,12,16};
        int [] nums2 = {4,9};

        List<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i<nums.length;i=i+2){
            if (i+1<nums.length){
                Interval in = new Interval();
                in.start = nums[i];
                in.end = nums[i+1];
                intervalList.add(in);
            }
        }
        Interval interval = new Interval(nums2[0],nums2[1]);

        insert(intervalList,interval);
    }
}
