package company.uber;
import java.util.*;

//https://www.baeldung.com/java-kth-largest-element
public class _215_kthlargestelementinanarray_quickselect{
    // sorting O(nlogn)
	public int findKthLargest_lib(int[] nums, int k) {
			Arrays.sort(nums);
			return nums[nums.length - k];
	}

	//O(nlogk) running time + O(k) memory
	 public int findKthLargest_heap(int[] nums, int k) {
        //给定数组，超出第k大的数
        //思路:利用stack实现，stack中始终保存着k个数据，每次和stack中最小的进行类比，比其大就替换，最后stack中最小的就是结果了
        //PriorityQueue是一个基于优先级堆，此队列的头相对于指定的排序是最小的元素。
        
        //一个具有指定的初始容量。并且按自然排序。
        PriorityQueue<Integer> largeK=new PriorityQueue<Integer>();
        for(int n:nums){
            if(largeK.size()<k){
                largeK.add(n);
            }else{
                //集合中已经存在k个元素
                //判断是否小于最小值
                if(n>largeK.peek()){
                    largeK.poll();
                    largeK.add(n);
                }
            }
        }
        //最小的就是第k个结果
        return largeK.poll();
    }

	//QuickSelect Algorithm, O(N) time , O(N^2) worst time, O(1) swap space cost

    //we don’t actually need to sort the entire array — we only need to rearrange its contents so that the kth element of the array is the kth largest or smallest.
    //In QuickSort, we pick a pivot element and move it to its correct position. We also partition the array around it. In QuickSelect, the idea is to stop at the point where the pivot itself is the kth largest element.

    public static int findKthLargest_quickselect(int[] nums, int k) {
	    return quicksort(nums, 0, nums.length - 1, k);
    }
    public static int quicksort(int[] nums, int start, int end, int k) {
        int low = start;
        int pivot = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                exchange(nums, low++, i);
            }
        }
        // find correct position
        exchange(nums, low, end);
        if (low == nums.length - k) {
            return nums[low];
        }
        else if (low > nums.length - k) {
            return quicksort(nums, start, low - 1, k);
        }
        else {
            return quicksort(nums, low + 1, end, k);
        }
    }
    public static void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args){
	    int[] arr = new int[]{8,2,1,4,7,3,6,5};
	    findKthLargest_quickselect(arr,3);
    }
}