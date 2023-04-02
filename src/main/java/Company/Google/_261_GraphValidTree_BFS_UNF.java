package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2017/12/7.
 */
//  https://www.youtube.com/watch?v=vsIb9B84Rt8
// space O(n)  time O(edges * nodes)
    //https://leetcode.com/problems/graph-valid-tree/discuss/69078/AC-Java-solutions:-Union-Find-BFS-DFS
public class _261_GraphValidTree_BFS_UNF {
    /**  01   05  12   23    13    14
     *                 4
     *                |
     *          0 -- 1 -- 2
     *                \  /
     *                 3
     *   0    1   2   3   4
     *  -1  -1  -1  -1  -1
     *  1   -1                  // 01
     *  1   2                   // 02
     *  1   2   3               // 23
     *  1   2   3                // 13       find(1) find (3)  x  3   y   3
     *
     * **/


    public static boolean validTree_UF(int n, int[][] edges){
//        if (n < 1 || edges.length-1 != n) return  false;
        int[] roots = new int[n];
        for (int i = 0; i<n;i++){                   //inital roots -1
            roots[i] = -1;
        }
        for (int[] pair : edges){
            int x = find(pair[0],roots);
            int y = find(pair[1],roots);
            if (x == y)
                return false;
            roots[x] = y;
        }
        return true;
    }
    private static int find(int i, int[] roots){
        while (roots[i] != -1){
            i = roots[i];
        }
        return i;
    }



    public boolean validTree_DFS(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean res = dfs(graph,visited,0,-1);
        if (res == false)
            return false;
        return visited.size() == n ? true : false;
    }
    private boolean dfs (List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent){
        List<Integer> sub = graph.get(node);
        for (int v : sub){
            if (v == parent)
                continue;
            if (visited.contains(v))
                return false;
            visited.add(v);
            boolean res = dfs(graph,visited,v,node);
            if (res == false)
                return false;
        }
        return true;
    }

    public boolean validTree_BFS(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<2; j++) {
                Set<Integer> pairs = graph.get(edges[i][j]);
                if (pairs == null) {
                    pairs = new HashSet<>();
                    graph.put(edges[i][j], pairs);
                }
                pairs.add(edges[i][1-j]);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        visited.add(0);
        current.add(0);
        while (!current.isEmpty()) {
            Set<Integer> next = new HashSet<>();
            for(Integer node: current) {
                Set<Integer> pairs = graph.get(node);
                if (pairs == null) continue;
                for(Integer pair: pairs) {
                    if (visited.contains(pair)) return false;
                    next.add(pair);
                    visited.add(pair);
                    graph.get(pair).remove(node);
                }
            }
            current = next;
        }
        return visited.size() == n;
    }

    public static void main(String[] args){
        int[][] edgs = {{0,1},{0,2},{0,3},{1,4}};
        validTree(5,edgs);
    }


    public static boolean validTree(int n, int[][] edges) {
        // build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // no cycle
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        while(!stack.isEmpty())
        {
            int node = stack.pop();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neighbor : graph.get(node))
            {
                stack.push(neighbor);
                graph.get(neighbor).remove(node);
            }
        }

        // fully connected
        for(boolean result : visited)
        {
            if(!result)
                return false;
        }

        return true;
    }
    public static boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int parentNode, HashSet<Integer> visited){

        HashSet<Integer> child = graph.get(parentNode);
        for (int node : child){
            // detect circle
            if(node != parentNode && visited.contains(node)){
                return false;
            }else if (node == parentNode){
                continue;
            }else {
                visited.add(node);
                boolean f = dfs(graph,node,visited);
                visited.remove(node);
                return f;
            }
        }
        return true;
    }
}
