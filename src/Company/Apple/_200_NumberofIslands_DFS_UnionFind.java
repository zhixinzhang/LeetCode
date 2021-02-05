package Company.Apple;

/**
 * Created by zhang on 2018/2/7.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1
 */
public class _200_NumberofIslands_DFS_UnionFind {
    // O(row * col)
    public int numIslands_DFS(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    search(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void search(char[][] grid, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return;
        grid[x][y] = '0';
        search(grid, x-1, y);
        search(grid, x+1, y);
        search(grid, x, y-1);
        search(grid, x, y+1);
    }

}
