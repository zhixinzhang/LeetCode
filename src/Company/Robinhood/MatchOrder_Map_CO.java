package Company.Robinhood;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Luke Zhang
 * @Date 2021-07-21 22:07
 */
public class MatchOrder_Map_CO {
    public static void main(String[] args) {

        List<String> houseTrades1 = Arrays.asList(
            "AAPL,B,0100,ABC123",
            "GOOG,S,0050,CDC333");
        List<String> streetTrades1 = Arrays.asList(
            "  FB,B,0100,GBGGGG",
            "AAPL,B,0100,ABC123");

        List<String> houseTrades2 = Arrays.asList(
            "AAPL,S,0010,ZYX444",
            "AAPL,S,0010,ZYX444",
            "AAPL,B,0010,ABC123",
            "GOOG,S,0050,GHG545");
        List<String> streetTrades2 = Arrays.asList(
            "GOOG,S,0050,GHG545",
            "AAPL,S,0010,ZYX444",
            "AAPL,B,0010,TTT222");

        List<String> houseTrades3 = Arrays.asList("AAPL,B,0010,ABC123",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "GOOG,S,0050,GHG545");
        List<String> streetTrades3 = Arrays.asList("GOOG,S,0050,GHG545",
            "AAPL,S,0015,ZYX444",
            "AAPL,B,0500,TTT222");

        List<String> houseTrades4 = Arrays.asList("AAPL,B,0100,ABC123",
            "AAPL,B,0100,ABC123",
            "AAPL,B,0100,ABC123",
            "GOOG,S,0050,CDC333");
        List<String> streetTrades4 = Arrays.asList("  FB,B,0100,GBGGGG",
            "AAPL,B,0100,ABC123");

        List<String> houseTrades5 = Arrays.asList(
            "AAPL,B,0010,ABC123",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "GOOG,S,0050,GHG545");
        List<String> streetTrades5 = Arrays.asList(
            "GOOG,S,0050,GHG545",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,B,0500,TTT222");


        List<String> houseTrades6 = Arrays.asList(
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444");
        List<String> streetTrades6 = Arrays.asList(
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444",
            "AAPL,S,0015,ZYX444");

        getUnMatchedTrades(houseTrades2, streetTrades2);

    }

   static void getUnMatchedTrades(List<String> houseTrades, List<String> streetTrades) {

        Map<String, List<String>> houseTradesObjMap = getTradeMap(houseTrades);
        Map<String, List<String>> streetTradesObjMap = getTradeMap(streetTrades);

        for (Map.Entry<String, List<String>> entry : houseTradesObjMap.entrySet()) {

            if (streetTradesObjMap.containsKey(entry.getKey())) {
                List<String> hTradeList = entry.getValue();
                List<String> sTradeList = streetTradesObjMap.get(entry.getKey());

                removeExactMatches(hTradeList, sTradeList);

                removeFuzzyMatches(hTradeList, sTradeList);

//                removeOffsetMatches(hTradeList, sTradeList);
            }
        }

        System.out.println("--------");
        System.out.println(getUnmatched(houseTradesObjMap, streetTradesObjMap));

    }

    // all 4 values match i.e. (symbol,type,quantity,id)
    static void removeExactMatches(List<String> houseTrades, List<String> streetTrades) {
        Collections.sort(houseTrades);
        Collections.sort(streetTrades);
        for (int i = 0; i < houseTrades.size(); ) {
            if (streetTrades.isEmpty() || houseTrades.isEmpty())
                break;
            for (int j = 0; j < streetTrades.size(); ) {

                if (houseTrades.get(i).equals(streetTrades.get(j))) {
                    houseTrades.remove(i);
                    streetTrades.remove(j);
                    // need to break or else get concurrent modification exception
                    break;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }

    // 3 values match i.e. (symbol,type,quantity)
    static  void removeFuzzyMatches(List<String> houseTrades, List<String> streetTrades) {
        for (int i = 0; i < houseTrades.size(); ) {
            if (streetTrades.isEmpty() || houseTrades.isEmpty())
                break;
            for (int j = 0; j < streetTrades.size();) {
                String[] hTradeVal = houseTrades.get(i).split(",");
                String[] sTradeVal = streetTrades.get(j).split(",");

                // only need to compare type as key is (symbol quantity) and already checked
                if (hTradeVal[1].equals(sTradeVal[1])) {
                    houseTrades.remove(i);
                    streetTrades.remove(j);
                    // need to break or else get concurrent modification exception
                    break;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }

    // 3 values match i.e. (symbol,type,quantity)
    // sort alphabetically and type should be different
    static void removeOffsetMatches(List<String> houseTrades, List<String> streetTrades) {

        Collections.sort(houseTrades);
        Collections.sort(streetTrades);

        for (int i = 0; i < houseTrades.size(); i++) {
            for (int j = 0; j < streetTrades.size(); j++) {
                String[] hTradeVal = houseTrades.get(i).split(",");
                String[] sTradeVal = streetTrades.get(j).split(",");

                // only need to compare type as key is (symbol quantity) and already checked
                if (!hTradeVal[1].equals(sTradeVal[1])) {
                    houseTrades.remove(i);
                    streetTrades.remove(j);
                    // need to break or else get concurrent modification exception
                    break;
                }
            }
        }
    }

    static List<String> getUnmatched(Map<String, List<String>> houseTradesObjMap, Map<String, List<String>> streetTradesObjMap) {
        List<String> result = new ArrayList<>();

        result.addAll(houseTradesObjMap.values().stream().flatMap(List::stream).collect(Collectors.toList()));
        result.addAll(streetTradesObjMap.values().stream().flatMap(List::stream).collect(Collectors.toList()));

        Collections.sort(result);
        return result;
    }

    // build a map of key (symbol quantity) -> value (symbol,type,quantity,id)
   static Map<String, List<String>> getTradeMap(List<String> trades) {

        Map<String, List<String>> tradeObjMap = new HashMap<>();
        for (String trade : trades) {
            String[] values = trade.split(",");
            String symbol = values[0];
            String quantity = values[2];
            String key = symbol + " " + quantity;
            tradeObjMap.putIfAbsent(key, new ArrayList<>());
            tradeObjMap.get(key).add(trade);
        }
        return tradeObjMap;
    }
}
