package Company.Robinhood;
import java.util.*;

/*
        Our goal is to build a simplified version of a real Robinhood system that reads a customer's trades from a stream, maintains what they own, and rectifies running out of cash (through a process called a "margin call", which we'll define later). We’re looking for clean code, good naming, testing, etc. We're not particularly looking for the most performant solution.

    **Step 1 (tests 1-4): Parse trades and build a customer portfolio**

    Your input will be a list of trades, each of which is itself a list of strings in the form [timestamp, symbol, B/S (for buy/sell), quantity, price], e.g.

    [["1", "AAPL", "B", "10", "10"], ["3", "GOOG", "B", "20", "5"], ["10", "AAPL", "S", "5", "15"]]

    is equivalent to buying 10 shares (i.e. units) of AAPL for 5 each at timestamp 3, and selling 5 shares of AAPL for $15 at timestamp 10.

    **Input assumptions:**

    - The input is sorted by timestamp
    - All numerical values are nonnegative integers
    - Trades will always be valid (i.e. a customer will never sell more of a stock than they own).

    From the provided list of trades, our goal is to maintain the customer's resulting portfolio (meaning everything they own), **assuming they begin with $1000**. For instance, in the above example, the customer would end up with $875, 5 shares of AAPL, and 20 shares of GOOG. You should return a list representing this portfolio, formatting each individual position as a list of strings in the form [symbol, quantity], using 'CASH' as the symbol for cash and sorting the remaining stocks alphabetically based on symbol. For instance, the above portfolio would be represented as

    [["CASH", "875"], ["AAPL", "5"], ["GOOG", "20"]]

    **Step 2 (tests 5-7): Margin calls**

    If the customer ever ends up with a negative amount of cash **after a buy**, they then enter a process known as a **margin call** to correct the situation. In this process, we forcefully sell stocks in the customer's portfolio (sometimes including the shares we just bought) until their cash becomes non-negative again.

    We sell shares from the most expensive to least expensive shares (based on each symbol's most-recently-traded price) with ties broken by preferring the alphabetically earliest symbol. Assume we're able to sell any number of shares in a symbol at that symbol's most-recently-traded price.

    For example, for this input:

    ```
    [["1", "AAPL", "B", "10", "100"],
    ["2", "AAPL", "S", "2", "80"],
    ["3", "GOOG", "B", "15", "20"]]

    ```

    The customer would be left with 8 AAPL shares, 15 GOOG shares, and 80 a share) to cover the deficit. Afterwards, they would have 6 shares of AAPL, 15 shares of GOOG, and a cash balance of $20.

    The expected output would be

    [["CASH", "20"], ["AAPL", "6"], ["GOOG", "15"]]

    **Step 3/Extension 1 (tests 8-10): Collateral**

    Certain stocks have special classifications, and require the customer to also own another "collateral" stock, meaning it cannot be sold during the margin call process. Our goal is to handle a simplified version of this phenomenon.

    Formally, we'll consider stocks with symbols ending in "O" to be special, with the remainder of the symbol identifying its collateral stock. For example, AAPLO is special, and its collateral stock is AAPL. **At all times**, the customer must hold at least as many shares of the collateral stock as they do the special stock; e.g. they must own at least as many shares of AAPL as they do of AAPLO.

    As a result, the margin call process will now sell the most valuable **non-collateral** share until the balance is positive again. Note that if this sells a special stock, some of the collateral stock may be freed up to be sold.

    For example, if the customer purchases 5 shares of AAPL for 75 each, then finally 5 shares of AAPLO for 125, but their shares of AAPL can no longer be used to cover the deficit (since they've become collateral for AAPLO). As a result, 2 shares of GOOG would be sold back (again at 25, 5 AAPL, 5 AAPLO, and 3 GOOG. Thus, with an input of

    [["1", "AAPL", "B", "5", "100"], ["2", "GOOG", "B", "5", "75"], ["3", "AAPLO", "B", "5", "50"]]

    the corresponding output would be

    [["CASH", "25"], ["AAPL", "5"], ["AAPLO", "5"], ["GOOG", "3"]
    */

    // const string kCash = "CASH";
    // const int kCashAmount = 1000;   
    
    // Solutions
    // step 1: for loop orders and parse every order. during the for loop, use a map to store what stock we have and 
    // match new order. at the end return proflio  O (n * n * log n)  n is number of orders , need sort stock name
    // step 2: for loop orders and parse every order. during the for loop, use a map to store what stock we have and 
    // we should store every stock max price and if we trigger the margin call, then we sell stock from highest price
    // O (n * n * log n)
