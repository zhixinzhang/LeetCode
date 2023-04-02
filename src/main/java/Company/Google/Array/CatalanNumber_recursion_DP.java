package google.Array;

import java.util.HashSet;

/**
 * Created by zhang on 2018/7/9.
 */
public class CatalanNumber_recursion_DP {
    public static void main(String[] args){
        catalan(6);
    }

    public static int catalan(int n){
        boolean[] visited = new boolean[n+1];
        int res = bt(visited,0,n);
        return res;
    }
    public static int bt(boolean[] visited, int s, int end){
        int res = 0;
        if (s >= end)
            s = 0;
        int l = -1, r = -1;
        for (int i = s+1; i<= end; i++){
            if (!visited[i] && l == -1){
                l = i;
                visited[l] = true;
            }
            if (!visited[i] && r == -1){
                r = i;
                visited[r] = true;
            }
            if((r - l) % 2 == 1){
                res += bt(visited,r+1,end);
//                visited[l] = false;
            }
            visited[r] = false;
        }
        if (l == -1 && r == -1)
            return res;
        return res;
    }

//    static int count = 0;
//    public static int catalan(int n){
//        int[] p = new int[n];
//        for(int i = 0; i < p.length; i++){
//            p[i] = i+1;
//        }
//        HashSet<DataStructure.Integer> visited = new HashSet<>();
//        visited.add(1);
//        recur(1,p,visited);
//        return count;
//    }
//    public static void recur(int person,int[] p, HashSet<DataStructure.Integer> visited){
//        if( visited.size() == p.length - 1){
//            count++;
//            for (int i : visited){
//                System.out.print(i + "->");
//            }
//            System.out.println("    ------  ");
//            return;
//        }
//
//        for (int i = 0; i < p.length; i++){
//            if (!visited.contains(p[i]) && Math.abs(p[i] - person) % 2 == 1){
//                visited.add(p[i]);
//                for (int j = 0; j < p.length; j++){
//                    if (!visited.contains(p[j])){
//                        if (j >= 1 && !visited.contains(p[j-1]))
//                            continue;
//                        visited.add(p[j]);
//                        recur(p[j],p,visited);
//                        visited.remove(p[j]);
//                    }
//                }
//                visited.remove(p[i]);
//            }
//        }
//        return;
//    }
}
