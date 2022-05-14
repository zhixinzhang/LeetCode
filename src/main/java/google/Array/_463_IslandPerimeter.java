package google.Array;

/**
 * Created by zhang on 2018/5/
 * loop over the matrix and count the number of islands;
 if the current dot is an island, count if it has any right neighbour or down neighbour;
 the result is islands * 4 - neighbours * 2
 */
public class _463_IslandPerimeter {
        public int islandPerimeter(int[][] grid) {
            int res = 0;
            int island = 0, nei = 0;
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return res;
            for (int i = 0; i<grid.length;i++){
                for (int j = 0; j<grid.length; j++){
                 if (grid[i][j] == 1)   island++;
                 if (i<grid.length - 1 && grid[i+1][j] == 1) nei ++;
                 if (j<grid[0].length - 1 && grid[i][j+1] == 1) nei++;
                }
            }
            return island*4 - nei*2;
        }
    }
