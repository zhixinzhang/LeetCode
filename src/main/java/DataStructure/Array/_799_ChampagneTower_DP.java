package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 10:54 AM
 * Description:
 */


public class _799_ChampagneTower_DP {
    public static void main(String[] args){

    }
    public double champagneTower_2D(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row+1];
        dp[0][0] = poured;
        for (int i = 0; i < query_row; i++){
            for (int j = 0; j <= i; j++){
                if (dp[i][j] > 1){
                    double p = (dp[i][j] - 1.0) / 2;
                    dp[i+1][j] += p;
                    dp[i+1][j+1] += p;
                }
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[101];
        res[0] = poured;
        for(int row=1; row<=query_row; row++)
            for(int i=row; i>=0; i--)
                res[i+1] += res[i] = Math.max(0.0, (res[i]-1)/2);
        return Math.min(res[query_glass], 1.0);
    }
}
