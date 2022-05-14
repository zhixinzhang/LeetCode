package google;

/**
 * Created by zhang on 2018/5/
 *
 * https://www.jianshu.com/p/950a25796be3
 */
public class _813_LargestSumofAverages_DP {
        public double largestSumOfAverages(int[] A, int K) {
            int len = A.length;
            double[] pre = new double[len+1];
            //[9 1 2 3 9] --- [0 9 10 12 15 24]
            for (int i = 1; i<pre.length; i++){
                pre[i] = pre[i-1] + A[i-1];
            }
            double[][] dp = new double[K][len];
            for (int k = 0; k< K; k++){
                for (int i = 0; i<len;++i){
                    dp[k][i] = k == 0 ? pre[i + 1] / (i+1) : dp[k-1][i];
                    if (k > 0){
                        for (int j = i - 1; j>=0; --j){
                            dp[k][j] = Math.max(dp[k][i],dp[k-1][j] + (pre[i+1]-pre[i-1])/(i-j));
                        }
                    }
                }
            }
            return dp[K-1][len-1];
        }
    }
