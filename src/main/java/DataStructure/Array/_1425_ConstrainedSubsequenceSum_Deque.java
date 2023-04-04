package DataStructure.Array;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Update res[i],
where res[i] means the maximum result you can get if the last element is A[i].

I directly modify on the input A,
if you don't like it,
use a copy of A

Keep a decreasing deque q,
deque[0] is the maximum result in the last element of result.

If deque[0] > 0. we add it to A[i]

In the end, we return the maximum res.
 * 
 * 
*/
public class _1425_ConstrainedSubsequenceSum_Deque {
    public int constrainedSubsetSum(int[] A, int k) {
        int res = A[0];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length; ++i) {
            A[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, A[i]);
            while (!q.isEmpty() && A[i] > q.peekLast())
                q.pollLast();
            if (A[i] > 0)
                q.offer(A[i]);
            if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
                q.poll();
        }
        return res;
    }
}
