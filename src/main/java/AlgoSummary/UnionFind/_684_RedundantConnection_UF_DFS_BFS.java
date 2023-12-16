package AlgoSummary.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _684_RedundantConnection_UF_DFS_BFS {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                return edge;
        }
        return null;
    }
}

class UnionFind {

    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find (int n) {
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    } 
    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2); 
        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1] += 1;
        }
        return true;
    }

    /****** BFS *******/
    public int[] findRedundantConnection(int[][] edges) {
        
        //BFS SOLUTION
        
        List<List<Integer>>adj = new ArrayList<>();
        int V = edges.length;
        
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for(int edge[] : edges)
        {
            int src = edge[0]-1;
            int dest = edge[1]-1;
        
            adj.get(src).add(dest);
            adj.get(dest).add(src);

            if(isCyclic(adj,src))
                return edge;
        }
        
        return new int[]{};
    }
    
    public boolean isCyclic(List<List<Integer>> adj, int src)
    {
        boolean[] visited=new boolean[adj.size()];
        
        return (isCyclicutil(adj,visited,src));    
    }
    
    public boolean isCyclicutil(List<List<Integer>> adj, boolean[] visited, int src) //par is the parent of source
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(src); 

        while(!q.isEmpty())
        {
            int top=q.poll();
            
            if(visited[top])
                return true;
                
            visited[top]=true;
            
            for(int v : adj.get(top))
            {
                if(!visited[v])
                    q.add(v);
            }
        }
        
        return false;
    }


    /******** DFS *******/
    boolean[] visited;

    public int[] findRedundantConnection_DFS(int[][] edges) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < edges.length; i++){
            hashMap.put(i + 1, new ArrayList<>());
        }

        int[] res = new int[2];
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            visited = new boolean[edges.length + 1];
            if(!hashMap.get(edge[0]).isEmpty() && !hashMap.get(edge[1]).isEmpty() && dfs(edge[0], edge[1], hashMap)){
                return edge;
            }
            hashMap.get(edge[0]).add(edge[1]);
            hashMap.get(edge[1]).add(edge[0]);
        }
        return res;
    }

    public boolean dfs(int src, int target, HashMap<Integer, List<Integer>> hashMap){
        if(src == target){
            return true;
        }
        visited[src] = true;
        List<Integer> edgeList = hashMap.get(src);

        for(Integer next: edgeList){
            if(!visited[next]){
                if(dfs(next, target, hashMap)){
                    return true;
                }
            }
        }

        return false;
    }
}
