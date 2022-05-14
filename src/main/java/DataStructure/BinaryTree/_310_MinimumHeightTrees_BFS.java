package DataStructure.BinaryTree;
import java.util.*;

/**
 * Created by zhang on 2018/5/1.
 */
/***
 * https://www.youtube.com/watch?v=-Tk52eP5n3c
 *  BFS 找最小树高度 就是一层层把所有子节点删除
 * 0 : 3
 * 1 : 3
 * 2 : 3
 * 3 : 0 1 2 4
 * 4 : 3 5
 * 5 : 4
 *
 * */
public class _310_MinimumHeightTrees_BFS {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        // build graph
        List<HashSet<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n;i++){
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges){               // undirected graph 边加两次
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // remove leaf node
        for(int i = 0; i<n; i ++){
            if (adj.get(i).size() == 1){
                res.add(i);
//                adj.remove(adj.get(i));
            }
        }
        while (n > 2){
            n -= res.size();
            List<Integer> leaves = new ArrayList<>();
            for (int i : res){
                for (int j : adj.get(i)){
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1){
                        leaves.add(j);
                    }
                }
            }
            res = leaves;
        }
        return res;
    }
    //n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
    public  static void main(String[] args){
        findMinHeightTrees(6,new int[][]{{0,3},{1,3},{2,3},{4,3},{5,4}});
    }
}
