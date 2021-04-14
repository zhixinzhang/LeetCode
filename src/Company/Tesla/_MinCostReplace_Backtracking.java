package Company.Tesla;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/12/2021 9:23 PM
 * <p>
 * Description:
 * 2. 是第一题的小变形～给一个string 跟 cost array, 每个字母对应固定的cost,要string最后不会有两个相同字母
 * next to each other然后 return最小的删除cost
 *
 * Similar task :
 * Key Point:
 *
 * https://www.1point3acres.com/bbs/thread-657538-1-1.html
 */

public class _MinCostReplace_Backtracking {
    public static void main(String[] args){
//        findMinReplace("aaabbaaab");
        findMinReplace("abaacc", new int[]{2, 2, 3, 4, 5, 6});
    }

    static int ans = 0;
    private static int findMinReplace(String s, int[] cost){
        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int prev = 0;
        for (int cur = 1; cur < chars.length; cur++){
            if (chars[cur] == chars[prev]){
                ans += Math.min(cost[prev], cost[cur]);

            } else {
                prev = cur;
            }
        }
        return ans;
    }
}
