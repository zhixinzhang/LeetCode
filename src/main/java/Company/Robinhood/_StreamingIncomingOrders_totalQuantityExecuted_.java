package Company.Robinhood;
import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/1052406/Robinhood-telephonic-interview.Reject
 * https://leetcode.com/discuss/interview-question/1027102/Robinhood-or-Telephonic-round
 * @author Luke Zhang
 * @Date 2023-2-18
 * A "buy" order can be executed if there is a corresponding "sell" order with a price that is less than or
equal to the price of the "buy" order.
Similarly, a "sell" order can be executed if there is a corresponding "buy" order with a price that is
greater than or equal to the price of the "sell" order.
It is possible that an order does not execute immediately if it isn't paired to a counterparty. In that 
case, you should keep track of that order and execute it at a later time when a pairing order is found.
You should ensure that orders are filled immediately at the best possible price. That is, an order 
should be executed when it is processed, if possible. Further, "buy" orders should execute at the 
lowest possible price and "sell" orders at the highest possible price at the time the order is handled.

Note that orders can be partially executed.

--- Sample Input ---

orders = [
  ['150', '5', 'buy'],    # Order A
  ['190', '1', 'sell'],   # Order B
  ['200', '1', 'sell'],   # Order C
  ['100', '9', 'buy'],    # Order D
  ['140', '8', 'sell'],   # Order E
  ['210', '4', 'buy'],    # Order F
]
 * 
 * 
Maintain two PQs - sellPQ which has all the pending sell orders in a minHeap (because a buy order wants to be paired with the lowest priced pending sell order) 
and a buyPQ which has all the pending buy orders in a maxHeap (because a sell order wants to be paired with the highest priced pending buy order).
Process all the orders one at a time.
2a) If it is a SELL order:
i. Check if it can be executed or fulfilled by some pending buy order.
ii. If yes, execute the order by taking the min(shares needed to fulfill the current order, shares that can be fulfuilled by the topmost pending buy order)
iii. Add the remainder shares to the corresponding PQs for future orders.
2b) If it is a BUY order: Repeat the similar steps.
Repeat the process 2 for all the orders.
*/
public class _StreamingIncomingOrders_totalQuantityExecuted_ {
    // MaxHeap, max Order price on top
    static PriorityQueue<Order> buyQ = new PriorityQueue<>(new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2){
            return o2.price - o1.price;
        }
    });
    // MinHeap, min Order price on top
    static PriorityQueue<Order> sellQ = new PriorityQueue<>(new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2){
            return o1.price - o2.price;
        }
    });

    static class Order{
        String side;
        int qty;
        int price;
        public Order(String s, int q, int p){
            this.side = s;
            this.qty = q;
            this.price = p;
        }
    }

    public static void main(String[] args){
        String[][] orders = {
            {"150", "5", "buy"},    // Order A
            {"170", "5", "buy"},    // Order A
            {"190", "1", "sell"},   // Order B
            {"200", "1", "sell"},   // Order C
            {"100", "9", "buy"},    // Order D
            {"140", "8", "sell"},   // Order E
            {"210", "4", "buy"},    // Order F
        };
        System.out.println(getMaxShares(orders));
    }

    private static int getMaxShares(String[][] orders){
        if (orders == null || orders.length == 0) {
            return 0;
        }

        int totalShares = 0;
        for (String[] order : orders){
            int price = Integer.parseInt(order[0]);
            int qty = Integer.parseInt(order[1]);
            String side = order[2];

            Order o = new Order(side, qty, price);
            if (side.equals("buy")){
                buyQ.add(o);
            } else {
                sellQ.add(o);
            }

            while (!buyQ.isEmpty() && !sellQ.isEmpty()){
                Order buyOrder = buyQ.poll(); 
                Order sellOrder = sellQ.poll(); 
                if(buyOrder.price >= sellOrder.price){
                    int shares = Math.min(buyOrder.qty , sellOrder.qty);
                    buyOrder.qty -= shares ; 
                    sellOrder.qty -= shares; 
                    totalShares += shares ; 
                    if(buyOrder.qty > 0){
                        buyQ.add(buyOrder); 
                    }
                    if(sellOrder.qty > 0){
                        sellQ.add(sellOrder);
                    }
                } else {
                    buyQ.add(buyOrder);
                    sellQ.add(sellOrder);
                    break ; 
                }
            }
        }


        return totalShares;
    };
}
