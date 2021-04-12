package DataStructure.Array;
import java.util.*;

public class _695_MaxAreaofIsland_DFS{

    public static void main(String[] args){
        maxAreaOfIsland_DFS_InPlace(new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
    }
    static int m, n;
    static int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int maxAreaOfIsland_DFS_InPlace(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1) {
                    int curArea = dfs(i, j, grid);
                    res = Math.max(curArea, res);
                }
            }
        }

        return res;
    }

    private static int dfs(int col, int hor, int[][] grid){
        grid[col][hor] = 2;
        int val = 1;

        for (int[] dir : dirs){
            int nextCol = hor + dir[1];
            int nextHor = col + dir[0];
            if (nextCol >= 0 && nextHor >= 0 && nextCol < m && nextHor < n && grid[nextCol][nextHor] == 1) {
                val += dfs(nextCol, nextHor, grid);
            }
        }

        return val;
    }

    public int maxAreaOfIsland_DFS(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int cur = helper(grid, i, j);
                    result = Math.max(cur, result);
                }
            }
        }
        return result;
    }
    public int helper(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + helper(grid, i + 1, j) + helper(grid, i, j + 1) + helper(grid, i - 1, j) + helper(grid, i, j - 1);
    }

   int localArea = 0;
    public int maxAreaOfIsland_BFS(int[][] grid) {
        int maxArea = 0;
        
        int m = grid.length, n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && flag[i][j] == false) {
                    localArea = 0;
                    getArea(grid, i,j, flag);
                    maxArea = Math.max(localArea, maxArea);
                }
            }
        }
        return maxArea;
    }
    
    public void getArea (int[][] grid, int i, int j, boolean[][]flag) {
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[]{i,j});
        flag[i][j] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int index=0; index<size; index++) {
                int[] curr = q.poll();
                localArea++;
                for (int k=0; k<4; k++) {
                int nx = curr[0]+dirs[k][0];
                int ny = curr[1]+dirs[k][1];
                if (nx <0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || flag[nx][ny] == true || grid[nx][ny] == 0) {
                    continue;
                }
                    flag[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}