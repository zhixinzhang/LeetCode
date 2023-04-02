package Company.Google.DP.Card;

/**
 * Created by zhang on 2018/6/24.
 * 一堆卡片从一头拿，可以拿一二三张，两人轮流拿，求最高得分。小哥直接表示有负数的情况。我刚吃了饭有点懵，推出了正数的情况但是卡在了含负数的情况。然后小哥说那就先不考虑负数吧。
 * 随后还给了点 hint，然后就写出来了。并且让我在一个例子上过了一遍，问了问用什么 case 来测
 *
 * 类似 predict win lc
 */
public class CardSum_DP {
    public static int solution(int[] nums){
        //dp[i] = sum[i] - nums[i] + sum[i-1]
        int l = nums.length;
        int[] sums = new int[nums.length];
        sums[l - 1] = nums[l-1];
        for (int i = nums.length - 2; i>=0; i--)
            sums[i] += nums[i] + sums[i + 1];
        //[10   1     2    3    1   99]
        //[116  106  105  103  100  99]
        // dp  从右往左 计算 初始化 dp[5] = 99 dp[4] = 100 dp[3] = 103
        //[x    x     6   103   100  99]
        //[x    100   6   103   100  99]b
        for (int i = l-4; i >= 0;i--){
            int sum = Integer.MIN_VALUE;
            for(int k = 1; k<=3; k++){
                sum = Math.max(sums[i] - sums[i+k], sum);
            }
            sums[i] = sum;
//            sums[i] = Math.max(Math.max(sums[i] - sums[i+1],sums[i] - sums[i+2]),
//                    sums[i] - sums[i+3]);
        }
        return sums[0];
    }

    public static int solution_DP(int[] nums){
        int l = nums.length;
        int[] sums = new int[nums.length];
        int n = sums.length;
        sums[n-1] = nums[n-1];
        for (int i = n-1; i > 0; i--){
            sums[i-1] = (sums[i] + nums[i-1]);
        }
        //[10   1     2    3    1   99]
        //[10  11     13   16   17  116]
        int[] dp = new int[n];
        dp[n-1] = sums[n-1];
        dp[n-2] = sums[n-2];
        dp[n-3] = sums[n-3];
        for (int i = n-4; i>=0; i--){
            for (int k = 1; k <= 3; k++){
                dp[i] = Math.max(dp[i],sums[i] - dp[i+k]);
            }
        }
        int half = sums[n-1]/2;
        return dp[0];
    }


    public static void main(String[] args){
        solution(new int[]{10 ,  1,     3,    99,    2,   4});
    }
}
