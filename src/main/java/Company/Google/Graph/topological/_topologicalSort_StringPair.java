package Company.Google.Graph.topological;

import java.util.*;

/**
 * Created by zhang on 2018/8/7.
 */
public class _topologicalSort_StringPair {
    public static List<String> find(String[][] pair){
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String[] p : pair){
            graph.putIfAbsent(p[0], new ArrayList<>());
            graph.putIfAbsent(p[1],new ArrayList<>());
            graph.get(p[0]).add(p[1]);
        }
        LinkedList<String> res = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        Stack<String> stack = new Stack<>();
        for (Map.Entry<String, List<String>> m : graph.entrySet()){
            String key = m.getKey();
            if (!vis.contains(key)){
                stack.push(key);
                dfs(key,vis,res,stack,graph);
            }
        }
        return res;
    }

    public static void dfs(String key, HashSet<String> vis, LinkedList<String> res, Stack<String> stack,
                           HashMap<String, List<String>> graph){
        List<String> child = graph.get(key);
        vis.add(key);
        for (String s : child){
            if (!vis.contains(s)){
                stack.push(s);
                dfs(s,vis,res,stack,graph);
            }
        }
        String s = stack.pop();
        res.addFirst(s);
    }
    public static void main(String[] args){
        find(new String[][]{{"A","C"},{"B","C"},{"C","D"},{"D","E"},{"E","F"}
    ,{"E","G"},{"G","H"},{"F","M"}});
    }
}
