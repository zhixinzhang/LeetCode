package Company.Robinhood;
import java.util.*;

// https://www.1point3acres.com/bbs/thread-963155-1-1.html
// https://www.1point3acres.com/bbs/thread-831063-1-1.html
// 
/**
 * You are given an array of orders like this:
[["Buy", 20, "AAPL", "$10"], ["Sell", 19, "AAPL", "$9"], ...]
复制代码
Assume there is no sales commission and they are in chronological order. 
If a buy order is placed and there are sell orders, 
then fill the buy order using the sell orders based on price from lowest to highest.
If a sell order is placed and there are buy orders, then fill the sell order using the buy orders based
 on price from highest to lowest.
1. Return the total profit that will go to sellers using these rules.
Follow up:
2. The rules have changed. Now when buy order comes, you fill it using the earliest remaining sell 
order whose price is <= buy order price. For sell orders, you fill them using the earliest remaining buy
 orders whose price is >= the sell order price.
*/
public class _Stock_totalProfitExecuted_ {
    static class Order{
        int price;
        int shares;
        String operation;

        public Order(String s, int q, int p){
            this.operation = s;
            this.shares = q;
            this.price = p;
        }
    }
    public static void main(String[] args){
        String[][] orders = {
            {"buy", "5", "AAPL", "$150"},    // Order A
            {"sell", "1", "AAPL", "$190"},
            {"sell", "1", "AAPL", "$200"},
            {"buy", "9", "AAPL", "$100"},
            {"sell", "8", "AAPL", "$140"},
            {"buy", "4", "AAPL", "$210"}
        };

        getMaxProfit(orders);

        String[][] orders2 = {
            {"buy", "5", "AAPL", "$150"},    // Order A
            {"sell", "1", "AAPL", "$190"},
            {"sell", "1", "AAPL", "$200"},
            {"buy", "9", "AAPL", "$100"},
            {"sell", "8", "AAPL", "$140"},
            {"buy", "4", "AAPL", "$210"}
        };
        getMaxProfitBasedOnTime(orders2);

        String[][] orders3 = {
            {"buy", "5", "AAPL", "$200"},    // Order A
            {"sell", "5", "AAPL", "$190"},
            {"sell", "5", "AAPL", "$190"},
            {"buy", "5", "AAPL", "$180"}, 
            {"buy", "3", "AAPL", "$210"},
            {"buy", "3", "AAPL", "$220"}
        };
        getMaxProfit(orders3);

        String[][] orders4 = {
            {"buy", "5", "AAPL", "$200"},    // Order A
            {"sell", "5", "AAPL", "$190"},
            {"sell", "5", "AAPL", "$190"},
            {"buy", "5", "AAPL", "$180"}, 
            {"buy", "3", "AAPL", "$210"},
            {"buy", "3", "AAPL", "$220"}
        };
        getMaxProfitBasedOnTime(orders4);
    }

    private static void getMaxProfit(String[][] orders){
        HashMap<String, List<Order>> map = new HashMap<>();
        for (String[] order : orders){
            String curStock = order[2];
            map.putIfAbsent(curStock, new ArrayList<>());
            int shares = Integer.valueOf(order[1]);
            int price = Integer.valueOf(order[3].substring(1, order[3].length()));
            Order ord = new Order(order[0], shares, price);
            map.get(curStock).add(ord);
        }

        for (String stock : map.keySet()){
            List<Order> orderList = map.get(stock);
            int[] ans = calculateProfit(orderList);
            System.out.println("current stock is : " + stock + "  shares : " 
            + String.valueOf(ans[0]) + "  profits :  " + String.valueOf(ans[1]));
        }
    }


