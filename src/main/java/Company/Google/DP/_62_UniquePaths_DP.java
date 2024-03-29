package Company.Google.DP;

import java.util.Arrays;

/**
 * Created by zhang on 2018/6/22.
 */
public class _62_UniquePaths_DP {
    public static int uniquePaths_2D(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i<m;i++){
            for (int j = 0; j<n; j++){
                if (j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePaths_1D(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];
    }


        public static void main(String[] args){
        uniquePaths_1D(2,1);
    }
}
