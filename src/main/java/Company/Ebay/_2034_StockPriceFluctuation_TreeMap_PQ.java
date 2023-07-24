package Company.Ebay;

// You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

// Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

// Design an algorithm that:

//     Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
//     Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
//     Finds the maximum price the stock has been based on the current records.
//     Finds the minimum price the stock has been based on the current records.

// Example 1:

// Input
// ["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
// [[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
// Output
// [null, null, null, 5, 10, null, 5, null, 2]

// Explanation
// StockPrice stockPrice = new StockPrice();
// stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
// stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
// stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
// stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
// stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
//                           // Timestamps are [1,2] with corresponding prices [3,5].
// stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
// stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
// stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.

import java.util.*;



class PriceObj {
    int ts;
    int price;
    
    public PriceObj(int ts, int price){
        this.ts = ts;
        this.price = price;
    }
    
}
    
    
    // avg Time com -> O(log n)    rest of 3 fun is O(1) time
    // avg space  -> O(n) space -> n is timestamp
           
class Solution {
    // TreeMap<Integer, Integer> pricesTreeMap;            // [1,  3]  
    
    PriorityQueue<PriceObj> maxValue  = new PriorityQueue<PriceObj>(new Comparator<PriceObj>() {
            @Override
            public int compare(PriceObj p1, PriceObj p2){
                return p2.price - p1.price;
            }
        });
        
    PriorityQueue<PriceObj> minValue = new PriorityQueue<PriceObj>(new Comparator<PriceObj>() {
            @Override
            public int compare(PriceObj p1, PriceObj p2){
                return p1.price - p2.price;
            }
        });
    Map<Integer, Integer> pricesMap = new HashMap<>();
    int latestTimeStamp = -1;
    
    public static void main(String[] args){
        Solution stockPrice = new Solution();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        stockPrice.current();   // -> 5   price map empty
        stockPrice.maximum();       // 10
        stockPrice.update(1, 1);     
        stockPrice.minimum();       // 1
    }

    private void update(int timestamp, int price){          //O(1) time   -> O(log n)
        if (pricesMap.containsKey(timestamp)) {
            maxValue.remove(new PriceObj(timestamp, price));
            minValue.remove(new PriceObj(timestamp, price));
        }
        pricesMap.put(timestamp, price);    
        latestTimeStamp = Math.max(latestTimeStamp, timestamp);
        
        maxValue.add(new PriceObj(timestamp, price));
        minValue.add(new PriceObj(timestamp, price));
        
         System.out.println("update stock ts : " + timestamp + " price " + price); 
    }
    
    private void current(){           // O(1) time
        int res = pricesMap.getOrDefault(latestTimeStamp, 0);
        System.out.println("current stock price : " + res); 
    }
    
    private void maximum(){              // return latest ts price          O(1) time 
        if (maxValue.isEmpty())
            System.out.print("no stock price record");
        System.out.println("current maxmum stock price : " + maxValue.peek().price);
    }
    
    private void minimum(){              // return latest ts price          O(1) time 
        if (minValue.isEmpty())
            System.out.println("no stock price record");
        System.out.println("current minimum stock price : " + minValue.peek().price);
    }
}



// Solution 2 

    // HashMap<Integer, Integer> timePriceRecord;
    // TreeMap<Integer, Integer> priceFrequency;
    // int latestTime;

    // public StockPrice() {
    //     timePriceRecord = new HashMap<Integer, Integer>();
    //     priceFrequency = new TreeMap<Integer, Integer>();
    //     latestTime = 0;
    // }
    
    // public void update(int timestamp, int price) {
    //     latestTime = Math.max(timestamp, latestTime);
    //     if (timePriceRecord.containsKey(timestamp)) {
    //         // Remove previous price.
    //         int oldPrice = timePriceRecord.get(timestamp);
    //         priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);
            
    //         // Remove the entry from the map.
    //         if (priceFrequency.get(oldPrice) == 0) {
    //             priceFrequency.remove(oldPrice);
    //         }
    //     }
        
    //     // Add latest price for timestamp.
    //     timePriceRecord.put(timestamp, price);
    //     priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);     
    // }
    
    // public int current() {
    //     return timePriceRecord.get(latestTime);
    // }
    
    // public int maximum() {
    //     return priceFrequency.lastKey();
    // }
    
    // public int minimum() {
    //     return priceFrequency.firstKey();
    // }
        
      

        
    
    



