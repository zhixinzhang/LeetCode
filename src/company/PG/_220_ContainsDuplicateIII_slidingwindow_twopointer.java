package company.PG;

/**
 * Created by zhang on 2018/1/27.
 */
public class _220_ContainsDuplicateIII_slidingwindow_twopointer {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 1 5  3  4  6   k ,t
        if(nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;
        int i = 0, j = 1;
        while(i < nums.length - 1){
            if(i != j && Math.abs((long)nums[i] - nums[j]) <= t)
                return true;   // found one
            if(j-i == k || j == nums.length -1){  // maximum window size of k
                i++;    // shift the left boundary of the window
                if(t!=0)
                    j = i+1;  // update j
            }else{
                j++;
            }
        }
        return false;
    }
}
