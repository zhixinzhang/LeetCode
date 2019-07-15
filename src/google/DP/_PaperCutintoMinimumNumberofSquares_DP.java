package google.DP;

/**
 * Created by zhang on 2018/7/15.
 */
public class _PaperCutintoMinimumNumberofSquares_DP {
    static int[][] dp = new int[300][300];
    public static int mini(int m, int n){
        int ver_Min = Integer.MAX_VALUE;
        int hor_Min = Integer.MAX_VALUE;
        if (m == n) return 1;
        if (dp[m][n] != 0){
            return dp[m][n];
        }
        for (int i = 1; i <= m/2; i++ ){
            hor_Min = Math.min(mini(i,n) + mini(m-i,n),hor_Min);
        }
        for (int j = 1; j <= n/2; j++){
            ver_Min = Math.min(mini(m,j)+mini(m,n-j), ver_Min);
        }
        dp[m][n] = Math.min(ver_Min,hor_Min);
        return dp[m][n];
    }
}
