package google;

import java.util.*;
import java.util.Comparator;

/**
 * Created by zhang on 2018/5/29.
 *
 * https://leetcode.com/problems/meeting-rooms-ii/solution/
 */
public class _253_MeetingRooms2 {

    public static void main(String[] args){
        int[][] intervals = new int[][]{
            {0,30},{5,10},{15,20}, {11,14}, {19, 25}
            };
        minMeetingRooms(intervals);
    }

    public static int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> ();

        Arrays.sort (intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty () && interval[0] >= minHeap.peek ()) {
                minHeap.poll ();
            }

            minHeap.add(interval[1]);
        }

        return minHeap.size ();
    }


     public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
  //[0,30] [2,10] [5,8] [15 20] [25 28]
  // 考虑特殊情况 【4，9】【4，17】【9，10】重点是 排序的时候 end结尾要先算 因为我写的方法不先算有bug
    //所以排序很重要
  /** we  need to find most conflict time
   * 0                                  30
   *    2      10
   *      5  8
   *                  15     20
   *                              25  28
   *  0 2 5 +1
   *
   *
   * */
    public static int minMeetingRooms(Interval[] intervals) {
        int res = 0 ;
//        Arrays.sort(intervals,(a,b) -> a.start - b.start);
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        for (Interval i : intervals){
            pq.add(new int[]{i.start, 1});
            pq.add(new int[]{i.end, -1});
        }
        int max = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            res += cur[1];
            max = Math.max(res,max);
        }
        return max;
    }
    // 第二种解法
    public static int minMeetingRooms_Sort(Interval[] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i<intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int cur = 0;
        int res = 0;
        for(int i = 0,j = 0; i<start.length;){
            if(start[i] < end[j]){
                cur++;
                res = Math.max(cur,res);
                i++;
            }else{
                cur--;
                j++;
            }
        }

        return res;
    }


    public int minMeetingRooms_TreeMap(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval itl : intervals) {
            map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
            map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
        }
        int room = 0, k = 0;
        for (int v : map.values())
            k = Math.max(k, room += v);

        return k;
    }

//    public static void main(String[] args){
//        Interval i = new Interval(9,10);
//        Interval i2 = new Interval(4,9);
//        Interval i3 = new Interval(4,17);
//        Interval[] l = new Interval[]{i,i2,i3};
//        minMeetingRooms(l);
//    }
}
