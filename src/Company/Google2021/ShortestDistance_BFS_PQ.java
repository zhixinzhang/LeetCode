package Company.Google2021;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 2/25/19
 * Time: 12:41 PM
 * Description:
 */


public class ShortestDistance_BFS_PQ {
    static HashSet<String> visited = new HashSet<>();

    public static void main(String[] args){
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        graph.putIfAbsent("A",new HashMap<>());
        graph.get("A").put("B", 1);
        graph.get("A").put("C", 2);
        graph.get("A").put("D", 6);

        graph.putIfAbsent("B",new HashMap<>());
        graph.get("B").put("C", 6);
        graph.get("B").put("D", 3);
        graph.get("B").put("E", 1);

        graph.putIfAbsent("C",new HashMap<>());
        graph.get("C").put("E", 1);
        graph.get("C").put("F", 2);

        String res = shortestPath(visited, graph, "A", "F");
        String resw = solve(visited, graph, "A", "F");
    }
    // find bfs shortest path
    private static String shortestPath(HashSet<String> visited, HashMap<String, HashMap<String, Integer>> graph, String start, String end){
        String path = start;
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{start, start});
        while (!queue.isEmpty()){
            String[] ss = queue.poll();
            String curNode = ss[0];             //"A"
            String curPath = ss[1];             //"ABC"
            HashMap<String, Integer> nextLevel = graph.get(curNode);
            for (Map.Entry<String, Integer> entry : nextLevel.entrySet()){
                String nextNode = entry.getKey();
                String nextPath = curPath + entry.getKey();
                if (visited.add(nextNode)){
                    queue.add(new String[]{nextNode, nextPath});
                    if (nextNode.equals(end))
                        return nextPath;
                }

            }
        }
        return "";
    }

    private static String solve(HashSet<String> visited, HashMap<String, HashMap<String, Integer>> graph, String start, String end){
        String sb = "";
        Queue<String[]> q = new LinkedList<>();
        sb = start;
        while (!q.isEmpty()){       // path, curNode, weight
            String[] cur = q.poll();
            String curPath = cur[0];
            String curS = cur[1];
            if (!visited.contains(curS)){
                visited.add(curS);
                HashMap<String, Integer> nextLevel = graph.get(curS);
                for (Map.Entry<String, Integer> entry : nextLevel.entrySet()){
                    String curNode = entry.getKey();
                    int wei = entry.getValue();

                    String nextPath = curPath + curNode;


                }
            }
        }
        return sb.toString();
    }
}
