package DataStructure.Array;


//DataStructure.DP[i][j][k] stands for how many possible ways to walk into cell j,k in step i, DataStructure.DP[i][j][k]
//only depends on DataStructure.DP[i - 1][j][k], so we can compress 3 dimensional dp array to 2 dimensional.
public class _576_OutofBoundaryPaths_DP{
    public int findPaths(int m, int n, int N, int i, int j) {

        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }

        return result;
    }
}