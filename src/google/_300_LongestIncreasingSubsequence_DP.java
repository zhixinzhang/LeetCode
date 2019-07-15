 package google;

 public class _300_LongestIncreasingSubsequence_DP {
    public static void main(String[] args){
        lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
    public static int lengthOfLIS(int[] nums) {
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