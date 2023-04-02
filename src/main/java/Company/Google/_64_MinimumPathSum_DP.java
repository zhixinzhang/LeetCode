package google;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/10/19
 * Time: 10:43 PM
 * Description:
 *
 * 一边过 我很屌
 */


public class _64_MinimumPathSum_DP {
    public static void main(String[] args){
        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 1; i < col; i++) grid[0][i] += grid[0][i-1];
        for(int i = 1; i < row; i++) grid[i][0] += grid[i-1][0];
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[row - 1][col - 1];
    }
}
