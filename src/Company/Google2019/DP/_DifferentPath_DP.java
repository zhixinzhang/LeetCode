package Company.Google2019.DP;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/5/19
 * Time: 4:09 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=473093&page=1&authorid=267089
 * 第一轮是中国小哥，查了linkedin是staff engineer。。出了一个很简单的dynamic programming的题，
 * 就是给一个matrix，从一个grid 到另一个grid，只能往右上，右，右下三个方向走， 求有多少种走法。利口 六四变种
 *
 * _62_UniquePath_gridThree_ThreeWay_DP
 */


public class _DifferentPath_DP {
    public static void main(String[] args){
        int[][] grid = new int[][]{
                {1,1,1,1},
                {1,1,1,1},
                {1,0,0,1},
                {1,1,1,1}
        };
        solve(grid);
    }

    private static void solve(int[][] grid){
        if (grid == null || grid[0].length == 0){
            System.out.println(0);
        }
        int n = grid.length;
        int[][] cache = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0)
                    cache[i][j] = 0;
                else {
                    int l = 0, lb = 0, ltop = 0;
                    if (i>=1 && j+1<n)
                        ltop = cache[i-1][j+1] + 1;
                    if (j>=1)
                        l = cache[i][j-1] + 1;
                    if (i+1 < n && j+1<n)
                        lb = cache[i+1][j+1] + 1;

                    cache[i][j] = Math.max(l,Math.max(lb,ltop));
                }
            }
        }
        System.out.println(cache[n-1][n-1]);
    }
}
