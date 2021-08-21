package Company.LinkedIn;

/**
 * Created by zhang on 2017/10/8.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 */
/*重点是 找到mid 用binary search  time com  log（n）
 * */
public class _33_SearchInRotatedSortedArray_BinarySearch {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
