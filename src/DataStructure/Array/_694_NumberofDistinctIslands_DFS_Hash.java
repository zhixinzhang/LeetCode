package DataStructure.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/10/19
 * Time: 1:53 PM
 * Description:
 */


public class _694_NumberofDistinctIslands_DFS_Hash {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    char[] direct = {'l', 'r', 'u', 'd'};

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    search(grid, i, j, 's', sb); // start
                    set.add(sb.toString());
                }
            }

        }
        return set.size();
    }

    public void search(int[][] grid, int x, int y, char d, StringBuilder sb) {
        grid[x][y] = 0;
        sb.append(d);
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 1) continue;
            search(grid, newX, newY, direct[i], sb);
            sb.append('b'); // go back
        }

    }
}
