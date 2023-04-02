package google.DP;

/**
 * Created by zhang on 2018/7/10.
 */
public class _322_CoinChange_DP {
    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)  return -1;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
    public static void main(String[] args){
        coinChange(new int[]{1,2,5}, 11);
    }
}
