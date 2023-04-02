package Company.Google.Tree;
import java.util.*;
/**
 * Created by zhang on 2018/6/14.
 */
public class _834_SumofDistancesinTree_DFS {
    static int[] res, count; static ArrayList<HashSet<Integer>> tree; static int n;
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        n = N;
        for(int i =0 ;i< n; ++i) tree.add(new HashSet<Integer>());
        for (int[] e : edges) {tree.get(e[0]).add(e[1]); tree.get(e[1]).add(e[0]);}
        dfs(0, new HashSet<Integer>());
        dfs2(0, new HashSet<Integer>());
        return res;
    }
    public static void dfs(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                dfs(i, seen);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        count[root]++;
    }


    public static void dfs2(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i];
                dfs2(i, seen);
            }
    }
    public static void main(String[] args){
        sumOfDistancesInTree( 6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}});
    }
}
