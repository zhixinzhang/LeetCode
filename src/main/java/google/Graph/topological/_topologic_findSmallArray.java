package google.Graph.topological;

import java.util.*;

/**
 * Created by zhang on 2018/8/12.
 * Rebuild array: given a list of subsequences of an original array, rebuild a shortest unique original array by using the list of subsequence.
 e.g., given [[1, 9, 7], [1, 4], [4, 9]], the shortest unique original array is [1, 4, 9, 7]. from: 1point3acres
 来源一亩.三分地论坛.
 Follow up: the original array may contain duplicates, return shortest smallest lexicographical order array if multiple arrays can be reconstructed.
 e.g.,given [[2, 3], [3, 3, 3]], return [2, 3, 3, 3], 虽然[3, 2, 3, 3], [3, 3, 2, 3]也可以build, 但不是最小。

 http://www.1point3acres.com/bbs/thread-435726-1-1.html
 */
public class _topologic_findSmallArray {
    public static int[] find(List<int[]> arr){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i<arr.size(); i++){
            int[] cur = arr.get(i);
            for (int j = 0; j < cur.length; j++){
                graph.putIfAbsent(cur[j], new ArrayList<>());
                if (j + 1 < cur.length)
                    graph.get(cur[j]).add(cur[j+1]);
            }
        }
        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i : graph.keySet()){
            if (!vis.contains(i)){
                stack.push(i);
                dfs(i,vis,res,stack,graph);
            }
        }
        return new int[0];
    }

    public static void dfs(int key, HashSet<Integer> vis, LinkedList<Integer> res, Stack<Integer> stack,
                           HashMap<Integer, List<Integer>> graph){
        List<Integer> child = graph.get(key);
        Collections.sort(child, (a,b)->(b - a));
        vis.add(key);
        for (int s : child){
            if (!vis.contains(s)){
                stack.push(s);
                dfs(s,vis,res,stack,graph);
            }
        }
        int s = stack.pop();
        res.addFirst(s);
    }

    public static void main(String[] args){
        List<int[]> arr = new ArrayList<>();
        int[] a = new int[]{1,9,7};
//        int[] b = new int[]{1,4};
        int[] c = new int[]{9,4};
        arr.add(a);
//        arr.add(b);
        arr.add(c);
        find(arr);
    }
}
