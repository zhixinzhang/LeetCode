package DataStructure.Array;

/**
 * Created by zhang on 2017/10/25.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 */
/*  island = 3
11000
11000
00100
00011
* */
// follow up 数最大的岛屿面积i
public class _200_NumberofIslands_DFS {

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0 || grid == null)
            return count;
        if (grid[0].length == 0 || grid[0] == null)
            return count;
        int row = grid.length;
        int col = grid[0].length;
        // 元素默认值是false
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0;i<row;i++){
            for (int j = 0; j<col;j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    helper(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void  helper (char[][] grid,boolean[][] visited,int row,int col){
        if (row >= 0 && row < grid.length // 行合法
                && col >= 0 && col < grid[0].length // 列合法
                && !visited[row][col] // 没有访问过
                && grid[row][col] == '1') { // 是岛上陆地
// 标记此位置已经访问过了
            visited[row][col] = true;
            // 上
            helper(grid, visited, row - 1, col);
            // 右
            helper(grid, visited, row, col + 1);
            // 下
            helper(grid, visited, row + 1, col);
            // 左
            helper(grid, visited, row, col - 1);
        }
    }
}
