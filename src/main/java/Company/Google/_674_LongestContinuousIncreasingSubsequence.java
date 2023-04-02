package google;

/**
 * Created by zhang on 2017/12/1.
 */
public class _674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args){
        int a = findLengthOfLCIS(new int[]{1,3,5,7});
//        int a = findLengthOfLCIS(new int[]{2,2,2,2,2});
    }


    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int left = 0, max = 1;
        // 1 3 5 4 7
        for(int i = 0; i<nums.length;i++){
            if (i == nums.length-1){
                max = Math.max(max,i-left+1);
                break;
            }
            if(nums[i+1] > nums[i]){
                max = Math.max(max,i-left+1);
            }else{
                max = Math.max(max,i-left+1);
                left = i+1;
            }

        }

        return max;
    }

    public static int findLengthOfLCIS_dp(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int max = 1;
        //[1,3,5,4,7]  4  3  2
        for(int i = 0; i<nums.length-1;i++){
            if (dp[i] == 0) dp[i] =1;
            if(nums[i+1] > nums[i]){
                dp[i+1] = dp[i]+1;
                max = Math.max(dp[i+1],max);
            }else{
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
}
