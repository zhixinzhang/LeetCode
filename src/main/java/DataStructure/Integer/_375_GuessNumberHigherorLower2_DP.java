package DataStructure.Integer;

/**
 * Created by zhang on 2018/5/1.
 * 在1-n个数里面，我们任意猜一个数(设为i)，保证获胜所花的钱应该为 i + max(w(1 ,i-1), w(i+1 ,n))，这里w(x,y))表示猜范围在(x,y)的数保证能赢应花的钱，则我们依次遍历 1-n作为猜的数，求出其中的最小值即为答案
 */
public class _375_GuessNumberHigherorLower2_DP {
        public int getMoneyAmount(int n) {
            //dp[1][n] present
            int[][] dp = new int[n+1][n+1];
            for (int j = 2; j<=n; j++){
                for (int i = j-1; i>0; i--){
                    int globalMin = Integer.MIN_VALUE;
                    for (int k = i+1; k<j; k++){
                        int localMax = k + Math.max(dp[i][k-1],dp[k+1][j]);
                        globalMin = Math.min(globalMin,localMax);
                    }
                    dp[i][j] = i+1==j?i:globalMin;
                }
            }

            return dp[1][n];
        }
    }
