package greedy;



/**
 * Created by zhang on 2017/3/1.
 */
public class BestTimetoSell121 {
    public static int maxProfit(int[] prices) {
        //time limit
//        int res = 0 ;
//        for(int i= prices.length-1;i>0;i--){
//            for (int j = 0;j<i;j++){
//                int num = prices[i] - prices[j];
//                if (num>0){
//                    if (res < num){
//                        res = num;
//                    }
//                }
//            }
//        }
//        return res;
        if (prices.length < 2) return 0;
        int profit =0;
        int curMin = prices[0];

        for (int i = 1;i<prices.length;i++){
            profit = Math.max(profit,prices[i]-curMin);
            curMin = Math.min(curMin,prices[i]);
        }
        return profit;
    }




    public  static  void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfit(prices);
    }
}
