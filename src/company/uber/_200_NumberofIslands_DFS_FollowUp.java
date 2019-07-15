package company.uber;

/**
 * Created by zhang on 2018/9/13.
 */
// follow up 数最大的岛屿面积i

public class _200_NumberofIslands_DFS_FollowUp {
    int sum = 0;
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return sum;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    sum++;
                    grid[i][j] = '2';
                    dfs(i,j,grid);
                }
            }
        }
        return sum;
    }
    public void dfs(int i, int j, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        for(int[] d : dirs){
            int nextI = d[0] + i;
            int nextJ = d[1] + j;
            if(nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n)
                continue;
            if(grid[nextI][nextJ] != '1')
                continue;
            grid[nextI][nextJ] = '2';
            dfs(nextI, nextJ, grid);
        }

    }

    static int maxArea = 0;
    public static int numIslands_findMax(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return maxArea;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    grid[i][j] = 0;
                    int curMax = dfs(i,j,grid,1);
                    maxArea = Math.max(curMax, maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int i, int j, int[][] grid, int area){
//        int res = area;
        for (int[] d : dirs){
            int nextI = d[0] + i;
            int nextJ = d[1] + j;
            if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || grid[nextI][nextJ] != 1)
                continue;
            area++;
            grid[nextI][nextJ] = 0;
            area = dfs(nextI, nextJ, grid, area);
        }
        return area;
    }

    public static void main(String[] args){
        numIslands_findMax(new int[][]{
                {1,1,1,0,1},
                {1,0,1,0,1},
                {1,0,1,0,0},
                {0,0,0,1,1},});
    }
}
