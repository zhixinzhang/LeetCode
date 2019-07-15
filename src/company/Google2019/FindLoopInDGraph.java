package company.Google2019;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 2/19/19
 * Time: 11:24 AM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=482761&page=1
 *
 * 有向图找环 并print
 *
 *
 * g-> h -> a -> b  -> c  -> d
 *
 *               e
 *
 *
 */


public class FindLoopInDGraph {
    static HashMap<String, List<String>> dGraph = new HashMap<>();
    public static void main(String[] args){
        String[][] vec = new String[][]{
                {"g","h"},
                {"h","a"},
                {"b","a"},
                {"b","c"},
                {"c","d"},
                {"a","e"},
                {"e","b"},
        };
        resolve(vec);
    }
    private static void resolve(String[][] vec){
        // build directed graph
        for (String[] vector : vec){
            String l = vector[0];
            String r = vector[1];
            dGraph.putIfAbsent(l,new ArrayList<>());
            dGraph.get(l).add(r);
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String[]> queue = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : dGraph.entrySet()){
            String curNode = entry.getKey();
            if (visited.add(curNode)){
                queue.add(new String[]{curNode, curNode});
                findLoop(queue, visited);
            }
        }
    }

    private static void findLoop(Queue<String[]> queue, HashSet<String> visited){
        while (!queue.isEmpty()){
            String[] info = queue.poll();
            String curNode = info[0];
            String path = info[1];
            List<String> nextNodes = dGraph.get(curNode);
            for (String node : nextNodes){
                if (visited.contains(node))
                    printPath(node,path);
                else{
                    queue.add(new String[]{node, path+node});
                }
            }
        }
    }

    private static void printPath(String node, String path){
        int i = path.lastIndexOf(node);
        path = path.substring(i);
        System.out.println(path);
    }
}
