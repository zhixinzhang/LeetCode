package Company.Robinhood;
import java.util.*;

// https://www.1point3acres.com/bbs/thread-975068-1-1.html
public class _MarginCall_ {
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
            {"4", "  FB", "B", "5", "12"},
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
        // getUserPortfolioWithMarginCall(records);
        
        
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
        for (String share : ownShares.keySet()){
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

        System.out.println("CASH : " + String.valueOf(cash));
        for (String share : ownShares.keySet()){
            System.out.println(share + " : " + String.valueOf(ownShares.get(share)));
        }
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

        System.out.println("CASH : " + String.valueOf(cash));
        for (String share : ownShares.keySet()){
            System.out.println(share + " : " + String.valueOf(ownShares.get(share)));
        }
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