public class _MarginCall_Map {
    static int kCashAmount = 1000;
    static String kCash = "CASH";
    public static void main(String[] args) {
        String[][] records = {
            {"1", "AAPL", "B", "10", "10"},
            {"3", "GOOG", "B", "20", "5"},
            {"10", "AAPL", "S", "5", "15"}
        };
        System.out.println("Q1 test case 0: "); 
        getUserPortfolio(records);
        

        records = new String[][]{
            {"1", "AAPL", "B", "10", "10"},
            {"3", "GOOG", "B", "20", "5"},
            {"4", "FB", "B", "5", "12"},
            {"3", "GOOG", "S", "3", "8"},
            {"3", "GOOG", "B", "5", "10"},
            {"10", "AAPL", "S", "5", "15"}
        };

        System.out.println("Q1 test case 1: "); 
        getUserPortfolio(records);
        

        records = new String[][]{
            {"1", "AAPL", "B", "10", "100"},
            {"2", "AAPL", "S", "2", "80"},
            {"3", "GOOG", "B", "15", "20"}
        };
        System.out.println("Q2 test case 1: "); 
        getUserPortfolioWithMarginCall(records);
        
        records = new String[][]{
            {"1", "AAPL", "B", "5", "100"},
            {"2", "ABPL", "B", "5", "100"},
            {"3", "AAPL", "S", "2", "80"},
            {"4", "ABPL", "S", "2", "80"},
            // has tie on price, take alpha first
            {"5", "GOOG", "B", "15", "30"}
        };
        System.out.println("Q2 test case 2: "); 
        getUserPortfolioWithMarginCall(records);
        
        records = new String[][]{
            {"1", "AAPL", "B", "5", "100"},
            {"2", "ABPL", "B", "5", "100"},
            {"3", "AAPL", "S", "2", "80"},
            {"4", "ABPL", "S", "2", "120"},
            // pick high price first
            {"5", "GOOG", "B", "15", "30"}
        };
        System.out.println("Q2 test case 3: "); 
        getUserPortfolioWithMarginCall(records);

        records = new String[][]{
            {"1", "AAPL", "B", "5", "100"},
            {"2", "ABPL", "B", "5", "100"},
            {"3", "AAPL", "S", "2", "80"},
            {"4", "ABPL", "S", "2", "120"},
            // need to sell multiple stocks
            {"5", "GOOG", "B", "10", "80"}
            };
        System.out.println("Q2 test case 4: "); 
        getUserPortfolioWithMarginCall(records);

        records = new String[][]{
            {"1", "AAPL", "B", "5", "100"}, 
            {"2", "GOOG", "B", "5", "75"},
            {"3", "AAPLO", "B", "5", "50"}
        };
        System.out.println("Q3 test case 0: "); 
        getUserPortfolioWithCollateral(records);

        records = new String[][]{
            {"1", "AAPL", "B", "6", "50"}, 
            {"2", "GOOG", "B", "6", "50"},
            {"3", "AAPLO", "B", "5", "25"},
            {"4", "GOOG0", "B", "5", "25"},
            {"5", "TEST", "B", "250", "1"}
        };
        System.out.println("Q3 test case 1: "); 
        getUserPortfolioWithCollateral(records);
        
    }

    private static void getUserPortfolio(String[][] records){
        Map<String, Integer> ownShares = new HashMap<>();
        int cash = kCashAmount;
        for (String[] record : records){
            String shareName = record[1];
            String ops = record[2];
            int quantity = Integer.valueOf(record[3]);
            int price = Integer.valueOf(record[4]);
            cash = tradeStock(ownShares, shareName, ops, quantity, price, cash);
        }

        printProtfolio(cash, ownShares);
    }

    private static void printProtfolio(int cash, Map<String, Integer> ownShares){
        System.out.println("CASH : " + String.valueOf(cash));

        List<String> sortedStocks = new ArrayList<>(ownShares.keySet());
        Collections.sort(sortedStocks);
        for (String share : sortedStocks){
            System.out.println(share + " : " + String.valueOf(ownShares.get(share)));
        }
    }


    private static int tradeStock(Map<String, Integer> ownShares, String shareName, 
        String ops, int quantity, int price, int cash){
            if (ops == "B"){        // buy order
                cash -= quantity * price;
                int count = ownShares.getOrDefault(shareName, 0);
                count += quantity;
                ownShares.put(shareName, count);
            } else if (ops == "S"){
                cash += quantity * price;
                int count = ownShares.get(shareName);
                count -= quantity;
                if (count == 0) {
                    ownShares.remove(shareName);
                } else {
                    ownShares.put(shareName, count);
                }
            }
        return cash;
    }
    
// ***************************** //    O(N * M * NLogN) N is the number of share, M is number of the price 
    private static void getUserPortfolioWithMarginCall(String[][] records){
        Map<String, Integer> ownShares = new HashMap<>();   // name : share    
        int cash = kCashAmount;

        Map<String, Integer> maxSharePrices = new HashMap<>(); // name : Price
        for (String[] record : records){
            String shareName = record[1];
            String ops = record[2];
            int quantity = Integer.valueOf(record[3]);
            int price = Integer.valueOf(record[4]);
            cash = tradeStock(ownShares, shareName, ops, quantity, price, cash);
            maxSharePrices.put(shareName, price);   // Update stock price
            if (cash < 0) {
                cash = marginCall(ownShares, maxSharePrices, cash);
            }
        }

        printProtfolio(cash, ownShares);
    }
    
