package Company.Robinhood;
import java.util.*;

/**
 * // https://leetcode.com/discuss/interview-question/1681871/robinhood-vo-staff
 * 1:0,3:10,2:12,4:19,5:35 is equivalent to

price: 1, timestamp: 0
price: 3, timestamp: 10
price: 2, timestamp: 12
price: 4, timestamp: 19
price: 5, timestamp: 35

You can assume the input is sorted by timestamp and values are non-negative integers.

Step 2: Aggregate Historical Data from Prices

We calculate historical data across fixed time intervals. In this case, we’re interested in 
intervals of 10, so the first interval will be [0, 10). For each interval, you’ll build a datapoint with the following values.

Start time
First price
Last price
Max price
Min price

Important: If an interval has no prices, use the previous datapoint’s last price for all prices.
 If there are no prices and no previous datapoints, skip the interval.
You should return a string formatted as {start,first,last,max,min}. For the prices shown above, the expected datapoints are
*
Solution : 
Use two map, when we for loop the inputs, we parse the inputs
. the first map store <timeStamp interval(every 10 seconds),  value is arraylist to store all prices>
. the second map store <timeStamp interval, max price and min price> 
*/
public class _CandleStick_ {
    public static void main(String[] args){
        String input = "1:0,3:10,2:12,4:19,5:35";
        String input2 = "1:0,2:1,3:2,4:3,5:4,6:5,7:6,8:7,9:8,10:9,11:10,12:11,13:12,14:13,15:14,16:15,17:16,18:17,19:18,20:19";
        candleStick(input2);
    }

    public static String candleStick(String input){
      if (input == null || input.length() <= 2) {
          return input;
      }
      
      // step 1: parse prices
      int lastBucket = Integer.MIN_VALUE;
      String[] dataPoints = input.split(",");
      Map<Integer, List<Integer>> intervals = new HashMap<>();
      Map<Integer, int[]> bucketMinMax = new HashMap<>();
      
      for (String p : dataPoints){
          String[] pt = p.split(":");
          int price = Integer.valueOf(pt[0]);
          int timeStamp = Integer.valueOf(pt[1]);
          int bucketKey = timeStamp / 10;
          intervals.putIfAbsent(bucketKey, new ArrayList<>());
          intervals.get(bucketKey).add(price);
          
          bucketMinMax.putIfAbsent(bucketKey, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE});
          if (bucketMinMax.get(bucketKey)[0] < price){
              bucketMinMax.put(bucketKey, new int[]{price, bucketMinMax.get(bucketKey)[1]});
          }
          
          if (bucketMinMax.get(bucketKey)[1] > price){
          bucketMinMax.put(bucketKey, new int[]{bucketMinMax.get(bucketKey)[0], price});
          }
          
          lastBucket = Math.max(bucketKey, lastBucket);
      }
      
      // step2 : aggregate historical data from prices
      
      List<int[]> aggregated = new ArrayList<>();
      for (int start = 0; start < lastBucket + 1; start++){
          if (aggregated.size() == 0 && !intervals.containsKey(start)) {
              continue;
          }
          
          if (!intervals.containsKey(start)) {
              int prev = aggregated.get(aggregated.size() - 1)[2];
              int[] newOut = new int[]{start * 10, prev, prev, prev, prev};
              aggregated.add(newOut);
          } else {
              List<Integer> data = intervals.get(start);
              int[] newOut = new int[]{
                      start * 10, // start of the interval of 10
                      data.get(0), // first fist_price;
                      data.get(data.size() - 1), // last last_price
                      bucketMinMax.get(start)[0],
                      bucketMinMax.get(start)[1]
              };
              aggregated.add(newOut);
          }
      }
      
      StringBuilder sb = new StringBuilder();
      for (int[] dp : aggregated){
          sb.append("{");
          sb.append(dp[0]);
          for (int i = 1; i < dp.length; i++){
              sb.append(",").append(dp[i]);
          }
          sb.append("}");
      }
      
      System.out.println(sb.toString());
      return sb.toString();
  }

}