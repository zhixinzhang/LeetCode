package DataStructure.Array;

// dp[k][i][j] = number of ways to move to(j,i) after k steps
//http://zxi.mytechroad.com/blog/dynamic-programming/688-knight-probability-in-chessboard/
public class _688_KnightProbabilityinChessboard_DFS_DP{

	  int moves[][] = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,-1},{-2,1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K+1];
        return dfs(N,dp,K,r,c);
        
    }
    private double dfs(int N, double[][][] dp, int K, int i, int j){
        // edge 
        if(i < 0 || i >= N || j<0 || j>= N) return 0;
        if(K == 0) return 1;        // in chess board
        if(dp[i][j][K] > 0) return dp[i][j][K];
        double ret = 0;
        for(int[] dir : moves){
            ret += 0.125 * dfs(N,dp,K-1,i+dir[0],j+dir[1]);
        }
        dp[i][j][K] = ret;
        return ret;
    }
}
