package DataStructure.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/9/19
 * Time: 10:12 PM
 * Description:
 * https://www.jianshu.com/p/30d2058db7f7
 */


public class _947_MostStonesRemovedwithSameRoworColumn_DFS_UnionFind {

    int count = 0;
    public int removeStones_UF(int[][] stones) {
        Map<String, String> parent = new HashMap<>();
        count = stones.length;
        // init Union Find
        for (int[] stone : stones) {
            String s = stone[0] + " " + stone[1];
            parent.put(s, s);
        }
        for (int[] s1 : stones) {
            String ss1 = s1[0] + " " + s1[1];
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) { // in the same column or row
                    String ss2 = s2[0] + " " + s2[1];
                    union(parent, ss1, ss2);
                }
            }
        }
        return stones.length - count;
    }
    private void union(Map<String, String> parent, String s1, String s2) {
        String r1 = find(parent, s1), r2 = find(parent, s2);
        if (r1.equals(r2)) {
            return;
        }
        parent.put(r1, r2);
        count--;
    }
    private String find(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent, parent.get(s)));
        }
        return parent.get(s);
    }

//    Time : O(N^2), N = # of stones
//    Space: O(N)
    // Ans = # of stones – # of islands
    public int removeStones(int[][] stones) {
        HashSet<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
                dfs(s1, visited, stones);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int[] s1, HashSet<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
                // stone with same row or column. group them into island
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}
