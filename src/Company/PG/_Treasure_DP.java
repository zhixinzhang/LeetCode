package Company.PG;

/**
 * Created by zhang on 2018/1/27.
 */
// dp or dfs  11-2
public class _Treasure_DP {
    int val = 1000;
    public int sellMax(){
        int[][] res = new int[1000][];
        //dp[v][i] = Math.min(dp[v - item[i-1]][i-1]+1, dp[v][i-1]);

        for (int v = 0 ; v <= val; v++){
//            res[v] = Math.max();
        }
        return res[1000][0];
    }
}
