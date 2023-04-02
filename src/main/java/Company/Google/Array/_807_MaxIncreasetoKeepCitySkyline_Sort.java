package Company.Google.Array;

/**
 * Created by zhang on 2018/8/2.
 */
public class _807_MaxIncreasetoKeepCitySkyline_Sort {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int[] col = new int[n], row = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res += Math.min(row[i], col[j]) - grid[i][j];
        return res;

    }
}
