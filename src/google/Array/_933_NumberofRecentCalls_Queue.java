package google.Array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 11/20/18
 * Time: 2:53 PM
 * Description:
 */


public class _933_NumberofRecentCalls_Queue {
    Queue<Integer> q;

    public _933_NumberofRecentCalls_Queue() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) { q.poll(); }
        return q.size();
    }
}
