package google.Graph;

import java.util.*;

/**
 * Created by zhang on 2018/7/30.
 *
 * Rebuild array: given a list of subsequences of an original array, rebuild a shortest unique original array by using the list of subsequence..本文原创自1point3acres论坛
 e.g., given [[1, 9, 7], [1, 4], [4, 9]], the shortest unique original array is [1, 4, 9, 7]
 . more info on 1point3acres
 Follow up: the original array may contain duplicates, return shortest smallest lexicographical order array if multiple arrays can be reconstructed.
 e.g.,given [[2, 3], [3, 3, 3]], return [2, 3, 3, 3], 虽然[3, 2, 3, 3], [3, 3, 2, 3]也可以build, 但不是最小。

 http://www.1point3acres.com/bbs/thread-435726-1-1.html
 */
public class rebuildArray {
    public static void main(String[] args){
        List<int[]> edge = new ArrayList<>();
        edge.add(new int[]{1,4,6,8});
        edge.add(new int[]{2,4,5,9});
        edge.add(new int[]{5,7,8});
        solu(edge);
    }
    /**
     *  1  -  9  -  7
     *    \  /
     *     4
     * 1 - 9 4
     *
     * **/
    public static void solu(List<int[]> arr){
        // build graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegerMap = new HashMap<>();
        for (int i = 0; i<arr.size(); i++){
            int[] cur = arr.get(i);
            for (int j = 0; j <cur.length; j++){
//                if (indegerMap.containsKey(cur[j])){
//                    int count = indegerMap.get(cur[j])+1;
//                    indegerMap.put(cur[j],count);
//                }else{
                indegerMap.putIfAbsent(cur[j],0);
//                }
                if (j+1 < cur.length && indegerMap.containsKey(cur[j+1])){
                    int count = indegerMap.get(cur[j+1])+1;
                    indegerMap.put(cur[j+1],count);
                }else if (j+1 < cur.length){
                    indegerMap.put(cur[j+1],1);
                }
                graph.putIfAbsent(cur[j], new ArrayList<>());
                if (j < cur.length-1 && !graph.get(cur[j]).contains(cur[j+1]))
                    graph.get(cur[j]).add(cur[j+1]);
            }
        }
        // indeger = 0;
        List<Integer> indeger = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> map : indegerMap.entrySet()){
            if (map.getValue() == 0){
                pq.add(map.getKey());
                indeger.add(map.getKey());
            }
        }
        int[] res = new int[indegerMap.size()];
        res = topo(pq,graph,indegerMap,0,res);
        System.out.println(res);
    }
    public static int[]  topo(PriorityQueue<Integer> pq, HashMap<Integer, List<Integer>> graph,HashMap<Integer, Integer> indegerMap,
                     int index, int[] res){
        if (pq.isEmpty() && index == res.length-1)
            return res;
        int cur = pq.poll();
        res[index] = cur;
        List<Integer> child = graph.get(cur);
        for (int i : child){
            int c = indegerMap.get(i);
            if (c == 1){
                pq.add(i);
                indegerMap.remove(i);
            }
            else
                indegerMap.put(i,c-1);
        }
        res = topo(pq,graph,indegerMap,index+1,res);
        return res;
    }
}
