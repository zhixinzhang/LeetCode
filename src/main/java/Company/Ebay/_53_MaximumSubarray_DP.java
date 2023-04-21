package Company.Ebay;
/**
 * Created by zhang on 2017/9/22.
 */
/**用两个指针 都从前面开始，如果前面的值小于零，头指针往后移动 同时记住 最大的Max result
 * 如果用brute force 是O（o2）
 *如果用DP
 * */
public class _53_MaximumSubarray_DP {
	//dp[i] means the largest sum among the subarrays whose last element is A[i].
	//DataStructure.DP Solution - O(n) time, O(n) space
    public int maxSubArray_DP(int[] A) {
     if (A == null || A.length == 0){
            return 0;
        }
		int dp[] = new int[A.length]; 
        int max = A[0]; 
        dp[0] = A[0]; 
		
        for (int i = 1; i < A.length; i++) {			
			dp[i] = Math.max(dp[i-1] + A[i] ,A[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
    }

    //O(n) time, O(1) space - 
    //The basic idea is to check previous sum, reset it to 0 if it’s less than 0.
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
	     int res = Integer.MIN_VALUE, sum = 0;
	    for (int i = 0; i < nums.length; i++) {
	        sum = Math.max(sum, 0) + nums[i];
	        res = Math.max(res, sum);
	    }
	    return res;
    }

    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
    }

}
