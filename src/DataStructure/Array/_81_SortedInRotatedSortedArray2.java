package DataStructure.Array;

/**
 * Created by zhang on 2017/10/13.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 */
/*存在重复的元素  3 1 2 2 2      target 1
* */
public class _81_SortedInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            return false;
        }
        int start = 0;
        int end = nums.length-1;
        if (nums[start] == target || nums[end] == target){
            return true;
        }
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target || nums[start] == target || nums[end] == target){
                return true;
            }

            if (nums[mid] > nums[start]){
                if (target >= nums[start] && target < nums[mid]){
                    end = mid;
                }else {
                    start = mid;
                }
            }else if(nums[mid] < nums[start]){
                if (target <= nums[start] && target > nums[mid]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                start ++;
            }

        }

        return false;
    }

}
