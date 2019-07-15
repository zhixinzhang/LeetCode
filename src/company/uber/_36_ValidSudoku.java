package company.uber;

import java.util.HashSet;

/**
 * Created by zhang on 2018/9/13.
 * Collect the set of things we see, encoded as strings. For example:

 '4' in row 7 is encoded as "(4)7".
 '4' in column 7 is encoded as "7(4)".
 '4' in the top-right block is encoded as "0(4)2".
 Scream false if we ever fail to add something because it was already added (i.e., seen before).
 */
public class _36_ValidSudoku {
    public boolean isValid(char[][] grid){
        HashSet<String> vis = new HashSet<>();
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
}
