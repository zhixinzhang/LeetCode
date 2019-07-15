package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/3/19
 * Time: 2:23 PM
 * Description:
 */


public class _123_BestTimetoBuyandSellStock3_DP {
    // dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j] + prices[cur] - prices[j]);
    public int maxProfit(int[] prices) {
        // corner case
        if(prices == null || prices.length == 0) return 0;

        int m = 2;
        int n = prices.length;
        int[][] DP = new int[m + 1][n];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) DP[i][j] = 0;
                else{
                    DP[i][j] = DP[i][j - 1];
                    for(int k = 0; k < j; k++){
                        int prev = k == 0 ? 0: DP[i - 1][k - 1];
                        DP[i][j] = Math.max(DP[i][j], prev + prices[j] - prices[k]);
                    }
                }
            }
        }

        return DP[m][n - 1];
    }

    public int maxProfit_DP(int[] prices) {
        // corner case
        if(prices == null || prices.length == 0) return 0;

        int m = 2;
        int n = prices.length;
        int[][] DP = new int[m + 1][n];
        for(int i = 0; i < m + 1; i++){
            int tempMax = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) DP[i][j] = 0;
                else{
                    int prev = 0;
                    if(j >= 2) prev = DP[i - 1][j - 2];
                    tempMax = Math.max(tempMax, prev - prices[j - 1]);
                    DP[i][j] = Math.max(DP[i][j - 1], tempMax + prices[j]);
                }
            }
        }

        return DP[m][n - 1];
    }
}
