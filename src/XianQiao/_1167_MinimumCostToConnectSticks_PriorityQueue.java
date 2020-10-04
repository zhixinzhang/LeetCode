package XianQiao;

/**
 * @Author: Xianqiao
 * @Date: 7/26/20 16:25
 */

import java.util.PriorityQueue;

/** You have some sticks with positive integer lengths.
 You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.
 You perform this action until there is one stick remaining.
 Return the minimum cost of connecting all the given sticks into one stick in this way.

 Example 1:
 Input: sticks = [2,4,3]
 Output: 14
 */

public class _1167_MinimumCostToConnectSticks_PriorityQueue {
/** We always want to add the smallest two sticks together (which means you add up the smallest components for the most times). */
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int cost = 0;

        for (int stick : sticks) {
            q.add(stick);
        }
        //until there is only one stick remaining, so check if the # sticks > 1.
        while (q.size() > 1) {
            int stick1 = q.poll();
            int stick2 = q.poll();
            cost += stick1 + stick2;
            q.add(stick1 + stick2);
        }
        return 0;
    }
}
