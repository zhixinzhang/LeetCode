package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/31.
 */
public class _514_FreedomTrail_DFS_DP {

    Map<String, Map<Integer, Integer>> memo;
    public int findRotateSteps_DFS(String ring, String key) {
        memo = new HashMap<>();
        return dfs(ring, key, 0);
    }

    private int findPos(String ring, char ch){ // find first occurrence clockwise
        return ring.indexOf(ch);
    }

    private int findBackPos(String ring, char ch){ //find first occurrence  anti-clockwise
        if(ring.charAt(0) == ch) return 0;
        for(int i = ring.length()-1;i>0;i--){
            if(ring.charAt(i) == ch) return i;
        }
        return 0;
    }

    private int dfs(String ring, String key, int i){
        if(i == key.length()) return 0;
        int res = 0;
        char ch = key.charAt(i);
        if(memo.containsKey(ring) && memo.get(ring).containsKey(i)) return memo.get(ring).get(i);
        int f = findPos(ring, ch);
        int b = findBackPos(ring, ch);
        int forward = 1+f+dfs(ring.substring(f)+ring.substring(0, f), key, i+1);
        int back = 1+ring.length()-b + dfs(ring.substring(b)+ring.substring(0, b),key, i+1);
        res = Math.min(forward, back);
        Map<Integer, Integer> ans = memo.getOrDefault(ring, new HashMap<>());
        ans.put(i, res);
        memo.put(ring, ans);
        return res;
    }




//   static HashMap<String, Map<DataStructure.Integer, DataStructure.Integer>> memo = new HashMap<>();
//    public static int findRotateSteps(String ring, String key) {
//        //ring = "godding", key = "gd"
//        if(ring == null || ring.length() == 0) return 0;
//        int res = dfs(ring,key,0,0) + key.length();
//        return res;
//    }
//    private static int dfs(String ring, String key, int index, int dis){
//        if(index >= key.length())
//            return dis;
//        char curC = key.charAt(index);  // g
//        int distance = DataStructure.Integer.MAX_VALUE;
//        if(memo.containsKey(ring) && memo.get(ring).containsKey(index))
//            return memo.get(ring).get(index);
//        List<DataStructure.Integer> list = new DataStructure.ArrayList<>();
//        // 两个方向转动
//        // abcde de  // 0 - 4 deabc
//        String backS = ring;
//        for(int i = 0; i<ring.length(); i++){
//            if(ring.charAt(i) == curC){
//                String left = "";
//                String right = "";
//                int splitIndex = Math.min(ring.length()-i,i);
//                if(ring.length() - i < i){
//                    right = ring.substring(0,i);
//                    left = ring.substring(i,ring.length());
//                    ring = left + right;
//                }else{
//                    left = ring.substring(0,i);
//                    right = ring.substring(i,ring.length());
//                    ring = right + left;
//                }
////                ring = right + left;
//                distance = Math.min(dfs(ring,key,index+1, dis + splitIndex),distance);
//                ring = backS;
//            }
//                list.add(i);        //0 6
//        }
//        return distance;
//    }
    public static void main(String[] args){
//        findRotateSteps("edcba","abcde");
    }
}
