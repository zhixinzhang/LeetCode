package greedy;

/**
 * Created by zhang on 2017/3/1.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 int[] prices = {7, 1, 5, 3, 6, 4};
 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTime123 {
    public int maxProfit(int[] prices) {
        if (prices.length<2) return  0;
        final int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for (int i =1,valley = prices[0];i<n;++i){
            valley = Math.min(valley,prices[i]);
            f[i] = Math.max(f[i-1], prices[i] - valley);
        }

        for (int i = n-2, peak = prices[n-1];i>=0;--i){
            peak = Math.max(peak,prices[i]);
            g[i] = Math.max(g[i],peak-prices[i]);
        }

        int max_profit = 0;
        for (int i = 0; i < n; ++i)
            max_profit = Math.max(max_profit, f[i] + g[i]);
        return max_profit;
    }
}
