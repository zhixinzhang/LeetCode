package DataStructure.Design;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/13/2021 2:21 PM
 * <p>
 * Source Link:
 * <p> https://leetcode.com/problems/design-hit-counter/
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _362_DesignHitCounter_Queue {
    Deque<int[]> deque;
    int count;
    /** Initialize your data structure here. */
    public _362_DesignHitCounter_Queue() {
        int count = 0;
        deque = new ArrayDeque<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (deque.isEmpty()) {
            deque.add(new int[]{timestamp, 1});
        } else {
            if (deque.peekLast()[0] == timestamp) {
                deque.peekLast()[1]++;
            } else {
                deque.add(new int[]{timestamp, 1});
            }
        }

        count++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.peekFirst()[0] + 300 <= timestamp){
            count -= deque.pollFirst()[1];
        }

        return count;
    }
}
