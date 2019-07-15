package DataStructure.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 12:35 PM
 * Description:
 * https://leetcode.com/problems/network-delay-time/solution/
 */


public class _743_NetworkDelayTime_ {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0)
            return -1;
        HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
        for (int[] time : times){
            int source = time[0], target = time[1], t = time[2];
            hm.putIfAbsent(source, new HashMap<>());
            hm.get(source).put(target, t);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1] - b[1]));
        pq.add(new int[]{K, 0});
        //记录走过的点 和最小的distance
        Map<Integer, Integer> disMap = new HashMap<>();
        disMap.put(K, 0);
        int max = -1;
        while (!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[0];
            int distance = arr[1];
            if(disMap.containsKey(node) && disMap.get(node) < distance)  continue;
            Map<Integer, Integer> map = hm.get(node);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int absoluteDistence = distance + entry.getValue();
                int nextNode = entry.getKey();
                if(disMap.containsKey(nextNode) && disMap.get(nextNode) <= absoluteDistence){
                    continue;
                }
                pq.offer(new int[]{nextNode, absoluteDistence});

                disMap.put(nextNode, absoluteDistence);
            }

        }
        // get the largest absolute distance.
        for(int val : disMap.values()){
            if(val > max){
                max = val;
            }
        }
        return disMap.size() == N ? max : -1;

    }
}
