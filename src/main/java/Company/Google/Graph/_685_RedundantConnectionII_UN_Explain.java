package Company.Google.Graph;

import java.util.HashMap;

/**
 * Created by zhang on 2018/6/15.
 * * Created by zhang on 2017/12/7.
 * https://www.youtube.com/watch?v=760I9vw7uA0
 *  * 1. 有2个parent节点，无环
 * 2. 只有环
 * 3. 有2个parent节点，有环
 *         <-------\
 *     4 -- > 2 -- > 1
 *                 /
 *              3
 *  input 4 -> 2  2 - >1   3 ->1   1->4
 */
public class _685_RedundantConnectionII_UN_Explain {
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return new int[2];
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>(); // 2 - > 1   key 1 val 2
        int[] p1 = new int[]{-1,-1};
        int[] p2 = new int[]{-1,-1};
        for (int[] edge : edges){  // 3 -- > 1
            if (hm.containsKey(edge[1])){
                p2[0] = edge[0];
                p2[1] = edge[1];
                p1[0] = hm.get(edge[1]);
                p1[1] = edge[1];
            }
            hm.put(edge[1],edge[0]); // 1  3
        }
        int[] father = new int[edges.length + 1];
        for (int i = 1; i < father.length; i++) father[i] = i;
        if (p1[0] != -1){
            int[] cur = findCircle(father,edges,p2);
            if (cur[0] == -1){
                return p2;
            }else{
                return p1;
            }
        }else{
            res = findCircle(father,edges,new int[]{-1,-1});
        }
        return res;
    }
    public static int[] findCircle(int[] father, int[][]edges, int[] removeEdge){
        for (int[] edge : edges){
            if (edge[0] == removeEdge[0] && edge[1] == removeEdge[1])
                continue;
            int fatherA = find(edge[0],father);
            int fatherB = find(edge[1],father);
            if (fatherA == fatherB)
                return edge;
            father[fatherA] = fatherB;
        }
        return new int[]{-1,-1};
    }
    public static int find(int a, int[] father){
        while (a != father[a]){
            father[a] = father[father[a]];
            a = father[a];
        }
        return a;
    }

    public static void main(String[] args){
//        findRedundantDirectedConnection(new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}});
//        findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
        findRedundantDirectedConnection(new int[][]{{1,2},{1,3},{2,3}});

    }
}
