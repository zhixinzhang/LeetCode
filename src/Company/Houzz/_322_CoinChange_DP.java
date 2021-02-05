package Company.Houzz;

import java.util.Arrays;

/**
 * Created by zhang on 2018/1/18.
 */
public class _322_CoinChange_DP {
        public static void main(String[] args){
            coinChange(new int[]{1,2,5},10);
        }
        public static int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1]; // dp[n] represent number n  have min number coins
            //dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            dp[0] = 0;
            if (coins == null || coins.length == 0 || amount == 0) return dp[0];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for(int i = 1; i<=amount;i++){
                for(int c : coins) {
                    dp[i] = Math.min(dp[i], ((i - c) >= 0 && dp[i-c] != Integer.MAX_VALUE) ? dp[i-c] + 1 : dp[i]);
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
