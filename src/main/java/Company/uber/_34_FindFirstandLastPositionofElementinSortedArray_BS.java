package Company.uber;

/**
 * Created by zhang on 2018/9/18.
 */
public class _34_FindFirstandLastPositionofElementinSortedArray_BS {
    public static void main(String[] args){
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int r = bs(nums,target);
        int l = bs(nums,target-1)+1;
        if (l > r)
            return new int[]{-1,-1};
        int[] res = new int[]{l,r};
        return res;
    }

    public static int bs(int[] nums, int target){
        int l = 0, r = nums.length-1;
        int mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l - 1;
    }
}
