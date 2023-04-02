package Company.Google;

/**
[[1,3,1],
 [1,5,1],
 [4,2,1]]
*/
public class _64_MinimumPathSum{

	public int minPathSum(int[][] grid) {
     	//dp[i][j] = Math.max(dp[i-1][j] + grid[i][j],dp[i][j-1] + grid[i][j])
     	if (grid == null || grid.length ==0 || grid[0].length == 0) return 0;
     	int row = grid.length;
     	int col = grid[0].length;
     	for (int i = 0;i<row; i++) {
     		for (int j = 0;j<col;j++ ) {
     			if (i == 0 && j != 0) {
				grid[i][j] = grid[i][j] + grid[i][j - 1];
			} else if (i != 0 && j == 0) {
				grid[i][j] = grid[i][j] + grid[i - 1][j];
			} else if (i == 0 && j == 0) {
				grid[i][j] = grid[i][j];
			} else {
				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
						+ grid[i][j];
			}
     		}
     	}
     	return grid[row - 1][col - 1];
    }
}