package google;

import java.util.*;

/**
 * Created by zhang on 2018/5/30.
 * 用union find 不能用bfs
 * 无向图
 */
public class _684_RedundantConnection {
        public static int[] findRedundantConnection_UnionFind(int[][] edges) {
            //[[1,2], [2,3], [3,4], [1,4], [1,5]]
            // 0 1 2 3 4 5
            // 0 2 2 3 4 5
            // 0 2 3 3 4 5
            // 0 2 3 4 4 5
            // 0
            // 1 2 4 5
            // 2 1 3
            // 3 2 4
            // 4 1 3
            int[] parents = new int[edges.length+1];
            for(int i=1;i<=edges.length;i++) parents[i] = i;

            for (int[] edge : edges){
                int pa = getParent(parents, edge[0]);
                int pb = getParent(parents, edge[1]);
                if (pa == pb)
                    return edge;
                parents[pa] = pb;
            }
            return new int[2];
        }
        // 0 2 3 4 4 5    [1,5]
        private static int getParent(int[] parents, int son){
            if (parents[son] == son)
                return son;
            parents[son] = getParent(parents,parents[son]);
            return parents[son];
        }
        public static int[] findRedundantConnection(int[][] edges) {
            int[] res = new int[2];
            // find circle
            //[[1,2], [2,3], [3,4], [1,4], [1,5]]
            // 1 2 4 5
            // 2 1 3
            // 3 2 4
            // 4 1 3
            HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
            for (int[] i : edges){
                if (!graph.containsKey(i[0])){
                    graph.put(i[0],new ArrayList<>());
                }
                graph.get(i[0]).add(i[1]);
                if (!graph.containsKey(i[1])){
                    graph.put(i[1],new ArrayList<>());
                }
                graph.get(i[1]).add(i[0]);
            }
            for (int[] i : edges){
                if (bfs(i,graph))
                    return i;
            }
            return res;
        }
        private static boolean bfs(int[] edge, HashMap<Integer, ArrayList<Integer>> graph){
            Queue<Integer> q = new LinkedList<>();
            q.add(edge[0]);
            HashSet<Integer> hs = new HashSet<>();
            hs.add(edge[0]);
            int level = 1;
            while (!q.isEmpty()){
                int size = q.size();
                for (int i = 0; i<size; i++){
                    int node = q.poll();
                    List<Integer> edgeList = graph.get(node);
                    for (int j = 0; j<edgeList.size(); j++){
                        if (edgeList.get(j) == edge[1] && level != 1){
                            return true;
                        }
                        if (!hs.contains(edgeList.get(j))){
                            q.add(edgeList.get(j));
                            hs.add(edgeList.get(j));
                        }
                    }
                }
                level++;
            }
            return false;
        }
        public static void main(String[] args){
            findRedundantConnection_UnionFind(new int[][]{
                    {1,2}, {2,3}, {3,4}, {1,4}, {1,5}
            });
        }
    }
