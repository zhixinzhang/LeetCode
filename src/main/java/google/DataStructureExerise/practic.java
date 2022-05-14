package google.DataStructureExerise;

import google.Array._56_MergeIntervals_Sort_PQ;

import java.util.*;
import java.util.Comparator;

// PQ PriorityQueue的peek()和element操作是常数时间，add(), offer(), 无参数的remove()以及poll()方法的时间复杂度都是log(N)。





/**
 * Created by zhang on 2018/6/3.
 */
public class practic {
    public void solution(){
        int a = (int) Math.sqrt(9);
        List<Integer> res = new ArrayList<Integer>();
        int cur = Integer.parseInt("20");
        /** "b r p y"
         *  "b r r y"  right pos 3  right color 1
         *   b r r c   2  1
         *
         * */
        List<String> ress = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();   // 11 abc bcd xyz
        // 取key
        for (String s : hm.keySet()){}
        for (List<String> val : hm.values()){}
        for (Map.Entry m : hm.entrySet()){}









        for (Map.Entry<String, List<String>> h : hm.entrySet()){
            String c = h.getKey();
            ress = h.getValue();
        }
        for (List<String> s : hm.values()){

        }
        for (String s : hm.keySet()){

        }
    }
    public static void main1(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->(a-b));

        for (int i = 0; i<3; i++){
            pq.add(nums[i]);
        }
        int a = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[0] != b[0]){
                    return a[0] - b[0];
                }else
                    return a[1] - b[1];
            }
        });
/**List sort 用 Collections*/
//        List<_56_MergeIntervals_Sort_PQ.Interval> intervals = new DataStructure.ArrayList<>();
//
//        Collections.sort(intervals, new Comparator<_56_MergeIntervals_Sort_PQ.Interval>() {
//            @Override
//            public int compare(_56_MergeIntervals_Sort_PQ.Interval o1, _56_MergeIntervals_Sort_PQ.Interval o2) {
//                if (o1.start != o2.start)
//                    return o1.start - o2.start;
//                else
//                    return o1.end - o2.end;
//            }
//        });

        List<String> aa = new ArrayList<>();
        List<String> c = new ArrayList<>();

        HashSet<String> hs = new HashSet<>();
        for (Iterator<String> its = hs.iterator(); its.hasNext();){
                String cc = its.next();
        }

        int[][] grid = new int[10][10];
        Arrays.sort(grid, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });


    }
    public static void main(String[] args){
        int i = 8;
        int c = -i;
        i -= (i & -i);
        int a = 0;

    }
}
