package Company.Amazon;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/2/2021 9:49 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1133_LargestUniqueNumber_Map {
    public int largestUniqueNumber(int[] A) {
        // corner case
        if ( A == null || A.length == 0) {
            return -1;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int n : A){
            cache.putIfAbsent(n, 0);
            int num = cache.get(n) + 1;
            cache.put(n, num);
        }

        for (int n : A){
            if (cache.get(n) == 1) {
                max = Math.max(max, n);
            }
        }

        return Math.max(-1, max);
    }

}
