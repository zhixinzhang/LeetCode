package google.DP;

/**
 * Created by zhang on 2018/6/26.
 *
 * c[i][j] = maxCoins(nums[i] ~ nums[j])
 * ans = c[1][n]
 *https://www.youtube.com/watch?v=IFNibRVgFBo
 */

public class _312_BurstBalloons_DP {
    public int maxCoins(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
       int n = nums.length;
       int[][] dp = new int[n][n];

       for (int len = 1; len <= n; len++){
            for (int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                for(int k = i;k<j; k++){
                    int left = 1;
                    int right = 1;
                    if(i != 0)
                        left = nums[i];
                    if(j != n-1)
                        right = nums[j+1];
                    int before = 0;
                    int after = 0;
                    if(i != k)
                        before = dp[i][k-1];
                    if(j != k)
                        after = dp[k+1][j];
                    dp[i][j] = Math.max(left * nums[k] * right + before + after, dp[i][j]);
                }
            }
       }

       return dp[0][n-1];
    }
    // think out  we have a input data integer array
    //
    // [3 1 5 8]
}
