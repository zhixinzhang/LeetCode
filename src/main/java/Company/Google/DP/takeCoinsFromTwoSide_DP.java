package Company.Google.DP;

/**
 * Created by zhang on 2018/7/2.
 */
public class takeCoinsFromTwoSide_DP {
    /**   [4 7 100 3 6 1]   6 / 2 time
     *     1 +
     *   6 7 100 4 2 8
     *   dp[0] = 8
     *   dp[1] = 6 7
     *   dp[2] = 6 7 100
     * **/
    public static int solution(int[] nums){
        int max = 0;
        int count = nums.length / 2;
        int a =  helper(nums,count,0,nums.length-1);
        return a;
    }
    public static int helper(int[] nums, int count, int start,int end){
        if (count == 0)
            return 0;
        count--;
        int left = helper(nums,count,start+1, end) + nums[start];
        int right = helper(nums,count,start, end-1) + nums[end];
        return Math.max(left,right);
    }
    public static void main(String[] args){
        solution(new int[]{6,7,9,10});
    }
}
