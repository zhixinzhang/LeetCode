package google.Array;

/**
 * Created by zhang on 2018/6/21.
 */
public class _215_KthLargestElementinanArray_PQ_QucikSelect {
    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        return qucikSelect(nums, 0, nums.length - 1, k);
    }
    //  2 3 4 1 6 5    -  1 2 3 4 5 6   k = 2  return 5
    //  pivot = 2 first switch  1 3 4 2 6 5  -   1 2 4 3 6 5
    public static int qucikSelect(int[] nums, int start, int end, int k){
        int low = start;       // 0
        int pivot = nums[end]; // 5
        for(int i = start; i < end; i++){
            if(nums[i] <= pivot)
                swap(nums, low++, i);
        }
        swap(nums, low, end);
        if (low == nums.length - k) {
            return nums[low];
        }
        else if (low > nums.length - k) {
            return qucikSelect(nums, start, low - 1, k);
        }
        else {
            return qucikSelect(nums, low + 1, end, k);
        }

    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        int a = 0;
    }
    public static void main(String[] args){
        findKthLargest(new int[]{6,3,4,1,5,2},2);
        /** result  1 2 4 6 5 3
         *  6 3 4 1 5 2 -  2 3 4 1 5 6 - 1 3 4 2 5 6 - 1 2 4
         *
         *
         * */
    }
}
