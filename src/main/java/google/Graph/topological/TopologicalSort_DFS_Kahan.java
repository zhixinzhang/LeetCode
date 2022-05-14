package google.Graph.topological;

import java.util.*;

/**
 * Created by zhang on 2018/6/17.
 *Topological Sorting is ordering of vertices or nodes such if there is an edge between (u,v) then u should come before v in topological sorting. Topological sort is possible only for Directed Acyclic DataStructure.Graph(DAG).
 * If there is a cycle in graph, then there won’t be any possibility for Topological Sort.
 *
 * https://java2blog.co m/topological-sort-java/
 * https://www.youtube.com/watch?v=ddTC4Zovtbc
 */
// 拓扑排序只能在 无环有向图里可以
class TPNode{
    String s;
    List<TPNode> children;
    TPNode(String s){
        this.s = s;
        children = new ArrayList<>();
    }
}
public class TopologicalSort_DFS_Kahan {
    public static LinkedList<String> TP_Kahn(String[][] edges){
        LinkedList<String> res = new LinkedList<>();
        if (edges == null || edges.length == 0 || edges[0].length == 0) return res;
        // build top graph
        HashMap<String, TPNode> hm = new HashMap<>();
        for (String[] edge : edges){
            String l = edge[0];
            String r = edge[1];
            hm.putIfAbsent(l,new TPNode(l));
            hm.putIfAbsent(r,new TPNode(r));
        }
        for (String[] edge : edges){
            TPNode l = hm.get(edge[0]);
            TPNode r = hm.get(edge[1]);
            l.children.add(r);
        }
        List<TPNode> list = new ArrayList<>(hm.values());
        Stack<TPNode> stack = new Stack<>();
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < list.size(); i++){
            if (!visited.contains(list.get(i).s))
                dfs(list.get(i),stack,visited);
        }
        while(!stack.isEmpty()){
            System.out.println("   " + stack.pop().s);
        }
        return res;
    }
    public static void dfs(TPNode curNode, Stack<TPNode> stack, HashSet<String> visited){
        visited.add(curNode.s);
        for (int i = 0; i < curNode.children.size(); i++){
            TPNode tmp = curNode.children.get(i);
            if (!visited.contains(tmp.s))
                dfs(tmp,stack,visited);
        }
        stack.add(curNode);
    }


    public static void main(String[] args){
        String[][] edges = new String[][]{{"A","B"},{"A","C"},
                {"B","C"},{"B","D"},{"C","D"},{"F","C"}};
        TP_Kahn(edges);
    }
}
