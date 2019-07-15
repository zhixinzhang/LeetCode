package DataStructure.Array;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/7/19
 * Time: 11:40 AM
 * Description:
 */


public class _975_OddEvenJump_DP {
    public int oddEvenJumps(int[] A) {
        if(A == null || A.length == 0) return 0;
        int len = A.length;
        boolean[][] dp = new boolean[len][2];
        dp[len-1][0] = true;
        dp[len-1][1] = true;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(A[len-1], len-1);
        int ans = 0;
        for (int i = len - 2; i>= 0; i--){
            // odd
            Integer nextGreater = tm.ceilingKey(A[i]);
            if (nextGreater != null){
                dp[i][0] = dp[tm.get(nextGreater)][1];
            }
            // Even step
            Integer nextSmaller = tm.floorKey(A[i]);
            if (nextSmaller != null) {
                dp[i][1] = dp[tm.get(nextSmaller)][0];
            }
            tm.put(A[i], i);
            ans += dp[i][0] ? 1 : 0;
        }
        return ans;
    }
}
