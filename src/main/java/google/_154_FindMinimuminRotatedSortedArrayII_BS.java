package google;

/**
 * Created by zhang on 2017/12/7.
 */
public class _154_FindMinimuminRotatedSortedArrayII_BS {
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            //0 2 2 2 2 2 2 2 2
            //2 2 2 2 2 2 2 0 2
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
            }
        }
        return nums[l];
    }

}
