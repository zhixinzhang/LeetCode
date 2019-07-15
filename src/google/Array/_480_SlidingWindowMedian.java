package google.Array;
import java.util.*;
/**
 * Created by zhang on 2018/6/3.
 * https://blog.csdn.net/mebiuw/article/details/54408831
 */
public class _480_SlidingWindowMedian {
    public static double[] medianSlidingWindow_PQ(int[] nums, int k){
        int n = nums.length;
        int m = n - k + 1;
        double[] res = new double[m];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);    // 1 2 3
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,Collections.reverseOrder());// 3 2 1
        for (int i = 0; i<n;i++){
            int num = nums[i];
            //1,3,-1,-3   max 1 -1   -3     min 3
            // 让maxHeap始终保存小于一半的值，minHeap保存大于一半的，正好两半
            if (maxHeap.size() == 0 || maxHeap.peek() >= num){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            // balance the max min pq
            if( minHeap.size() > maxHeap.size() )
                maxHeap.add(minHeap.poll());
            if( maxHeap.size() > minHeap.size() + 1 )
                minHeap.add(maxHeap.poll());
            if ( i-k+1 >=0 ){
                if( k % 2 == 1 )
                    res[i- k + 1] = maxHeap.peek();
                else
                    res[i- k + 1] = (maxHeap.peek()/2.0 + minHeap.peek()/2.0); // 小心溢出
                //移除并更新
                int toBeRemove = nums[i - k + 1];
                if( toBeRemove <= maxHeap.peek())
                    maxHeap.remove(toBeRemove);
                else minHeap.remove(toBeRemove);
                // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
                if( minHeap.size() > maxHeap.size() )
                    maxHeap.add(minHeap.poll());
                if( maxHeap.size() > minHeap.size() + 1 )
                    minHeap.add(maxHeap.poll());

            }
        }
        return res;
    }


    // O((n-k) * klogk)   O(n) 这种方法自己写的 不是最优方法
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        HashMap<int[], Double> memo = new HashMap<>();
        int[] curArray = new int[k];
        for(int i = 0; i<k;i++){
            curArray[i] = nums[i];
        }
        Arrays.sort(curArray);
        double med = helper(curArray,k);
        res[0] = med;
        memo.put(curArray,med);
        int right = 0;
        int curIndex = 0;
        for(int i = 1; i < nums.length; i++){
            right = i + k -1;
            if(right > nums.length) break;
            // 1 3 -1 -3 5 6 3
            // 1 3 -1 /0   -3 3 -1 /1  -3 5 -1 /2  -3 5 6 /3
            if(curIndex > k)
                curIndex = 0;
            int[] cloArray = curArray.clone();
            cloArray[curIndex] = nums[right];
            curIndex++;
            Arrays.sort(cloArray);
            if(memo.containsKey(cloArray)){
                res[i] = memo.get(cloArray);
            }else{
                med = helper(cloArray,k);
                memo.put(cloArray,med);
                res[i] = med;
            }
            int a = 0;
        }
        return res;
    }
    private static double helper(int[] curArray, int k){
        double res = 0;
        if(k%2 == 1){
            res = (double)curArray[k/2];
        }else{
            res = (double)(curArray[k/2]+ curArray[k/2 - 1])/2;
        }
        return res;
    }
    public static void main(String[] args){
        medianSlidingWindow(new int[]{1,3,-1,-3,5,8,6,7}, 3);
        // k = 5  1 3 -1 -3 5   -3 -1 1 3 5  med = 1
        // -3 -1  maxHeap   3 4 5             1 2 3 4 5
        // 3 5 minHeap      1 2
        // -3 -1 3 5
    }
}
