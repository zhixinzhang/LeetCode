package DataStructure.Array;

import java.util.Arrays;

public class _518_CoinChange2{
    //dp[i][j] : number of ways to make up amount = i with only first j types of coins;
	//	   Namely, we are using allowed to use coins[0:j]. 
    // dp[i][j] = dp[i][j-1] + dp[ i - coins[j] ][j]
    public int change_2D(int amount, int[] coins) {
        if (amount == 0) return 1;
        int n = coins.length;
        if (n == 0) return 0;
        
        int[][] dp = new int[amount + 1][n];
        Arrays.fill(dp[0], 1);
        
        // setting-up the first column, as result of each column depends on previous column 
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = (i < coins[0]) ? 0 : dp[i - coins[0]][0];
        }
        
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + ( (i < coins[j]) ? 0 : dp[i - coins[j]][j] );
            }
        }
        
        return dp[amount][n-1];
    }

    /**
     * The value in column j only depends on the value in column j-1 & column j itself.
     *  Thus we may reduce the space complexcity by only storing the previous column when calculating the result for current column.

Notice we can not do this by each row since the result of row i also depends on the result in row i - coin[j] 
for different j. Thus we need information in multiple rows to calculate current row.
     * 
     * 
    */

	public int change(int amount, int[] coins) {
        //dp[i]  0 <= i <= amount represent the 
        //dp[i] = dp[i-coins[j]] ,dp[i]
        /***简单DP.
		dp[i]表示总额为i时的方案数.
		转移方程: dp[i] = Σdp[i - coins[j]]; 表示 总额为i时的方案数 = 总额为i-coins[j]的方案数的加和.
		记得初始化dp[0] = 1; 表示总额为0时方案数为1.*/
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = 1; i <= amount; i++){
                if(i >= coin){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}