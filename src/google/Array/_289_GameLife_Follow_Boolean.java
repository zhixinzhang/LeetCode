package google.Array;


/**
 * Created by zhang on 2018/6/23.
 * t t f f
 * t t t t
 * f f t t
 */
public class _289_GameLife_Follow_Boolean {
    public void gamleLife(boolean[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return;

        boolean[] extra = new boolean[grid[0].length];
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < n; i++){
            extra[i] = grid[0][i];
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int count = findNei(extra,grid,i ,j );
//                if (grid[i][j] == true && count >=2 && count <=3)

            }
        }

    }
    public int findNei(boolean[] extra, boolean[][] grid, int i, int j){

        return 0;
    }
}
