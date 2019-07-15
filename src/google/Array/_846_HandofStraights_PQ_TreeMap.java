package google.Array;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by zhang on 2018/8/2.
 */
public class _846_HandofStraights_PQ_TreeMap {
    public boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : hand){
            minHeap.add(i);
        }
        while(minHeap.size() != 0) {
            int start = minHeap.poll();
            for(int j = 1; j < W; j++){
                if(minHeap.remove(start + j)) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

//    public boolean isNTreeMap(int[] hand, int w){
//        TreeMap<DataStructure.Integer, DataStructure.Integer> map = new TreeMap<>();
//        for(int i : hand){
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//    }
}
