package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2017/12/7.
 */
//  https://www.youtube.com/watch?v=vsIb9B84Rt8
// space O(n)  time O(edges * nodes)
// https://leetcode.com/problems/graph-valid-tree/solutions/2030600/java-union-find-bfs-dfs/
public class _261_GraphValidTree_BFS_UNF {
    private int[] rank;
    private int[] root;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        rank = new int[n];
        root = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
        
        for (int[] edge: edges) {
            if(isConnected(edge[0], edge[1])) {
                return false;
            }
            union(edge[0], edge[1]);
        }
        return true;
    }
    
    
    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX] ++;
            }
        }
    }

    // DFS
    // Use toAdjecent function to convert edges to adjecent list.
    // Since we only need to check whether all nodes are connected(based on edges.length == n - 1), 
    // we use a set seen to track the nodes that we have connected. After DFS, we only need to check if we have visited all nodes, 
    // i.e. seen.size() == n.
    public boolean validTree_DFS(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> adj = toAdjecent(n, edges);
        DFS(adj, seen, 0);
        return seen.size() == n;
    }
    
    public List<List<Integer>> toAdjecent(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
    
    public void DFS(List<List<Integer>> adj, Set<Integer> seen, int curr) {
        if (seen.contains(curr)) {
            return;
        }
        seen.add(curr);
        for (int i: adj.get(curr)) {
            DFS(adj, seen, i);
        }
    }


    // BFS
    public boolean validTree_BFS(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> adj = toAdjecent(n, edges);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        seen.add(0);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i: adj.get(curr)) {
                if (!seen.contains(i)) {
                    queue.offer(i);
                    seen.add(i);
                }
            }
        }
        return seen.size() == n;
        
    }
    
    public List<List<Integer>> toAdjecent(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}
