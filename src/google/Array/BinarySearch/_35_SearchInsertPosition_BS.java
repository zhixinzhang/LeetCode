package google.Array.BinarySearch;

/**
 * Created by zhang on 2018/8/11.
 */
public class _35_SearchInsertPosition_BS {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0, right = nums.length-1;
        int mid;
        // 1,3,5,6,8   k = 7
        while(left < right){
            mid = (right + left) / 2;
            if (nums[mid] <= target){
                left = mid+1;
            }
            if (nums[mid] > target){
                right = mid;
            }
        }
        return left;
    }
}
