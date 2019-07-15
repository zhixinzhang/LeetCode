package DataStructure.Array;
import java.util.*;

public class _695_MaxAreaofIsland_DFS{

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
    
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
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