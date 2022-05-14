package Search;

/**
 * Created by zhang on 2017/3/14.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 */
public class SearchinRotatedSort81 {
    public static boolean search(int[] nums, int target) {
        int fast = 0;
        int last = nums.length;
        while (fast != last){
            int mid = fast+(last-fast)/2;
            if(nums[mid] == target){
                return  true;
            }
            if (nums[fast] < nums[mid]){
                if (nums[fast] <= target && target<nums[mid]){
                    last = mid;
                }else{
                    fast = mid+1;
                }
            }else if (nums[fast] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last-1])
                    fast = mid + 1;
                else
                    last = mid;
            } else
//skip duplicate one
                fast++;
        }
        return false;
    }
    public static  void main(String[] args){
        int[] nums= {1,2,3,1,1,1,1};
        search(nums,4);
    }
}
