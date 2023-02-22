package Company.Robinhood;
import java.util.*;

/**
 * @author Luke Zhang
 * @Date 2021-07-21 22:07
 * 
 * // A trade is defined as a fixed-width string containing the 4 properties given below separated by commas:

// Symbol (4 alphabetical characters, left-padded by spaces)
// Type (either "B" or "S" for buy or sell)
// Quantity (4 digits, left-padded by zeros)
// ID (6 alphanumeric characters)
// e.g.
// "AAPL,B,0100,ABC123"
 * 
 * https://leetcode.com/discuss/interview-question/882324/robinhood-phone-screen
 */

 // O(N * M * M*Log(M)) N is the count of different Stock + quantity
 // M is the length of that type trader order
public class MatchHouseStreetOrder_Map {
    static final String exactMatch = "exact";
    static final String fuzzyMatch = "fuzzy";
    static final String offsetMatch = "offset";
    public static List<String> getUnMatchOrders(String[] houseTrades, String[] streetTrades) {
        // <symbol+quantity, Map<Trade, count>>
        Map<String, List<String>> houseMap = getTradeMap(houseTrades);
        Map<String, List<String>> streetMap = getTradeMap(streetTrades);

        removeMatches(houseMap, streetMap, exactMatch);
        
        // Q2
        removeMatches(houseMap, streetMap, fuzzyMatch);
        
        // Q3
        removeMatches(houseMap, streetMap, offsetMatch);
        
        List<String> unMatched = new ArrayList<>();
        for (List<String> val : houseMap.values()) {
            unMatched.addAll(val);
        } 
        for (List<String> val : streetMap.values()) {
            unMatched.addAll(val);
        }
        Collections.sort(unMatched);
        
        return unMatched;
    }
    
    private static void removeMatches(
        Map<String, List<String>> houseMap, 
        Map<String, List<String>> streetMap,
        String macthType
    ) {
        List<String> houseMapKeys = new ArrayList<>(houseMap.keySet());
        // if Prioritize exact and fuzzy matches over offsetting matches. Prioritize matching the earliest alphabetical buy with the earliest alphabetical sell.
        // then uncomment three Collections.sort
        // Collections.sort(houseMapKeys);
        for (String key : houseMapKeys) {
            if (streetMap.containsKey(key)) {
                // has same symbol and quantity, try to cancel out
                List<Integer> hTradeRemove = new ArrayList<>();
                List<Integer> sTradeRemove = new ArrayList<>();
                List<String> hTrades = houseMap.get(key);
                List<String> sTrades = streetMap.get(key);
                
                // Collections.sort(hTrades);
                // Collections.sort(sTrades);
                
                for (int i = 0; i < hTrades.size(); i++) {
                    String hTrade = hTrades.get(i);
                    for (int j = 0; j < sTrades.size(); j++) {
                        if (sTradeRemove.contains(j)) {
                            // already matched
                            continue;
                        }
                        String sTrade = sTrades.get(j);
                        if (macthType == "exact") {
                            if (hTrade.equals(sTrade)) {
                                hTradeRemove.add(i);
                                sTradeRemove.add(j);
                                break;
                            }
                        } else if (macthType == "fuzzy") {
                            if (hTrade.split(",")[1].equals(sTrade.split(",")[1])) {
                                hTradeRemove.add(i);
                                sTradeRemove.add(j);
                                break;
                            }
                        } else if (macthType == "offset") {
                            if (!hTrade.split(",")[1].equals(sTrade.split(",")[1])) {
                                hTradeRemove.add(i);
                                sTradeRemove.add(j);
                                break;
                            }
                        }
                    }
                }
                
                // update list with remaining trades after matches
                houseMap.put(key, getRemainList(hTrades, hTradeRemove));
                streetMap.put(key, getRemainList(sTrades, sTradeRemove));
            }
        }
    }
     
