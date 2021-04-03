package DataStructure.Array;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:  //https://www.baeldung.com/java-kth-largest-element
 * Solution
 */

public class _215_KthLargestElementinanArray_QuickSort_MinHeap_Sort {

    public static void main(String[] args){
//        findKthLargest_quickselect(new int[]{2,3,4,7,5,6,1}, 3);
        findKthLargest_quickselect(new int[]{3,2,4,7,7,}, 3);
    }
    // sorting O(nlogn)
    public int findKthLargest_lib(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //O(nlogk) running time + O(k) memory
    public static int findKthLargest_heap(int[] nums, int k) {
        //给定数组，超出第k大的数
        //思路:利用stack实现，stack中始终保存着k个数据，每次和stack中最小的进行类比，比其大就替换，最后stack中最小的就是结果了
        //PriorityQueue是一个基于优先级堆，此队列的头相对于指定的排序是最小的元素。

        //一个具有指定的初始容量。并且按自然排序。
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            } else {
                //集合中已经存在k个元素
                //判断是否小于最小值
                int a = minHeap.peek();
                if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }

        //最小的就是第k个结果
        return minHeap.peek();
    }

    //QuickSelect Algorithm, O(N) time , O(N^2) worst time, O(1) swap space cost

    //we don’t actually need to sort the entire array — we only need to rearrange its contents so that the kth element of the array is the kth largest or smallest.
    //In QuickSort, we pick a pivot element and move it to its correct position. We also partition the array around it. In QuickSelect, the idea is to stop at the point where the pivot itself is the kth largest element.
    /**
     * Let's look at the basic ideas of the QuickSelect algorithm:
     *
     * Pick a pivot element and partition the array accordingly
     * Pick the rightmost element as pivot
     * Reshuffle the array such that pivot element is placed at its rightful place — all elements less than the pivot would be at lower indexes, and elements greater than the pivot would be placed at higher indexes than the pivot
     * If pivot is placed at the kth element in the array, exit the process, as pivot is the kth largest element
     * If pivot position is greater than k, then continue the process with the left subarray, otherwise, recur the process with right subarray
     *
     * */
    public static int findKthLargest_quickselect(int[] nums, int k) {
        int a = quicksort(nums, 0, nums.length - 1, k);
        return a;
    }

    public static int quicksort(int[] nums, int start, int end, int k) {
        int low = start, pivot = nums[end];
        for (int i = start; i < end; i++){
            if (nums[i] <= pivot) {
                swap(nums, low++, i);
            }
        }

        swap(nums, low, end);
        if (low == nums.length - k) {
            return nums[low];
        } else if (low > nums.length - k){
            return quicksort(nums, start, low - 1, k);
        } else {
            return quicksort(nums, low, end, k);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int cur = nums[i];
        nums[i] = nums[j];
        nums[j] = cur;
    }

}
