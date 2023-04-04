package DataStructure.Array;
import java.util.*;

public class _239_SlidingWindowMaximum_Deque {
    public static void main(String[] args){
        maxSlidingWindow_DQ(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

     /**
     * Then we continuously remove the rightmost indices if their corresponding elements are less than nums[i] (the element we are about to insert). The idea is that the elements that are less than the element we'll insert won't have any contributions to the maximum element of the sliding window. So it is safe to remove them.

After removal pollLast() and insertion offerLast(i) (the element nums[i]), we can say that the leftmost element in the window is maximum. Think about it why. Notice that the maximum element could be the one we just insert.
    */

    private static int[] maxSlidingWindow_DQ(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n-k+1];
        int index = 0;

        // key point is store index in deque
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            // remove numbers out of range k
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // remove smaller numbers in k range as they are useless
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            // q contains index... r contains content
            dq.offerLast(i);
            if (i >= k - 1) {
                res[index++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
