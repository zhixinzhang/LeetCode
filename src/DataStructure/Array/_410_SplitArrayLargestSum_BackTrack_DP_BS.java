package DataStructure.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2018/5/4.
 */
public class _410_SplitArrayLargestSum_BackTrack_DP_BS {
    public static void main(String[] args){

    }

/**
 * Time complexity : O(n^2 * m)
 * Space complexity : O(n * m) The space complexity is equivalent to the number of states, which is O(n * m)O(n∗m).
 * */
    public int splitArray_DP(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        int[] sum = new int[n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < n; i++)
            sum[i+1] = sum[i] + nums[i];
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                for(int k = 0; k < i; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }
    public int splitArray_BS(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
