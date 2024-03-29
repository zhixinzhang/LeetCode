package Company.Rippling;

//Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
// Time complexity: O(1)O(1)O(1)
// O(mn)
// https://leetcode.com/problems/range-sum-query-2d-immutable/editorial/
public class _304_RangeSumQuery2D_DP {
    private int[][] dp;

    public void NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
