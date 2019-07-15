package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/6/19
 * Time: 5:19 PM
 * Description:
 */


public class _704_BinarySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int lo = 0, hi = nums.length-1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return -1;
    }
}