    private static List<String> getRemainList(List<String> original, List<Integer> remove) {
        List<String> remain = new ArrayList<>();
        for (int i = 0; i < original.size(); i++) {
            if (remove.contains(i)) continue;
            remain.add(original.get(i));
        }
        return remain;
    }
    
    // build Map<"symbol+quantity", Map<"whole trade", count>>
    private static Map<String, List<String>> getTradeMap(String[] trades) {
        Map<String, List<String>> tradeMap = new HashMap<>();
        for (String trade : trades) {
            String[] parts = trade.split(",");  // AAPL,S,0010,ZYX444
            String symbol = parts[0];
            String quantity = parts[2];
            String key = symbol + " " + quantity;
            tradeMap.putIfAbsent(key, new ArrayList<>());
            tradeMap.get(key).add(trade);
        }
        return tradeMap;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        String[] houseTrades = {
            "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"
        };
        String[] streetTrades = {
            " FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"
        };
        System.out.println("Test case 0: " + getUnMatchOrders(houseTrades, streetTrades));

        houseTrades = new String[] {
            "AAPL,B,0100,ABC123",
            "GOOG,S,0050,CDC333"
        };
        streetTrades = new String[] {
            "  FB,B,0100,GBGGGG", 
            "AAPL,B,0100,ABC123"
        };
        System.out.println("Test case 1: " + getUnMatchOrders(houseTrades, streetTrades));
        
        houseTrades = new String[] {
            "AAPL,S,0010,ZYX444", 
            "AAPL,S,0010,ZYX444", 
            "AAPL,B,0010,ABC123", 
            "GOOG,S,0050,GHG545"
        };
        streetTrades = new String[] {
            "GOOG,S,0050,GHG545", 
            "AAPL,S,0010,ZYX444", 
            "AAPL,B,0010,TTT222"
        };
        System.out.println("Test case 2: " + getUnMatchOrders(houseTrades, streetTrades));
        
        houseTrades = new String[] {
            "AAPL,B,0010,ABC123", 
            "AAPL,S,0015,ZYX444", 
            "AAPL,S,0015,ZYX444", 
            "GOOG,S,0050,GHG545"
        };
        streetTrades = new String[] {
            "GOOG,S,0050,GHG545", 
            "AAPL,S,0015,ZYX444", 
            "AAPL,B,0500,TTT222"
        };
        System.out.println("Test case 3: " + getUnMatchOrders(houseTrades, streetTrades));
        
        houseTrades = new String[] {
            "AAPL,B,0100,ABC123", 
            "AAPL,B,0100,ABC123", 
            "AAPL,B,0100,ABC123", 
            "GOOG,S,0050,CDC333"
        };
        streetTrades = new String[] {
            "  FB,B,0100,GBGGGG", 
            "AAPL,B,0100,ABC123"
        };
        System.out.println("Test case 4: " + getUnMatchOrders(houseTrades, streetTrades));
        
        houseTrades = new String[] {
            "AAPL,B,0100,ABC123", 
            "AAPL,B,0100,ABC123", 
            "AAPL,B,0100,ABC123", 
            "GOOG,S,0050,CDC333"
        };
        streetTrades = new String[] {
            "  FB,B,0100,GBGGGG", 
            "AAPL,B,0100,ABC123", 
            "AAPL,B,0100,ABC123", 
            "GOOG,S,0050,CDC333",
            "AAPL,S,0100,ABC124"
        };
        // with offset pair
        System.out.println("Test case 5: " + getUnMatchOrders(houseTrades, streetTrades));
        
        houseTrades = new String[] {
            "AAPL,B,0010,ABC123",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "GOOG,S,0050,GHG545"
        };
        streetTrades = new String[] {
            "GOOG,S,0050,GHG545",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,B,0500,TTT222"
        };
        System.out.println("Test case 6 (leetcode discuss): " + getUnMatchOrders(houseTrades, streetTrades));
    }
}
