package DataStructure.Array;
import java.util.*;

public class _659_SplitArrayintoConsecutiveSubsequences_Map_Queue{
    static private HashMap<Integer, PriorityQueue<Integer>> dmap;
    public static boolean isPossible(int[] nums) {
        dmap = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> pq0 = getOrPut(num - 1);
            int len = pq0.isEmpty() ? 0 : pq0.poll();
            PriorityQueue<Integer> pq1 = getOrPut(num);
            pq1.offer(len + 1);
        }
        for (int key : dmap.keySet()) {
            for (int len : dmap.get(key)) {
                if (len < 3) return false;
            }
        }
        return true;
    }
    public static PriorityQueue<Integer> getOrPut(int num) {
        PriorityQueue<Integer> pq = dmap.get(num);
        if (pq == null) {
            pq = new PriorityQueue<Integer>();
            dmap.put(num, pq);
        }
        return pq;
    }
    public static void main(String[] args){
        isPossible(new int[]{1,2,3,3,4,4,5,5});
    }
	
}