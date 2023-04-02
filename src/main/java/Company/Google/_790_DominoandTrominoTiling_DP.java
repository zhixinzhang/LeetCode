package Company.Google;

/**
 * Created by zhang on 2018/6/1.
 * https://www.jianshu.com/p/33f739a4ba9c
 */
public class _790_DominoandTrominoTiling_DP {
    //O(n) space O(n)
        public int numTilings(int N) {
            long[][] dp = new long[N+1][4];   // we have 4 type Domino
            int mod = 1000000007;
            dp[1][0] = 1;
            dp[1][1] = 1;
            dp[1][2] = 1;
            dp[1][3] = 1;
            for(int i = 2; i<= N; i++){
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][3] + dp[i - 2][1] + dp[i - 2][2]) % mod;
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
                dp[i][3] = dp[i - 1][0] % mod;
            }
            return (int) dp[N][0];
        }
    // 优化代码
        int MOD = (int)Math.pow(10, 9) + 7;
        public int numTIlings_DP(int N){
            if (N == 1) return 1;
            if (N == 2) return 2;
            if (N == 3) return 5;

            int[] dp = new int[4];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 5;
            for (int i = 4; i<=N; ++i){
                dp[i % 4] = (2 * dp[(i - 1)%4]%MOD + dp[(i - 3)%4]) % MOD;
            }
            return dp[N%4];
        }
    }
