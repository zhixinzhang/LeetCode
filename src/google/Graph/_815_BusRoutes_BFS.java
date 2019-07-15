package google.Graph;

import java.util.*;

/**
 * Created by zhang on 2018/6/10.
 * 抽象成一个图 找最短路径 不是找最短换乘
 * 这题不难 重点是 要想到 把路线作为value  BFS经典
 *   1    2   7
 *            |
 *   3    6    7
 *       |
 *   9   6     8
 *     from 1 to 8
 *    key - value value 对应的是属于哪个路线
 *    1  -  0
 *    2 -  0
 *    7 - 0 1
 *    3 - 1
 *    6 - 1 2
 *    8 - 2
 */
public class _815_BusRoutes_BFS {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = hm.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                hm.put(routes[i][j], buses);
            }
        }
        q.add(S);
        int ret = 0;
        while (q.isEmpty()){
            ret++;
            int len = q.size();
            for (int i = 0; i<len; i++){
                int curBus = q.poll();
                List<Integer> buses = hm.get(curBus);
                for (int bus : buses){
                    if (hs.contains(bus)) continue;
                    hs.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
