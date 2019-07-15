package google.DP;
//http://blog.csdn.net/hit0803107/article/details/54894227
// https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DataStructure.DP-solution-using-subset-sum-with-explanation

/**
3、举例说明: nums = {1,2,3,4,5}, target=3, 一种可行的方案是+1-2+3-4+5 = 3

     该方案中数组元素可以分为两组，一组是数字符号为正(P={1,3,5})，另一组数字符号为负(N={2,4})

     因此: sum(1,3,5) - sum(2,4) = target

              sum(1,3,5) - sum(2,4) + sum(1,3,5) + sum(2,4) = target + sum(1,3,5) + sum(2,4)

              2sum(1,3,5) = target + sum(1,3,5) + sum(2,4)

              2sum(P) = target + sum(nums)

              sum(P) = (target + sum(nums)) / 2

     由于target和sum(nums)是固定值，因此原始问题转化为求解nums中子集的和等于sum(P)的方案个数问题
*/
public class _494_TargetSum_DFS_DP{
		//              dp[i]表示子集合元素之和等于当前目标值的方案个数, 当前目标值等于9减去当前元素值
    public static void main(String[] args){
        findTargetSumWays_DP(new int[]{1,1,1,1,1,},3);
    }
        // sum = 5  target 3
        // all pos  - all neg == 3  all nea = 2
        // sum + neg = target

	    public static int findTargetSumWays_DP(int[] nums, int S) {
        int sum = 0;  
        for (int i = 0; i < nums.length; i++) {  
            sum += nums[i];  
        }  
        if (S > sum || (sum + S) % 2 == 1)  
            return 0;  
        return subsetSum(nums, (sum + S) / 2);  
    }  

    	private static int subsetSum(int[] nums, int S){
            int[] dp = new int[S + 1];
            dp[0] = 1;
            for (int n : nums)
                for (int i = S; i >= n; i--)
                    dp[i] += dp[i - n];
    		return dp[S];
    	}



    //O(2^n)
   public int findTargetSumWays_DFS(int[] nums, int S) {  
        int[] arr = new int[1];  
        helper(nums, S, arr, 0, 0);  
        return arr[0];  
    }  
  
    public void helper(int[] nums, int S, int[] arr, int sum, int start) {  
        if (start == nums.length) {  
            if (sum == S) {  
                arr[0]++;  
            }  
            return;  
        }  
        // 这里千万不要加for循环，因为我们只是从index0开始  
        helper(nums, S, arr, sum - nums[start], start + 1);  
        helper(nums, S, arr, sum + nums[start], start + 1);  
  
    }  
}