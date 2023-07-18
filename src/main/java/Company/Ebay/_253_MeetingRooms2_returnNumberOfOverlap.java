package Company.Ebay;

import java.util.*;
import java.util.Comparator;

/**
 * Created by zhang on 2018/5/29.
 *
 * https://leetcode.com/problems/meeting-rooms-ii/solution/
 */
public class _253_MeetingRooms2_returnNumberOfOverlap {
    /**
     *          0                                        30
     *               5     10
     *                               15     20
     *                        11  14
     *                                    19        25   
*/
    public static void main(String[] args){
        int[][] intervals = new int[][]{{0,30}, {5,10}, {15,20}, {11,14}, {19, 25}};
        minMeetingRooms(intervals);
        minMeetingRooms_sweepline_PQ(intervals);
        minMeetingRooms_TreeMap(intervals);
        minMeetingRooms_followup(intervals);
    }

    public static int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> ();

        Arrays.sort (intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty () && interval[0] >= minHeap.peek()) {
                minHeap.poll ();
            }

            minHeap.add(interval[1]);
        }

        return minHeap.size ();
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
    public static int minMeetingRooms_sweepline_PQ(int[][] intervals) {
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

        for (int[] inter : intervals){
            pq.add(new int[]{inter[0], 1});
            pq.add(new int[]{inter[1], -1});
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
    public static int minMeetingRooms_sweepline_ArraySort(int[][] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
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


    public static int minMeetingRooms_TreeMap(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] itl : intervals) {
            map.put(itl[0], map.getOrDefault(itl[0], 0) + 1);
            map.put(itl[1], map.getOrDefault(itl[1], 0) - 1);
        }
        int room = 0, k = 0;
        for (int v : map.values())
            room += v;
            k = Math.max(k, room);

        return k;
    }


    /***** follow up   ********/
    public static List<Integer> minMeetingRooms_followup(int[][] intervals) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });
        //[0, 30],[0,15],[5, 10],[15, 20], [40, 50] [60, 70]
        // o(n)
        int idx = 0;
        int count = 0;
        int n = intervals.length;
        for (int i = 0; i < n;){
            int c = 1;
            int[] cur = intervals[i];
            i++;
            while (i < n){
                int[] next = intervals[i];
                if (next[0] >= cur[0] && next[0] <= cur[1]){
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
