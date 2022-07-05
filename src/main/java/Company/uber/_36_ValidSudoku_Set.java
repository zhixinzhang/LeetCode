package Company.uber;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/solution/
'4' in row 7 is encoded as "(4)7".
'4' in column 7 is encoded as "7(4)".
'4' in the top-right block is encoded as "0(4)2".
Scream false if we ever fail to add something because it was already added (i.e., seen before).
 */

public class _36_ValidSudoku_Set {
    public boolean isValid(char[][] grid){
        Set<String> vis = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (grid[i][j] != '.'){
                    char num = grid[i][j];
                    String currow = num + "in row" + j;
                    String curcol = num + "in col" + i;
                    String curarea = num + "in area" + i / 3 + "/"+ j / 3;
                    if (!vis.add(currow) || !vis.add(curcol) || !vis.add(curarea))
                        return false;
                }
            }
        }
        return true;
    }

    // only check row and column
    public static boolean isValidMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // check row
                int x = matrix[i][j];
                if (!rowSet.add(x) || x  < 1 || x > n) {
                    return false;
                }
                // check column
                int y = matrix[j][i];
                if (!colSet.add(y) || y < 1 || y > n) {
                    return false;
                }
            }
        }
        return true;
    }
}
