package ClassicProblemGroup.NumberOfIslands;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/22/19
 * Time: 4:42 PM
 * Description:
 *
 *
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=514278&page=1#pid6446556
 * number of islands. 给一个二维数组，包含零和一， 输出一共多少个岛。 Followup是输出岛的面积
 */


public class _200_NumberofIslands_FollowUp {
    int[][] dir = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    public int numIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int area = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    int curArea = dfs(grid, i, j, 0);
                    area = Math.max(area, curArea);
                }
            }
        }
        return area;
    }
    public int dfs(int[][] grid, int i, int j, int area) {
        for (int[] d : dir){
            int nextX = d[0] + i;
            int nextY = d[1] + j;
            if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || grid[nextX][nextY] == 0)
                continue;
            area++;
            grid[nextX][nextY] = 0;
            dfs(grid,nextX, nextY, area);
        }
        return area;
    }
}
