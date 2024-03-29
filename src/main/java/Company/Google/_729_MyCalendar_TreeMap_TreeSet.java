package Company.Google;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by zhang on 2018/5/19.
 */
// TreeSet 是O(logn) 时间复杂度
public class _729_MyCalendar_TreeMap_TreeSet {
    TreeSet<int[]> treeSet;
    public _729_MyCalendar_TreeMap_TreeSet() {
        treeSet = new TreeSet<>((a,b) -> (a[0] - b[0]));      // maxtree
    }
    //logn
    public boolean book(int start, int end) {
        if(start >= end)    return false;
        int[] event = new int[]{start,end};
        int[] low_start = treeSet.floor(event); //向下取整
        int[] highr_end = treeSet.ceiling(event);// 向上取整
        if(low_start == null || low_start[1] > start)   return false;
        if (highr_end == null || highr_end[0] < end) return false;
        treeSet.add(event);
        return true;
    }

    List<int[]> l = new ArrayList<>();
    public boolean boo(int start, int end){
        int[] event = new int[]{start,end}; //
        for (int i = 0; i<l.size(); i++){
            int[] cur = l.get(i);       //cur [10, 20)    event [5,15)
            if (cur[0] < event[0] && cur[0] > event[1]){
                return false;
            }else if (cur[0] > event[0] && cur[0] < event[1]){
                return false;
            }
        }
        l.add(event);
        return true;
    }

    static TreeMap<Integer, Integer> time = new TreeMap<>();

    public static void main(String[] args){
        solu_TreeMap(20, 30);
        solu_TreeMap(35, 45);
        solu_TreeMap(22, 36);
    }
    public static boolean solu_TreeMap(int start, int end){
            Integer floorKey = time.floorKey(start);
            Integer ceilingKey = time.ceilingKey(start);

            if(floorKey != null && time.get(floorKey) > start)
                return false;

            if (ceilingKey != null && ceilingKey < end)
                return false;

            time.put(start, end);
            return true;
        }
}
