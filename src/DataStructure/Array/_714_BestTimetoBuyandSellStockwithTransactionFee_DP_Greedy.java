package DataStructure.Array;


//前i天的持有股票数最大，记为：hold[i]
//前i天的股票利益最大，记为：unHold[i]
public class _714_BestTimetoBuyandSellStockwithTransactionFee_DP_Greedy{
	    public int maxProfit(int[] prices, int fee) {
         int n = prices.length;
         int[] hold   = new int[n + 1];
         int[] unHold = new int[n + 1];

         hold[0] = Integer.MIN_VALUE;

         for (int i = 1; i <= n; ++i) {
             hold[i]   = Math.max(hold[i - 1], unHold[i - 1] - prices[i - 1] - fee);
             unHold[i] = Math.max(unHold[i - 1], hold[i - 1] + prices[i - 1]);
         }

         return unHold[n];
    }
}