package DataStructure.Array;

public class _416_PartitionEqualSubsetSum_DP{

    public static void main(String[] args){
        canPartition(new int[]{1,2,3,2});
    }
 public static boolean canPartition(int[] nums) {
         // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        // 1 5 9 5
     //要更新[nums[i], target]之间的值，那么对于这个区间中的任意一个数字j，
     // 如果dp[j - nums[i]]为true的话，那么dp[j]就一定为true，于是地推公式如下：
        for (int i = 1; i <= nums.length; i++) {
            for(int j = volumn; j>nums[i-1];j--){
                int c = nums[i-1];
            	dp[j] = dp[j]||dp[j-nums[i-1]];
            	int a = 0;
            }
        }
        return dp[volumn];   
    }
}