package greedy;

/**
 * Created by zhang on 2017/3/1.
 * //int[] prices = {7, 1, 5, 3, 6, 4};
 */
public class BestTime122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) sum += diff;
        }
        return sum;
    }
}
