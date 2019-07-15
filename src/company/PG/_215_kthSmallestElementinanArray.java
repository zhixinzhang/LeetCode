package company.PG;
import java.util.*;
//https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
/**
 * Created by zhang on 2018/1/29.
 */
// 1.sorting O(nlogn) n is the s.length()
//k size heap to store  element and
// O(nlogk) running time + O(k) memory
public class _215_kthSmallestElementinanArray {
    public static void main(String[] args){
        findKthSmallest(new int[]{3,4,5,2,1,7,8,9},3);
    }
    public static int findKthSmallest(int[] nums,int k){
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int n:nums){
            if(pq.size()<k){
                pq.add(n);
            }else{
                //集合中已经存在k个元素
                //判断是否小于最小值
                if(n < pq.peek()){
                    pq.poll();
                    pq.add(n);
                }
            }
        }
        res = pq.poll();
        return pq.poll();
    }
}
