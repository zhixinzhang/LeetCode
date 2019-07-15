package google;

public class _221_MaximalSquare_DP {
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
// only 1's and return its area.
//http://blog.csdn.net/u012501459/article/details/46553139
// 动态的规划的核心是定义状态和状态转移方程：
//此时时间复杂程度是O(M*N)，空间复杂程度是O(M*N)。
    public static void main(String[] args) {
    	char[][] a = {{'1','0','1','0','0'},{'1','0', '1', '1', '1'},{'1', '0', '1', '1', '1'},
				{'1','1', '1', '2', '1'},{'1','0','0','1','0'}};
		int c = maximalSquare(a);
	}
    public static int maximalSquare(char[][] a) {
		if (a == null || a.length == 0 || a[0].length == 0)
			return 0;
		int max = 0, n = a.length, m = a[0].length;
		// dp(i, j) represents the length of the square
		// whose lower-right corner is located at (i, j)
		// dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		// return the area
		return max * max;
    }
}