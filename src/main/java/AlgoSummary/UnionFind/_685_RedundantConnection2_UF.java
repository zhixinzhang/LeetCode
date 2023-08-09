package Algo_Summary.UnionFind;

import java.util.Arrays;

/**
 * In Directed Graph there can be 3 cases.
  1. Node with 2 parents
  2. Cycle
  3. Cycle + Node with 2 parents

So what we can do is we will first calculate indegrees of
all nodes and if at any node we get 2 indegree count then
one of the two edges coming to that node are potential edges
which are causing 2 Parent problem. So we can ignore one of
the edges and apply Disjoint Set Union and see if the 
ignored edge is the right choice or the other one and 
meanwhile we can get a case where there is only cycle problem
like case 2, so in that case we will just return that current edge    
 * 
 * 
*/
public class _685_RedundantConnection2_UF {
    int[] parent;
    int[] rank;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        Arrays.fill(inDegree, -1);
        int potential1 = -1;
        int potential2 = -1;

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(inDegree[v] == -1){
                inDegree[v] = i;
            }
            else {
                potential1 = i;
                potential2 = inDegree[v];
                break;
            }
        }

        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0; i < edges.length; i++){
            if(i == potential1)
                continue;
            int u = edges[i][0];
            int v = edges[i][1];
            boolean flag = union(u, v);
            if(flag == true){
                if(potential1 == -1)
                    return edges[i]; // cycle is present
                else
                    return edges[potential2]; // cycle + 2 parents 
            }
        }
        return edges[potential1]; // 2 parents       
    }
    public int find(int node){
        if(node == parent[node])
            return node;
        return parent[node] = find(parent[node]);
    }
    public boolean union(int a, int b){
        int pA = find(a);
        int pB = find(b);
        if(pA == pB)
            return true;
        if(rank[pA] > rank[pB])
            parent[pB] = pA;
        else if(rank[pB] > rank[pA])
            parent[pA] = pB;
        else {
            parent[pB] = pA;
            rank[pA]++;
        }
        return false;
    }
}
