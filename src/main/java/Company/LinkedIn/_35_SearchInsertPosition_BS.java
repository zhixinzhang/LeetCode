package Company.LinkedIn;

/**
 * Created by zhang on 2018/8/11.
 */
public class _35_SearchInsertPosition_BS {
    public int searchInsert(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot])
                right = pivot - 1;
            else
                left = pivot + 1;
        }
        return left;
    }
}
