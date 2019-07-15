package DataStructure.Array;


public class _518_CoinChange2{

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