package company.uber;

import java.util.*;

/**
 *
 * Created by zhang on 2018/9/10.
 *          B -> C
 *         /
 *      A
 *          \
 *      D ->  E
 */
public class packageDepend_DFS_BFS {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args){
        List<String> pack1 = new ArrayList<>();
        pack1.add("H");pack1.add("A");
        List<String> pack2 = new ArrayList<>();
        pack2.add("A");pack2.add("B");
        List<String> pack3 = new ArrayList<>();
        pack3.add("M");pack3.add("B");
        List<String> pack4 = new ArrayList<>();
        pack4.add("B");pack4.add("C");
        List<String> pack5 = new ArrayList<>();
        pack5.add("C");pack5.add("E");
        List<String> pack6 = new ArrayList<>();
        pack6.add("E");pack6.add("F");
        List<String> pack7 = new ArrayList<>();
        pack7.add("C");pack7.add("M");

        List<List<String>> packDep = new ArrayList<>();
        packDep.add(pack1);
        packDep.add(pack2);
        packDep.add(pack3);
        packDep.add(pack4);
        packDep.add(pack5);
        packDep.add(pack6);
        packDep.add(pack7);
        List<String> res = bfs("F","M",packDep);
        List<String> res1 = dfs("F","M",packDep);

        System.out.println(res);
    }

    public static List<String> dfs(String start, String end, List<List<String>> packDep){
        HashMap<String, List<String>> graph = new HashMap<>();
        for (List<String> l : packDep){
            String s = l.get(1);
            String e = l.get(0);
            List<String> child = graph.getOrDefault(s, new ArrayList<>());
            child.add(e);
            graph.put(s,child);
        }
        HashSet<String> vis = new HashSet<>();
        res.add(start);
        if (dfs(vis,graph,start,end))
            return res;
        return new ArrayList<>();
    }
    public static boolean dfs(HashSet<String> vis, HashMap<String, List<String>> graph,
                           String start, String end){
        if (start.equals(end)){
            return true;
        }
        if (vis.contains(start))
            return false;
        if (!graph.containsKey(start)){
            return false;
        }
        vis.add(start);
        for (int i = 0; i < graph.get(start).size(); i++){
            String curNode = graph.get(start).get(i);
            res.add(curNode);
            if (dfs(vis,graph,curNode,end))
                return true;
            else
                res.remove(res.size()-1);
        }
        vis.remove(start);
        return false;
    }


    public static List<String> bfs(String start, String end, List<List<String>> packDep){
        HashMap<String, List<String>> graph = new HashMap<>();
        for (List<String> l : packDep){
            String s = l.get(1);
            String e = l.get(0);
            List<String> child = graph.getOrDefault(s, new ArrayList<>());
            child.add(e);
            graph.put(s,child);
        }
        HashSet<String> vis = new HashSet<>();
        vis.add(start);
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{start,start});       // string path end pack
        String resPath = "";

        bfs: while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String[] cur = q.poll();
                String path = cur[0];
                String curStart = cur[1];
                if (!graph.containsKey(curStart))
                    continue;
                for (int j = 0; j < graph.get(curStart).size(); j++){
                    String curEnd = graph.get(curStart).get(j);
                    if (vis.contains(curEnd))
                        return res;
                    if (curEnd.equals(end)){
                        resPath = path + end;
                        if (detectCycle(end,graph,vis)){
                            resPath = "";
                        }
                        break bfs;
                    } else {
                        vis.add(curEnd);
                        q.add(new String[]{path + curEnd, curEnd});
                    }
                }
            }
        }
        for (int i = 0; i < resPath.length(); i++){
            res.add(String.valueOf(resPath.charAt(i)));
        }
        return res;
    }

    public static boolean detectCycle(String start, HashMap<String, List<String>> graph, HashSet<String> vis){
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                if (!graph.containsKey(cur))
                    continue;
                for (int j = 0; j < graph.get(cur).size(); j++){
                    String next = graph.get(cur).get(j);
                    if (vis.contains(next))
                        return false;
                    else{
                        q.add(next);
                        vis.add(next);
                    }
                }
            }
        }
        return true;
    }
}
