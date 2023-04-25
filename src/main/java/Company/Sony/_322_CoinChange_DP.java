package Company.Sony;

import java.util.Arrays;

/**
 * Created by zhang on 2018/1/18.
 */
public class _322_CoinChange_DP {
        public static void main(String[] args){
            coinChange(new int[]{1,2,5},10);
        }
        // Bottom up DP
        // Time complexity : O(S∗n). where S is the amount, n is denomination count.
        public static int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1]; // dp[n] represent number n  have min number coins
            //dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int c : coins) {
                    if (c <= i) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                    }
                }
            }
            return dp[amount] != (amount + 1) ? dp[amount] : -1;
        }

        // Top down DP
        public static int coinChange_TopDown(int[] coins, int amount) {
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

    }
