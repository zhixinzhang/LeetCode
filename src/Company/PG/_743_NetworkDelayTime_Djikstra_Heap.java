package Company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/28.
 * There are N network nodes, labelled 1 to N.
 Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1
 */
//solution
    /**It is a direct graph.
     Use Map<DataStructure.Integer, Map<DataStructure.Integer, DataStructure.Integer>> to store the source node, target node and the distance between them.
     Offer the node K to a PriorityQueue.
     Then keep getting the closest nodes to the current node and calculate the distance from the source (K) to this node (absolute distance). Use a Map to store the shortest absolute distance of each node.
     Return the node with the largest absolute distance.
     * */
public class _743_NetworkDelayTime_Djikstra_Heap {
    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times.length == 0){
            return -1;
        }
        // store the source node as key. The value is another map of the neighbor nodes and distance.
        Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
        for(int[] time : times){
            Map<Integer, Integer> sourceMap = path.get(time[0]);
            if(sourceMap == null){
                sourceMap = new HashMap<>();
                path.put(time[0], sourceMap);
            }
            Integer dis = sourceMap.get(time[1]);
            if(dis == null || dis > time[2]){
                sourceMap.put(time[1], time[2]);
            }

        }

        //Use PriorityQueue to get the node with shortest absolute distance
        //and calculate the absolute distance of its neighbor nodes.
        Map<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(K, 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {return i1[1] - i2[1];});
        pq.offer(new int[]{K, 0});
        int max = -1;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int distance = cur[1];

            // Ignore processed nodes
            if(distanceMap.containsKey(node) && distanceMap.get(node) < distance){
                continue;
            }

            Map<Integer, Integer> sourceMap = path.get(node);
            if(sourceMap == null){
                continue;
            }
            for(Map.Entry<Integer, Integer> entry : sourceMap.entrySet()){
                int absoluteDistence = distance + entry.getValue();
                int targetNode = entry.getKey();
                if(distanceMap.containsKey(targetNode) && distanceMap.get(targetNode) <= absoluteDistence){
                    continue;
                }
                distanceMap.put(targetNode, absoluteDistence);
                pq.offer(new int[]{targetNode, absoluteDistence});
            }
        }
        // get the largest absolute distance.
        for(int val : distanceMap.values()){
            if(val > max){
                max = val;
            }
        }
        return distanceMap.size() == N ? max : -1;
    }
}
