package google.Tree;

import java.util.*;

/**
 * Created by zhang on 2018/7/8.
 * dfs uf BFS **** 无向图 遍历 删除之前的 UF最好
 */
public class _261_GraphValidTree_DFS_BFS_UF {
    public static boolean validTree_DFS_Back(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] g : edges){
            hm.putIfAbsent(g[0], new HashSet<Integer>());
            hm.putIfAbsent(g[1], new HashSet<Integer>());
            hm.get(g[0]).add(g[1]);
            hm.get(g[1]).add(g[0]);
        }
        if(dfs(0,n,hm,visited) && visited.size() == n)
            return true;
        return false;
    }
    public static boolean dfs(int curNode, int n, HashMap<Integer, HashSet<Integer>> hm, HashSet<Integer> visited){
        if(visited.size() == n) return true;
        if(visited.contains(curNode))   return false;
        visited.add(curNode);
        HashSet<Integer> nextL = hm.get(curNode);
        if (nextL == null)  return true;
        for(int i : nextL){
            if(i == curNode)
                continue;
            hm.get(i).remove(curNode);
            if(!dfs(i,n,hm,visited))
                return false;
        }
        return true;
    }
    public static boolean validTree_DFS_Stack(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] g : edges){
            hm.putIfAbsent(g[0], new HashSet<Integer>());
            hm.putIfAbsent(g[1], new HashSet<Integer>());
            hm.get(g[0]).add(g[1]);
            hm.get(g[1]).add(g[0]);
        }
        Stack<Integer> s = new Stack<>();
        s.add(0);
        while(s.isEmpty()){
            int curNode = s.pop();
            if (visited.contains(curNode))
                return false;
            visited.add(curNode);
            for (int i : hm.get(curNode)){
                s.push(i);
                hm.get(i).remove(curNode);
            }
        }
        if (visited.size() != n)
            return false;
        return true;
    }

    public static boolean BFS_Queue(int n, int[][] edges){
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] g : edges){
            hm.putIfAbsent(g[0], new HashSet<Integer>());
            hm.putIfAbsent(g[1], new HashSet<Integer>());
            hm.get(g[0]).add(g[1]);
            hm.get(g[1]).add(g[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curNode = q.poll();
            if(visited.contains(curNode))
                return false;
            visited.add(curNode);
            for(int i : hm.get(curNode)){
                q.add(i);
                hm.get(i).remove(curNode);
            }
        }
        if (visited.size() != n)
            return false;
        return true;
    }

    static int[] father;
    public static boolean ufs(int n, int[][] edges){
        father = new int[n];
        for (int i = 0; i<n; i++){
            father[i] = i;
        }
        int i = 0;
        for (int[] e : edges){
            i++;
            int a = e[0];
            int b = e[1];
            int pa = find(e[0],father);
            int pb = find(e[1],father);
            if(pa == pb)
                return false;
            father[pb] = pa;
        }
        if (i != n-1)
            return false;
        return  true;
    }
    public static int find(int a, int[] father){
        while (a != father[a]){
            father[a] = father[father[a]];
            a = father[a];
        }
        return a;
    }

    public static void main(String[] args){
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
//        int[][] edges = new int[][]{{1,0}};
//        validTree_DFS_Back(5,edges);
        ufs(5,edges);
    }
}
