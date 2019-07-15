package DataStructure.Array;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/15/19
 * Time: 7:35 PM
 * Description:
 *
 * https://leetcode.com/problems/longest-arithmetic-sequence/discuss/274701/Java-DP-O(n2)-solution-with-explanation
 */


public class _1027_LongestArithmeticSequence_DP {
    public int longestArithSeqLength(int[] A) {
        if (A.length <= 1) return A.length;

        int longest = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; i++){
            dp[i] = new HashMap<>();
        }
        for (int i = 1; i < A.length; i++){
            int x = A[i];
            for (int j = 0; j < i; j++){
                int y = A[j];
                int d = y - x;

                int len = 2;
                if (dp[j].containsKey(d)){
                    len = dp[j].get(d) + 1;
                }
                int curr = dp[i].getOrDefault(d, 0);
                dp[i].put(d, Math.max(curr, len));
                longest = Math.max(longest, dp[i].get(d));

            }
        }
        return longest;
    }
}
