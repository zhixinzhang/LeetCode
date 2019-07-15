package DataStructure.Array;

// dp   https://www.youtube.com/watch?v=opCEfBH-7ZQ
//https://www.youtube.com/watch?v=WxpIHvsu1RI
// https://www.cnblogs.com/liujinhong/p/6477367.html
//https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
public class _486_PredicttheWinner_Recur{
      public boolean PredictTheWinner(int[] nums) {
          return helper(nums, 0, nums.length-1) >= 0;
      }
      
      public int helper(int[] nums, int start, int end) {
          if(start == end) return nums[start];
          else return Math.max(nums[start]-helper(nums, start+1,end), nums[end]-helper(nums, start,end-1));
      }

      public boolean solution_2D(int[] nums){
          int n = nums.length;
          int[][] dp = new int[n][n];
          for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
          for (int len = 1; len < n; len++) {
              for (int i = 0; i < n - len; i++) {
                  int j = i + len;
                  dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
              }
          }
          return dp[0][n - 1] >= 0;
      }

      /**
       *  That can be done by changing our way of filling the table. We may use only one dimensional dp[i] and we start to fill the table at the bottom right corner where dp[4] = nums[4]. On the next step, we start to fill the second to the last line, where it starts from dp[3] = nums[3]. Then dp[4] = Math.max(nums[4] - dp[3], nums[3] - dp[4]). Then we fill the third to the last line where dp[2] = nums[2] and so on... Eventually after we fill the first line and after the filling, dp[4] will be the answer.*/
    public boolean solution_1D(int[] nums){
        if (nums == null) { return true; }
        int n = nums.length;
        if ((n & 1) == 0) { return true; } // Improved with hot13399's comment.
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }
}