    private static int marginCall(Map<String, Integer> ownShares, Map<String, Integer> maxSharePrices, int cash){
        // Keep selling until cash becomes non-negative
        List<String> sortedShares = new ArrayList<>(maxSharePrices.keySet());
        Collections.sort(sortedShares, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (maxSharePrices.get(o1) == maxSharePrices.get(o2))
                    return o1.compareTo(o2);
                else
                    return maxSharePrices.get(o2) - maxSharePrices.get(o1);  // return max value
            }
        });

        for (int i = 0; i < sortedShares.size(); i++){
            String sellShareName = sortedShares.get(i);
            int price = maxSharePrices.get(sellShareName);

            int sell_quantity = 0;
            if (Math.abs(cash) % price == 0) {
                sell_quantity = Math.abs(cash) / price;
            } else {
                sell_quantity = Math.abs(cash) / price + 1;
            }

            int leftShareCount = ownShares.get(sellShareName);
            if(leftShareCount >= sell_quantity){
                cash += sell_quantity * price;
                leftShareCount -= sell_quantity;
                ownShares.put(sellShareName, leftShareCount);

            } else {
                cash += leftShareCount * price;
                leftShareCount = 0;
                ownShares.remove(sellShareName);
            }

            if (cash >= 0) {
                break;
            }
        }

        return cash;
    }


    // ***************************** //    O(N * M * NLogN) N is the number of share, M is number of the price 
    private static void getUserPortfolioWithCollateral(String[][] records){
        Map<String, Integer> ownShares = new HashMap<>();   // name : share    
        int cash = kCashAmount;

        Map<String, Integer> maxSharePrices = new HashMap<>(); // name : Price
        for (String[] record : records){
            String shareName = record[1];
            String ops = record[2];
            int quantity = Integer.valueOf(record[3]);
            int price = Integer.valueOf(record[4]);
            cash = tradeStock(ownShares, shareName, ops, quantity, price, cash);
            maxSharePrices.put(shareName, price);   // Update stock price
            if (cash < 0) {
                cash = marginCallWithCollateral(ownShares, maxSharePrices, cash);
            }
        }

        printProtfolio(cash, ownShares);
    }


    private static int marginCallWithCollateral(Map<String, Integer> ownShares, Map<String, Integer> maxSharePrices, int cash){
        // Keep selling until cash becomes non-negative
        List<String> sortedShares = new ArrayList<>(maxSharePrices.keySet());
        Collections.sort(sortedShares, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (maxSharePrices.get(o1) == maxSharePrices.get(o2))
                    return o1.compareTo(o2);
                else
                    return maxSharePrices.get(o2) - maxSharePrices.get(o1);  // return max value
            }
        });

        for (int i = 0; i < sortedShares.size(); i++){
            String sellShareName = sortedShares.get(i);
            if (!isGoodToSell(ownShares, sellShareName)){
                continue;
            }
            int price = maxSharePrices.get(sellShareName);
            int sell_quantity = 0;
            if (Math.abs(cash) % price == 0) {
                sell_quantity = Math.abs(cash) / price;
            } else {
                sell_quantity = Math.abs(cash) / price + 1;
            }

            int leftShareCount = ownShares.get(sellShareName);
            if(leftShareCount >= sell_quantity){
                cash += sell_quantity * price;
                leftShareCount -= sell_quantity;
                ownShares.put(sellShareName, leftShareCount);

            } else {
                cash += leftShareCount * price;
                leftShareCount = 0;
                ownShares.remove(sellShareName);
            }

            if (cash >= 0) {
                break;
            }
        }

        return cash;
    }

    private static boolean isGoodToSell(Map<String, Integer> ownShares, String shareName){
        if (shareName.charAt(shareName.length() - 1) == 'O') {
            return true;
        }
        // AAPLO : Stocks without associated special stock are good to sell at any time
        if (!ownShares.containsKey(shareName + "O")) {
            return true;
        }

        if (ownShares.get(shareName + "O") < ownShares.get(shareName)) {
            return true;
        }
        return false;
    }
}
