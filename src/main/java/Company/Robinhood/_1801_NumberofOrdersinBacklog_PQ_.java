package Company.Robinhood;
import java.util.*;


public class _1801_NumberofOrdersinBacklog_PQ_ {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int[] o : orders) {
            if (o[2] == 0) { // processing buy orders:
                    while (!sell.isEmpty() && o[0] >= sell.peek()[0] && o[1] >= sell.peek()[1]) {
                        o[1] -= sell.peek()[1];
                        sell.poll();
                    }
                    if (!sell.isEmpty() && o[0] >= sell.peek()[0] && o[1] > 0) {
                        sell.peek()[1] -= o[1];
                        o[1] = 0;
                    }
                    if (o[1] > 0) {
                        buy.offer(o);
                    }
            } else { // processing sell orders:
                    while (!buy.isEmpty() && o[0] <= buy.peek()[0] && o[1] >= buy.peek()[1]) {
                        o[1] -= buy.peek()[1];
                        buy.poll();
                    }
                    if (!buy.isEmpty() && o[0] <= buy.peek()[0] && o[1] > 0) {
                        buy.peek()[1] -= o[1];
                        o[1] = 0;
                    }
                    if (o[1] > 0) {
                        sell.offer(o);
                    }
                }                
        }
        long res = 0;
        for (int[] o : sell) {
            res += o[1];
        }
        for (int[] o : buy) {
            res += o[1];
        }
        return (int)(res % 1000000007);
    }
}
