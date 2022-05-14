package google.Array;

/**
 * Created by zhang on 2018/6/25.
 */
public class _463_IslandPerimeter_DFS_Loop {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i< m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 1){
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i ,int j){
        if (i < 0 || i>=grid.length || j <0 || j>=grid[0].length)
            return 1;
        if (grid[i][j] == -1)
            return 0;
        grid[i][j] = -1;
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int res = 0;
        for (int[] d : dir){
            res += dfs(grid,i + d[0],j + d[1]);
        }
        return res;
    }
}
