package google.Array;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/19.
 * 类似692
 * pq   nlogk  但是更好的方法是O(n) 时间
 * bucket sort
 *
 *  解法3： 利用快速排序的思想，从数组S中随机找出一个元素X，把数组分为两部分Sa和Sb。Sa中的元素大于等于X，Sb中元素小于X。这时有两种情况：
 1. Sa中元素的个数小于k，则Sb中的第k-|Sa|个元素即为第k大数；
 2. Sa中元素的个数大于等于k，则返回Sa中的第k大数。时间复杂度近似为O(n)
 */
public class findKMostInteger_PQ {
    public int[] solution_PQ(int[] nums, int k){
        int[] res = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for (int i = 0;i < nums.length; i++){
            maxHeap.add(nums[i]);
        }
        int i = 0;
        while (!maxHeap.isEmpty() && i < k){
            res[i] = maxHeap.poll();
            i++;
        }
        return res;
    }

    public static int[] solution(int[] nums, int k) {
        //[1 1 2 2 3 3 3 4 5]
        //hm 1 -2   2-2  3 - 3  4 - 1
        if (nums == null || nums.length == 0) return null;
        int[] res = new int[k];
        int[] extra = new int[nums.length];
        // 1 1 1 1
        for (int i = 0; i<nums.length; i++){
            //
            int curI = nums[i];  // 1
            if (extra[curI] == 0)
                extra[curI] = 1;
        }
        for (int i = extra.length - 1; i >= 0; i--){
            if (extra[i] ==1){
                res[--k] = i;
                if (k == 0)
                    break;
            }

        }
        return res;
    }
        public static void main(String[] args){
            solution(new int[]{1,1,1,2,2,3,3,4,5},2);
    }
}
