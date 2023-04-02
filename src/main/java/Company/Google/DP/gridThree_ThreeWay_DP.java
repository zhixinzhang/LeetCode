package Company.Google.DP;

/**
 * Created by zhang on 2018/6/21.
 * 1. dp题。给一个grid的宽和长，求得从左下的点到右下的点所有可能的路径之和。
 起点当然是左下，要求每次只能走三个方向， ➡↗↘


 2。 DataStructure.DP。给定一个矩形的长宽，用多少种方法可以从左上角走到右上角 （每一步，只能向正右、右上 或 右下走）：整个矩形遍历做DP即可，不需要想复杂
 -follow up：如果给矩形里的三个点，要求解决上述问题的同时，遍历这三个点 （切割矩形，一个一个地做DP，然后相加）.留学论坛-一亩-三分地
 -follow up：如何判断这三个点一个是合理的，即存在遍历这三个点的路经. 1point 3acres 论坛
 -follow up：如果给你一个H，要求你的路径必须向下越过H这个界，怎么做 （别问我，我不会）

 follow up: 2d dp -> 1d dp
 */
public class gridThree_ThreeWay_DP {
    public static int solution_DP_2D(int row, int col){
        if (row == 0 && col == 0) return 0;
        int[][] dp = new int[row][col];
        dp[row-1][1] = 1;
        dp[row-2][1] = 1;
        for (int j = 2; j < col; j++){
            for (int i = 0; i< row; i++){
                int a = 0, b = 0, c = 0;
                if (i - 1 >= 0 && j - 1 < col)
                    a = dp[i-1][j-1];
                if (i < row && j - 1 < col)
                    b = dp[i][j-1];
                if (i + 1 < row && j - 1 < col)
                    c = dp[i+1][j-1];
                dp[i][j] = a + b + c;
            }
        }
        int i = dp[row-1][col-1];
        return dp[row-1][col-1];
    }

    public static int solution_DP_1D(int row, int col){
        if (row == 0 && col == 0) return 0;
        int[] dp = new int[row];
        int[] nextDP = new int[row];
        dp[row-1] = 1;
        dp[row-2] = 1;
        if (col == 2) return 1;
        for (int j = 2; j < col; j++){
            for (int i = 0; i< row; i++){
                int a = 0, b = 0, c = 0;
                if (i - 1 >= 0)
                    a = dp[i-1];
                if (i >= 0 && i< row)
                    b = dp[i];
                if (i+1 < row)
                    c = dp[i+1];
                nextDP[i] = a + b + c;
            }
            dp = nextDP.clone();
        }
        return dp[row-1];
    }

    public static void main(String[] args){
//        solution_DP_1D(3,4);
        solution_DP_2D(3,4);
    }

}
