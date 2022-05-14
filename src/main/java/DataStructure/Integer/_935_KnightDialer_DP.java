package DataStructure.Integer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/12/19
 * Time: 11:47 AM
 * Description:
 *
 * https://leetcode.com/problems/knight-dialer/discuss/189322/Java-DFS-with-Memo
 * https://leetcode.com/problems/knight-dialer/discuss/189271/Java-Top-Down-Memo-DP-O(N)
 * https://hackernoon.com/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029
 */


public class _935_KnightDialer_DP {
    public int knightDialer(int N) {
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[N+1][10];
        for(int i = 1; i <= N; i++)
            Arrays.fill(dp[i], -1);
        int res = 0;
        for(int i = 0; i < 10; i++){
            res += helper(N, i, map, dp);
            res %= (int)1e9 + 7;
        }
        return res;
    }
    private int helper(int N, int start, int[][] map, int[][] dp) {
        if(N == 1)
            return 1;
        if(dp[N][start] > -1)
            return dp[N][start];
        dp[N][start] = 0;
        for(int next : map[start]){
            dp[N][start] += helper(N-1, next, map, dp);
            dp[N][start] %= (int)1e9 + 7;
        }
        return dp[N][start];
    }
}
