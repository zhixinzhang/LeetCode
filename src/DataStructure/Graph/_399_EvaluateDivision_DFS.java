package DataStructure.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhang on 2018/5/3.
 * 1.创建graph class
 * 2.hashmap 创建graph
 * 3.dfs + backtrack
 * 4.用hashset 记录存储的点
 */
public class _399_EvaluateDivision_DFS {
        // create graph use hashmap
        class graphNode{
            String den;
            double val;
            graphNode(String den, double val){
                this.den = den;
                this.val = val;
            }
        }
        HashMap<String, List<graphNode>> map;
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            map = new HashMap<>();
            for (int i = 0; i<equations.length;i++){
                String[] eq = equations[i];
                if (!map.containsKey(eq[0])){
                    map.put(eq[0],new ArrayList<>());
                }
                map.get(eq[0]).add(new graphNode(eq[1],values[i]));
                if (!map.containsKey(eq[1])){
                    map.put(eq[1],new ArrayList<>());
                }
                map.get(eq[1]).add(new graphNode(eq[0],1/values[i]));
            }
            double[] res = new double[queries.length];
            for (int i = 0; i<res.length; i++){
                res[i] = find(queries[i][0],queries[i][1],1,new HashSet<>());
            }
            return res;
        }
        public double find(String start, String end, double val, HashSet<String> visited){
            if (visited.contains(start))    return -1;
            if (!map.containsKey(start))    return -1;
            if (start.equals(end))  return val;
            visited.add(start);
            for (graphNode next : map.get(start)){
                double sub = find(next.den,end,val*next.val,visited);
                if (sub != -1.0)
                    return sub;
            }
            visited.remove(start);
            return -1.0;
        }
    }
