package Company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/3/19
 * Time: 7:58 PM
 * Description:
 */


public class _261_GraphValidTree_DFS_BFS {
    public boolean judgeTree(List<List<String>> edges){
        if (edges == null || edges.size() == 0) return true;
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> indeeger = new HashMap<>();
        HashSet<String> nodes = new HashSet<>();
        for (List<String> edgeList : edges){
                String es = edgeList.get(0), et = edgeList.get(1);
                graph.putIfAbsent(es, new ArrayList<>());
                graph.get(es).add(et);
                indeeger.put(et, indeeger.getOrDefault(es, 0) + 1);
                nodes.add(es);
                nodes.add(et);
        }
        for (Map.Entry<String, Integer> entry : indeeger.entrySet()){
            if (entry.getValue() != 0)
                nodes.remove(entry.getKey());
        }

        if (nodes.size() != 1) return false;
        String root = "";
        for (String s: nodes) {
            root = s;
        }
        Queue<String> q = new ArrayDeque<>();
        q.add(root);
        HashSet<String> visited = new HashSet<>();
        visited.add(root);
        while (q.isEmpty()){
            String node = q.poll();
            List<String> children = graph.get(node);
            for (String s : children){
                q.add(s);
                if (!visited.add(s)){
                    return false;
                }
            }
        }
        if (visited.size() == graph.size())
            return true;
        return false;
    }
}
