package google.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/6/11.
 * 用bfs HM key 是连接的String value 是走过的路径 防止 继续走
 */
public class connectMovieName_BFS {
    public static String solution_BFS(String[] names,String start) {
        String res = start;
        Queue<String> q = new LinkedList<>();
        HashMap<String,HashSet<Integer>> visited = new HashMap<>();
        q.add(start);
        visited.put(start,new HashSet<>());
        // "a bc"  "bc d"  "bc e"
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++){
                start = q.poll();
                String[] arr = start.split(" ");
                String left = arr[arr.length - 1];      // a bc  ----  bc
                for (int j = 0; j<names.length;j++){
                    HashSet<Integer> path = (HashSet<Integer>)visited.get(start).clone();
                    String right = names[j].split(" ")[0];
                    if (left.equals(right) && !path.contains(j)){
                        String nextStart = start + " " + names[j].substring(names[j].indexOf(right) + right.length()).trim();
                        q.add(nextStart);
                        path.add(j);
                        visited.put(nextStart,path);
                        res = res.length() > nextStart.length() ? res : nextStart;
                    }
                }
            }
        }
        return res;
    }


    public static String solution(String[] names,String start){
        String res = "";
        HashSet<String> visited = new HashSet<>();
        for (String name : names){
            String[] curName = name.split(" ");
            String[] leftName = start.split(" ");
            String left = leftName[leftName.length-1];
            String end = curName[0];

            if (left.equals(end)){
                visited.add(name);
                String last = name.substring(name.indexOf(end)+end.length(),name.length()).trim();
                String tmp = dfs(start +" "+ last,names,visited);
                res = tmp.length() > res.length() ? tmp : res;
            }
        }
        return res;
    }
    private static String dfs(String s, String[] names, HashSet<String> visited){
        String[] arr = s.split(" ");
        String start = arr[arr.length-1];
        for (String name : names){
            String end = name.split(" ")[0];
            if (start.equals(end) && !visited.contains(name)){
                visited.add(name);
                String last = name.substring(name.indexOf(end)+end.length()).trim();
                String tmp = dfs(s +" "+ last,names,visited);
                s = s.length() > tmp.length() ? s : tmp;
            }
        }
        return s;
    }
    public static void main(String[] args){
        solution_BFS(new String[]{"b ba","b c", "ba bc", "c bc","a ab","ba b"},"c b");
        /**
         *  b ba     ba bc  ba b
         *  b c     c bc
         *  a ab
         *
         *  res   c b ba b c bc
         *        c b c bc
         *        c b ba bc
         * ***/
    }
}
