package Algo_Summary;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/19/19
 * Time: 4:30 PM
 * Description:
 * based on 200
 */


public class DFS_Template {
    int[][] dir = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '2';
        for(int[] d : dir){
            int nextX = i+ d[0];
            int nextY = j + d[1];
            if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length)
                if(grid[nextX][nextY] == '1'){
                    dfs(grid, nextX, nextY);
                    // 不需要recovery
                }
        }
        return;
    }
}
