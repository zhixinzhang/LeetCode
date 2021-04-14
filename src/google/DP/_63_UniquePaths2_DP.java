package google.DP;

/**
 * Created by zhang on 2018/6/22.
 */
public class _63_UniquePaths2_DP {
    public int uniquePathsWithObstacles_2D(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        if(m == 2 && n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1)
                break;
            else
                dp[i][0] = 1;
        }
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0)
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles_1D(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        if(m == 2 && n == 1)
            return 1;
        int[] dp = new int[m];
        for (int i = 0; i<m; i++){
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j < m;j++){
                if (obstacleGrid[j][i] == 1){
                    dp[j] = 0;
                    continue;
                }
                if (j == 0)
                    dp[j] = dp[j];
                else
                    dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[m-1];
    }

}
