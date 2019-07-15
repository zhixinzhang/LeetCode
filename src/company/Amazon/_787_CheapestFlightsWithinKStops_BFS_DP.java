package company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/25/19
 * Time: 9:41 AM
 * Description:
 */


public class _787_CheapestFlightsWithinKStops_BFS_DP {
    public int findCheapestPrice_BFS(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0 || flights[0].length == 0)
            return -1;
        HashMap<Integer, Integer> minCost = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int level = 0;
        int min = Integer.MIN_VALUE;

        while (!q.isEmpty()){
            if (level > K)
                return min;
            int size = q.size();
            for (int i = 0; i < size; i++){
                int curFlight = q.poll();
                int[] detail = flights[curFlight];
                int end = detail[0];
                int val = detail[1];
                int prevCost = minCost.get(curFlight);
                int endCost;
                if (minCost.containsKey(end)){
                    endCost = minCost.get(end);
                    minCost.put(end, Math.min(prevCost + val, endCost));
                }else{
                    endCost = prevCost + val;
                    minCost.put(end, prevCost + val);
                }
                if (end == dst)
                    min = Math.min(min,endCost);
            }
            level++;
        }
        return -1;
    }
}
