package Greedy;

import java.util.*;

/**
 * Created by zhang on 2017/3/1.
 * int[] prices = {7, 1, 5, 3, 6, 4};
 */
public class BestTime188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        
        int[] buy = new int[k]; // buy[i]: min cost at (i + 1)-th time stock purchased
        int[] sell = new int[k]; // sell[i]: max revenue at (i + 1)-th time stock sold
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        
        for (int i : prices) {
            buy[0] = Math.max(buy[0], i * -1);
            sell[0] = Math.max(sell[0], buy[0] + i);
            for (int j = 1; j < k; j++) { // The i-th time buy & sell depens on the (i - 1)-th time buy & sell
                buy[j] = Math.max(buy[j], sell[j - 1] - i);
                sell[j] = Math.max(sell[j], buy[j] + i);
            }
        }
        return sell[k - 1];
    }
}
