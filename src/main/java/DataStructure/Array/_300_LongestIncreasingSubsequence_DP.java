package DataStructure.Array;

// at least O(n^2)  follow up O(nlogn);
public class _300_LongestIncreasingSubsequence_DP{
    public int lengthOfLIS(int[] nums) {
  // 2,3,3,7,11   
        if(nums == null || nums.length == 0) return 0;
        int maxRes = 0;
        int[] dp = new int[nums.length];
        //dp[i]  represent fron nums[0] to nums[i] longest substring
        //10, 9, 2    dp[2] = 1  longest substring 2
        for (int i = 0;i <nums.length;i++){
            dp[i] = 1;
            for (int j = 0;j<i;j++){
                if (nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            maxRes = Math.max(maxRes,dp[i]);
        }
        return maxRes;
    }
}