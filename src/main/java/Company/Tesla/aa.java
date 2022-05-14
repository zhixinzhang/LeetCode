package Company.Tesla;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/13/2021 12:10 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class aa {
    public static void main(String[] args){
        solution(new String[]{"abc", "yyy", "def", "csv"});
    }
    static int res = 0;
    static HashMap<Integer, Integer> map;
    public static int solution(String[] A) {
        if (A == null || A.length == 0) {
            return res;
        }

        map = new HashMap<>();
        int maxLen = dfs(A, "", 0);
        res = map.get(maxLen);
        return res;
    }

    private static int dfs (String[] A, String curS, int index){
        if (index >= A.length) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        for (char c : curS.toCharArray()) {
            if (!set.add(c)){
                return 0;
            }
        }

        int max = curS.length();
        for (int i = index; i < A.length; i++){
            max = Math.max(max, dfs(A, curS + A[i], i + 1));
            map.put(max, map.getOrDefault(max, 0) + 1);
        }

        return max;
    }
}
