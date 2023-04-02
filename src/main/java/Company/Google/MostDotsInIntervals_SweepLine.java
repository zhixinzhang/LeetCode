package Company.Google;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 8/24/2021 3:19 PM
 * <p>
 * Source Link:
 * <p> https://www.1point3acres.com/bbs/thread-789210-1-1.html
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class MostDotsInIntervals_SweepLine {

    public static void main(String[] args){
        int[][] ans = new int[][]{
                {1,5},
                {3,7},
                {9,15},
                {10,13}
        };

        int[] dots = new int[]{2,3,6,8,10,15};
        maxDots(ans,dots);
    }

    private static int[] maxDots(int[][] ans, int[] dots){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] d : ans){
            map.put(d[0], map.getOrDefault(d[0], 0) + 1);
            map.put(d[1], map.getOrDefault(d[1], 0) - 1);
        }

        int[] res = new int[dots.length];

        int idx = 0, sum = 0;
        for (int k : map.keySet()){
            while (dots[idx] < k) {
                res[idx] = sum;
                idx ++;
            }
            if (idx == dots.length) {
                res[idx] = sum;
                break;
            }
            sum += map.get(k);
        }

        return res;
    }
}