    private static int[] calculateProfit(List<Order> orders){
        int totalShares = 0;
        int maxProfix = 0;
        PriorityQueue<Order> buyQ = new PriorityQueue<>(new Comparator<Order>() {   // max heap
            @Override
            public int compare(Order o1, Order o2){
                return o2.price - o1.price;
            }
        }); 
        PriorityQueue<Order> sellQ = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2){
                return o1.price - o2.price;
            }
        }); // min Heap

        for (Order order : orders){
            if (order.operation == "buy"){
                buyQ.add(order);
            } else {
                sellQ.add(order);
            }


            while (!buyQ.isEmpty() && !sellQ.isEmpty()){
                Order buyOrder = buyQ.poll(); 
                Order sellOrder = sellQ.poll(); 
                if(buyOrder.price >= sellOrder.price){
                    int shares = Math.min(buyOrder.shares , sellOrder.shares);
                    buyOrder.shares -= shares ; 
                    sellOrder.shares -= shares; 
                    totalShares += shares;
                    maxProfix += shares * (buyOrder.price - sellOrder.price); 
                    if(buyOrder.shares > 0){
                        buyQ.add(buyOrder); 
                    }
                    if(sellOrder.shares > 0){
                        sellQ.add(sellOrder);
                    }
                } else {
                    buyQ.add(buyOrder);
                    sellQ.add(sellOrder);
                    break ; 
                }
            }
        }

        
        return new int[]{totalShares, maxProfix};
    }

    private static void getMaxProfitBasedOnTime(String[][] orders){
        HashMap<String, List<Order>> map = new HashMap<>();
        for (String[] order : orders){
            String curStock = order[2];
            map.putIfAbsent(curStock, new ArrayList<>());
            int shares = Integer.valueOf(order[1]);
            int price = Integer.valueOf(order[3].substring(1, order[3].length()));
            Order ord = new Order(order[0], shares, price);
            map.get(curStock).add(ord);
        }

        for (String stock : map.keySet()){
            List<Order> orderList = map.get(stock);
            int[] ans = calculateProfitBasedOnTimeIterator(orderList);
            System.out.println("current stock is : " + stock + "  shares : " + String.valueOf(ans[0]) + "  profits :  " + String.valueOf(ans[1]));
        }
    }

    private static int[] calculateProfitBasedOnTimeIterator(List<Order> orders){
        int totalShares = 0;
        int maxProfix = 0;
        List<Order> buyList = new ArrayList<>();
        List<Order> sellList = new ArrayList<>();
        for (Order order : orders){
            if (order.operation == "buy"){
                if (!sellList.isEmpty()) {
                    Iterator<Order> it = sellList.iterator();
                    while(it.hasNext()){
                        Order sellOrder = it.next();
                        if (sellOrder.price <= order.price){
                            boolean shareCount = sellOrder.shares == order.shares ? true : false;
                            int shares = Math.min(sellOrder.shares, order.shares);
                            maxProfix += shares * (order.price - sellOrder.price);
                            totalShares += shares;
                            order.shares -= shares ; 
                            sellOrder.shares -= shares;
                            if(sellOrder.shares == 0){
                                it.remove();
                            }
                            if (shareCount) {
                                break;
                            }
                        }
                    }
                    if(order.shares > 0){
                        buyList.add(order); 
                    }
                } else {
                    buyList.add(order); 
                }
            } else {
                if (!buyList.isEmpty()) {
                    Iterator<Order> it = buyList.iterator();
                    while(it.hasNext()){
                        Order buyOrder = it.next();
                        if (buyOrder.price >= order.price){
                            boolean shareCount = buyOrder.shares == order.shares ? true : false;
                            int shares = Math.min(buyOrder.shares, order.shares);
                            maxProfix += shares * (order.price - buyOrder.price);
                            totalShares += shares;
                            order.shares -= shares ; 
                            buyOrder.shares -= shares;
                            if(buyOrder.shares == 0){
                                it.remove(); 
                            }
                            
                            if (shareCount) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }

                    if(order.shares > 0){
                        sellList.add(order);
                    }
                    
                } else {
                    sellList.add(order); 
                }
            }
        }

        
        return new int[]{totalShares, maxProfix};
    }
}
