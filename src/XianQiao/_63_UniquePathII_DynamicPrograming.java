package XianQiao;

/**
 * @Author: Xianqiao
 * @Date: 8/3/20 22:16
 */
public class _63_UniquePathII_DynamicPrograming {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            //if cur grid is not obstructed and there is a way to get cur grid.
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) {
                //then there is one way to get cur grid.
                obstacleGrid[i][0] = 1;
            } else {
                //otherwise there is no way to get cur grid.
                obstacleGrid[i][0] = 0;
            }
        }
        for (int j = 1; j < col; j++) {
            if (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1) {
                obstacleGrid[0][j] = 1;
            } else {
                obstacleGrid[0][j] = 0;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[row-1][col-1];
    }
}
