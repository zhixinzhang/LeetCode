package DataStructure.Array;


import java.util.PriorityQueue;

/**
 * Created by zhang on 2017/10/24.
 */
/**minHeap方法  创建一个minHeap k size 然后一次替换minheap的peek   O(nlogk)
 * */
public class _215_KthLargestElementinanArray_minHeap {
	//O(nlogk)
    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
        int res = Integer.MIN_VALUE;
        if (nums.length == 0)
            return res;
        PriorityQueue<MinNodeHeap> minHeap = new PriorityQueue<>();
        //maintain a maxHeap size k
        for (int i = 0; i< k; i++){
            minHeap.add(new MinNodeHeap(i,nums[i]));
        }
        for (int i = k ;i<nums.length;i++){
            MinNodeHeap curNode = minHeap.peek();
            if (nums[i] > minHeap.peek().val){
                minHeap.poll();
                minHeap.offer(new MinNodeHeap(i,nums[i]));
            }
        }
        return minHeap.poll().val;
    }
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
//        int[] nums = {3,2,1};
        int k = 2;
        int a = findKthLargest(nums,k);
        int c = 0;
    }

    //use quick sort  O(nlogn)
        public int findKthLargest_QS(int[] nums, int k) {
			if(nums == null || nums.length == 0) return 0;
			// 3 2 1 5 6 4
			int left = 0;
			int right = nums.length-1;
			while(true){
				int pos = partition(nums,left,right);
				if (pos+1 == k) {
					return nums[pos];
				}else if(pos+1>k){
					right = pos-1;
				}else{
					left = pos +1;
				}
			}

		}
		private int partition(int[] nums,int left, int right){
			int pivot = nums[left];
			int l = left + 1;
			int r = right;
			while(l<=r){
				if(nums[l]<pivot && nums[r]>pivot){
					swap(nums,l++,r--);
				}
				if(nums[l]>=pivot) l++;
				if(nums[r]<=pivot) r--;
			}
			swap(nums,l,r);
			return r;
		}
		private void swap(int[] nums,int i, int j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}


}
