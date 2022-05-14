package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/3/19
 * Time: 12:29 AM
 * Description:
 */

// O(n) time O(1) space 每次对比 最大最小值
public class _121_BestTimetoBuyandSellStock_DP {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length  <= 1)   return 0;
        int min = prices[0], res = 0;
        for(int p : prices){
            min = Math.min(p, min);
            res = Math.max(res, p - min);
        }
        return res;
    }
}
