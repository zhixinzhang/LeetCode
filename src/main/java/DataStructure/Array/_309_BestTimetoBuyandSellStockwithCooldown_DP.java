package DataStructure.Array;

/**
 * Created by zhang on 2018/3/26.
 *
 *
 * prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 O(n) time and O(2n) space
 */
public class _309_BestTimetoBuyandSellStockwithCooldown_DP {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len]; //sell[i] means must sell at day i
        int[] cooldown = new int[len]; //cooldown[i] means day i is cooldown day
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < prices.length; ++i){
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
            int a = Math.max(sell[i - 1], cooldown[i - 2]);
            sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
        }
        return Math.max(sell[len - 1], cooldown[len - 1]);
    }
    public static void main(String[] args){
        maxProfit(new int[]{1, 2, 3, 0, 2});
    }
}
