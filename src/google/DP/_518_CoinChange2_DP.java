package google.DP;

/**
 * Created by zhang on 2018/7/10.
 */
public class _518_CoinChange2_DP {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i >= coins[j])
                    dp[i] += dp[i-coins[j]];
            }
        }
        return dp[amount];
    }
}
