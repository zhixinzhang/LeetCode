package Company.Google.DP;

import java.util.Arrays;

/**
 * Created by zhang on 2018/3/26.
 * Just regular DataStructure.DP. Time Complexity: n * sqrt(n) Space: O(n)
 */
public class _279_PerfectSquares_DP {
    public int numSquares(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 0; i <= n; i++){
            for (int j = 1; j*j < i; j++){
                dp[i] = Math.min(dp[i],dp[i - j*j]+1);
            }
        }
        return dp[n];
    }
}
