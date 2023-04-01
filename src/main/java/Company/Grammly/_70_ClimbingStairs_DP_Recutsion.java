package Company.Grammly;
/*
 * @Author: Luke Zhang 
 * @Date: 2023-03-30 20:45:32 
 * @Last Modified by: Luke Zhang
 * @Last Modified time: 2023-03-30 20:48:25
 * 
 *  * You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Note: Given n will be a positive integer.
 */

public class _70_ClimbingStairs_DP_Recutsion {
    // o(2 ^ n)
    public int climbStairs_Recursion(int n){
        return recur(0, n);
    }
    public int recur(int i, int n){
        if(i > n)  return 0;
        if(i == n) return 1;

        return recur(i+1, n) + recur(i + 2, n);
    }

    public int climbStairs_DP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return n;
        int pre = 1;
        int cur = 2;
        for (int i = 2;i < n;i++){
            int tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }
}
