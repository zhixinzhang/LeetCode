package company.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhang on 2018/9/11.
 *
 * undirected weight two way graph
 * dfs + HashSet + A <-> B reverse rate
 */
public class _399_ExchangeMoney_Graph_DFS {
    static HashMap<String, List<String>> graph = new HashMap<>();
    static HashMap<String, List<Double>> graph_wei = new HashMap<>();
    public static void main(String[] args){
        update("U","R",6.8);      // A B 6.8  -> A / B = 6.8
        update("R","E",5.4);
        update("R","K",2);
        update("E","J",10);
        update("J","C",0.15);

        double res = convert("U","C", 10);
        System.out.println("we get total : " + res);
    }
    public  static void update(String cur1, String cur2, double rate){
        if (!graph.containsKey(cur1)){
            graph.put(cur1, new ArrayList<>());
            graph.get(cur1).add(cur1);
        }
        if (!graph.containsKey(cur2)) {
            graph.put(cur2, new ArrayList<>());
            graph.get(cur2).add(cur2);
        }

        if (!graph_wei.containsKey(cur1)){
            graph_wei.put(cur1, new ArrayList<>());
            graph_wei.get(cur1).add(1.0);
//            graph_wei.get(cur1).add(rate);
        }
        if (!graph_wei.containsKey(cur2)) {
            graph_wei.put(cur2, new ArrayList<>());
            graph_wei.get(cur2).add(1.0);
//            graph_wei.get(cur2).add(1/rate);
        }
        List<String> child = graph.get(cur1);
        boolean exist = false;
        for (int i = 0; i < child.size(); i++){
            if (child.get(i).equals(cur2)){
                exist = true;
                graph_wei.get(cur1).set(i,rate);
                break;
            }
        }
        if (!exist){
            graph.get(cur1).add(cur2);
            graph_wei.get(cur1).add(rate);
        }

        boolean existEnd = false;
        List<String> childE = graph.get(cur2);
        for (int i = 0; i < childE.size(); i++){
            if (childE.get(i).equals(cur1)){
                existEnd = true;
                graph_wei.get(cur2).set(i,1 / rate);
                break;
            }
        }
        if (!existEnd){
            graph.get(cur2).add(cur1);
            graph_wei.get(cur2).add(1/rate);
        }

    }
    public static double convert(String cur1, String cur2, double ant){
        // corner case
        if (cur1.equals(cur2))
            return 1;
        if (!graph.containsKey(cur1) || !graph.containsKey(cur2))
            return -1;
        //dfs
        double res = dfs(cur1, cur2, ant, new HashSet<String>());
        return res;
    }

    public static double dfs(String start, String end, double ant, HashSet<String> vis){
        if (start.equals(end))
            return ant;
        if (vis.contains(start))
            return 0.0;
        vis.add(start);
        List<String> child = graph.get(start);
        for (int i = 1; i < child.size(); i++){
            String nextStart = child.get(i);
            if (vis.contains(nextStart))
                continue;
            double rate = graph_wei.get(start).get(i);
//            ant *= rate;
            double res = dfs(nextStart, end, ant * rate, vis);
            if (res != 0.0)
                return res;
//            ant /= rate;
        }
        return 0.0;
    }
}
