package google.DP;

/**
 * Created by zhang on 2018/6/29.
 * https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation
 */
public class _213_HouseRobber2_DP {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robR(nums,0,nums.length-2), robR(nums,1,nums.length-1));
    }
    public int robR(int[] nums, int lo, int hi){
        int prev = 0, cur = nums[lo];
        for(int j = lo+1; j <= hi; j++){
            int next = Math.max(prev+nums[j], cur);
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
