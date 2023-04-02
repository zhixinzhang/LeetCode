package Company.Google.DP;

import java.util.Arrays;

/**
 * Created by zhang on 2018/7/4.
 * https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChange_DP {
    public static int coin(int[] coins, int l, int target){
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        // dp 里面存 对应的target 可以有多少个solution
        int[] dp = new int[target+1];
        dp[0] = 0;
        // Initialize all table values as 0
        Arrays.fill(dp, 0);   //O(n)
        for (int i = 0; i<l;i++){
            for (int j = coins[i]; j < target; j++){
                dp[j]  += dp[j - coins[i]];
            }
        }

        return dp[l];
    }
    public static void main(String[] args){
        int[] coins = new int[]{2, 5, 3, 6};
        coin(coins,coins.length,10);
    }
}
