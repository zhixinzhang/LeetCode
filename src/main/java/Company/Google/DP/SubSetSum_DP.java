package google.DP;

/**
 * Created by zhang on 2018/7/6.
 *https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * 类似 416
 * Time complexity of the above solution is O(sum*n)
 */
public class SubSetSum_DP {
    public static void main (String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum_1D(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
    // 2D
    public static boolean isSubsetSum(int[] set, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];   // mean form 0 ,,,, n 是否能满足sum
        dp[0][0] = true;
        for (int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++){
            dp[0][i] = false;
        }
        for (int i = 1; i<= sum; i++){
            for (int j = 1; j <= n; j++){
                dp[j][i] = dp[j - 1][i];
                if (i >= set[j-1])
                    dp[j][i] = dp[j][i] || dp[j-1][i-set[j-1]];
            }
        }
        return dp[n][sum];
    }

    public static boolean isSubsetSum_1D(int[] set, int n, int sum) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= sum; j++){
                if (j >= set[i-1])
                    dp[j] = dp[j - set[i-1]] || dp[j];
            }
        }
        return dp[sum];
    }
}
