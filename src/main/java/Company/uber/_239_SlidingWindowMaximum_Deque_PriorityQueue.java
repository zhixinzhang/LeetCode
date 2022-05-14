package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/6.
 *
 *
 *
 * 对于PQ 时间复杂度
 * remove() -> This is to remove the head/root, it takes O(logN) time.
 *
 * remove(Object o) -> This is to remove an arbitrary object. Finding this object takes O(N) time, and removing it takes O(logN) time.
 */
public class _239_SlidingWindowMaximum_Deque_PriorityQueue {
    public static void main(String[] args){
//        maxSlidingWindow_DQ(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//        maxSlidingWindow_Deque(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        maxSlidingWindow_pq(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        maxSlidingWindow_sort(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        maxSlidingWindow_followUP(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    // 用一个 Deque 维持一个array值持续递减的

    private static int[] maxSlidingWindow_Deque(int[] nums, int k) {
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

    // 我觉得不是O(n) 但这个解法最优 感觉像是brute force
    public static int[] maxSlidingWindow_DQ(int[] nums, int k){
        if(nums == null || nums.length <= 1 || k == 1)
            return nums;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] res = new int[n - k + 1];
        // Init
        for(int i = 0; i < k; ++i) {
            max = Math.max(max, nums[i]);
        }
        res[0] = max;
        // Search
        for(int i = k; i < n; ++i) {
            if(nums[i] >= max) {
                max = nums[i];
            } else if(nums[i - k] == max) {
                max = Integer.MIN_VALUE;
                for(int j = i-k+1; j <= i; j++) {
                    max = Math.max(max, nums[j]);
                }
            }
            res[i-k+1] = max;
        }
        return res;
    }

    // n * n * log(k)  用最大堆
    public static int[] maxSlidingWindow_pq(int[] nums, int k){
        if(nums == null || nums.length == 0)
            return nums;
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b - a));
        for (int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        res[0] = pq.peek();
        for (int i = k; i < nums.length; i++){
            pq.remove(nums[i - k]);       // n * log n  find object used O(n) time, remove use logn time
            pq.add(nums[i]);
            res[i-k+1] = pq.peek();
        }
        return res;
    }


    //TLE  n * k * klogk
    public static int[] maxSlidingWindow_sort(int[] nums, int k){
        if(nums == null || nums.length == 0)
            return nums;
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        LinkedList<Integer> curList = new LinkedList<>();
        for (int i = 0; i < k; i++){
            max = Math.max(nums[i],max);
            curList.add(nums[i]);
        }
        res[0] = max;
        for (int i = 1;i + k - 1< nums.length; i++){
            LinkedList<Integer> temp = new LinkedList<>(curList);
            temp.removeFirst();
            temp.add(nums[i+k-1]);
            curList = new LinkedList<>(temp);
            Collections.sort(temp);
            res[i] = temp.get(k-1);
        }
        return res;
    }


    //返回最大的窗户
    public static int[] maxSlidingWindow_followUP(int[] nums, int k) {
        int[] res = new int[k];
        LinkedList<Integer> curMax = new LinkedList<>();
        if(k >= nums.length)
            return nums;
        int sum = 0;
        for(int i = 0; i<k;i++){
            curMax.add(nums[i]);
            sum += nums[i];
        }
        LinkedList<Integer> temp = new LinkedList<>(curMax);
        int tempSum = sum;
        for(int i = 1; i + k - 1 < nums.length; i++){
            if (tempSum - temp.get(0) + nums[i+k-1] < sum){
                tempSum = tempSum - temp.getFirst() + nums[i+k-1];
                temp.removeFirst();
                temp.addLast(nums[i+k-1]);
            }else{
                sum = tempSum - temp.get(0) + nums[i+k-1];
                tempSum = sum;
                temp.removeFirst();
                temp.addLast(nums[i+k-1]);
                curMax = new LinkedList<>(temp);
            }
        }
        for (int i = 0; i < k; i++){
            res[i] = curMax.getFirst();
            curMax.removeFirst();
        }
        return res;
    }
}
