package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=387439&ctid=201324
 */
// 类似451 但是可以451 可以做到O（n） 用到bucket sort思想。这题不行
public class SortArray {
    //[1,2,1,1,1,2,3]
    /** 1 -> 4
     *  2 -> 2
     *  3 -> 1
     *  4 -> 1
     * */
    public static void main(String[] args){
        sortArray_HM_PQ(new int[]{1,2,1,1,1,2,4,3});
    }

// O(n * log m)
    public static int[] sortArray_HM_PQ(int[] arr){
        int[] res = new int[arr.length];
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++){
            hm.putIfAbsent(arr[i],0);
            int cur = hm.get(arr[i]);
            cur++;
            hm.put(arr[i],cur);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o2[0] - o1[0];
            }
        });

        for (int i : hm.keySet()){
            // i is num
            int[] cur = new int[]{hm.get(i),i};
            pq.add(cur);
        }
        int i = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int num = cur[0];
            int range = i + num;
            for (; i < range; i++){
                res[i] = cur[1];
            }
            int a = 0;
        }
        return res;
    }
}
