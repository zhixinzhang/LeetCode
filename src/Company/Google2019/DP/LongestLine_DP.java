package Company.Google2019.DP;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/4/19
 * Time: 2:04 PM
 * Description:
 *题目是给一个n*n matrix，里面有些点被占据了，有些点是空的。求被占据的点所能连城的直线的最长长度。直线可以vertical, horizontal和diagnal。例如
 * [ 0, 1, 0, 0, 1]
 * [ 0, 1, 1, 1, 0]
 * [ 1, 1, 1, 0, 1]
 * [ 0, 1, 0, 1, 1]
 * [ 0, 0, 0, 0, 1]
 * 1代表被占据，最长就是4， 从[1,1]到[4,4]
 *
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=490549&page=1&authorid=115435
 */

//space O(n^2) time O(n^2)  经典DP 我一下子就想出来了 还可以
public class LongestLine_DP {
    public static void main(String[] args){
        int[][] grid = new int[][]{
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 0, 1}
        };
        solve(grid);
    }

    private static int solve(int[][] grid){
        if (grid == null || grid[0].length == 0)
            return 0;
        int n = grid.length;
        int global = 0;
        // 0 -> horizontal 1->vertical 2->leftDia 3->rightDial
        // dp[i][j] == dp[i][j-1] + 1, dp[i][j+1]+1
        int[][][] cache = new int[n][n][4];
        for (int i = 0; i < n; i++){
            if (grid[0][i] == 1){
                Arrays.fill(cache[0][i], 1);
                if (i-1 >= 0)
                    cache[0][i][0] = cache[0][i-1][0]+1;
            }
        }
        for (int i = 0; i < n; i++){
            if (grid[i][0] == 1){
                Arrays.fill(cache[i][0], 1);
                if (i-1>=0)
                    cache[i][0][1] = cache[i-1][0][1]+1;
            }
        }
        for(int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                int l = 0, top = 0, lD = 0, rD = 0;
                if (grid[i][j] == 1){
                    l = cache[i][j-1][0]+1;
                    cache[i][j][0] = l;
                    top = cache[i-1][j][1]+1;
                    cache[i][j][1] = top;
                    lD = cache[i-1][j-1][2]+1;
                    cache[i][j][2] = lD;
                    if (j+1 < n){
                        rD = cache[i-1][j+1][3]+1;
                        cache[i][j][3] = rD;
                    }
                    global = Math.max(l,Math.max(top,Math.max(lD,rD)));
                }
            }
        }

        return global;
    }
}
