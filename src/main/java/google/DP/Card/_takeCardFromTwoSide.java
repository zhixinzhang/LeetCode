package google.DP.Card;

/**
 * Created by zhang on 2018/8/7.
 * https://www.nowcoder.com/questionTerminal/20a6657b0e27474f9213bd7e97a93908?pos=4&mutiTagIds=571_574_602_624&orderByHotValue=0
 *
 * f[i][j]表示从i到j取的最大和
 * 和吹气球很像 LC 312 都是从长度 第一开始
 */
public class _takeCardFromTwoSide {
    public static int solu(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len][len];
        int[] sum = new int[len + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        for (int i = 2; i<=len; i++)
            sum[i] += sum[i-1] + nums[i-1];
        /**
         明显动规dp的题啊，f[i][j]=max(num[i] + sum[i+1][j] - f[i+1][j] , num[j] +  sum[i][j-1] - f[i][j-1])
         f[i][j]表示从i到j取的最大和
         sum[i][j]表示从i到j的和
         每次只需判断拿左边大还是右边大就好了 
         */
        for (int i = 0; i < len; i++)
            dp[i][i] = nums[i];
        // 1 3 10 12 16
        for (int i = 2; i < len; i++){
            for (int j = 0; j < len - i; j++){
                int a = sum[j + i] - sum[j+1];
                int b = sum[j + i -1 ] - sum[j];
                int l = j, r = j + i -1;
                dp[l][r] = Math.max(nums[l] + a - dp[l+1][r], nums[r] + b - dp[l][r-1]);
                int c = dp[l][r];
                System.out.println(c);
            }
        }
        return dp[0][len-1];
    }
    public static void main(String[] args){
        solu(new int[]{1,2,7,2,4});
    }
}
