package DataStructure.Array;

/**
 * Created by zhang on 2017/11/15.
 */
/**根据 动态规划4要素 进行分析：
 类型：序列型动态规划
 状态 State
 f[i] 表示前i个房子中,偷到的最大价值
 方程 Function
 f[i] = max(f[i-1], f[i-2] + A[i-1]);
 初始化 Intialization
 f[0] = 0;
 f[1] = A[0];
 答案 Answer
 f[n]*/
public class _198_HouseRobber_DP {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        if(nums.length == 1)
            return nums[0];

        //DataStructure.DP function max[i+1] = Max[max[i], max[i-1]+money[i]]  将space O(n) 变成O（1）
        int pre = 0;
        int cur = nums[0];
        for(int i = 1; i<nums.length;i++){
            int next = Math.max(cur,nums[i] + pre);
            pre = cur;
            cur = next;
        }
        return cur;
    }


    public int rob_extra(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2];
        // dp[1][0]  we not robber house which index of 1
        // dp[1][1]  we robber house which index of 1
        // dp formation -> dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1])
        // dp formation -> dp[i][1] = dp[i - 1][0] + nums[i]
        // Math.max(dp[i][0], dp[i][1])

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
