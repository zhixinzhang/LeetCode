package google.DP;

/**
 * Created by zhang on 2018/7/27.
 *
 * 第三轮：面经题，只能向右、右上、右下走，那么左上角到右上角有多少种走法，太急于写代码，没想清楚就下意识开始写，然后第一次还写错了，后来冷静了一下，面试官又提示了一下才写对。。。提醒大家，看到面经，你以为你会了，其实你并不一定真的会了。。。最好写一下代码再run几个test case确保万无一失真的懂了，不然像我这样遇到原题都没做好，当场真的会很崩溃，
 * 如果不是面试官比较冷静比较和善，心态很容易崩盘。。follow up，有一系列点必需依次经过，有多少种走法
 */
public class _62_UniquePath_gridThree_ThreeWay_DP {
    public static int findPath_2D(int m, int n){
        if (m == 0 || n == 0)   return 0;
        if (m == 1 || n == 1)   return 1;
        int[][] dp = new int[m][n];
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 0; i< m; i++){
            for (int j = 2; j<n;j++){
                dp[i][j] = dp[i][j-1];
                if (i-1>=0)
                    dp[i][j] += dp[i-1][j-1];
                if (i+1 <= m)
                    dp[i][j] += dp[i+1][j-1];
            }
        }
        return dp[0][n-1];
    }

    public static int findPath_1D(int m, int n){
        if (m == 0 || n == 0)   return 0;
        if (m == 1 || n == 1)   return 1;
        int[] dp = new int[m];
        dp[0]= 1;
        dp[1]= 1;

        for (int j = 2; j < n; j++){
            int[] temp = dp.clone();
            for (int i = 0; i < m; i++) {
                int a = 0, b = dp[i], c = 0;
                if (i - 1 >= 0) a = dp[i - 1];
                if (i + 1 < m) c = dp[i + 1];
                temp[i] = a + b + c;
            }
            dp = temp;
        }

        return dp[0];
    }
    public static void main(String[] args){
        findPath_1D(3,4);
    }
}
