package google;

/**
 * Created by zhang on 2018/5/23.
 */
// dp[i] = Math.max(dp[i],(i-j -1) dp[j]) dp[j] 是我们之前有多少个A dp[] c v多少次
public class _651_4KeysKeyboard_DP {
        public int maxA(int N) {
            int[] dp = new int[N+1];
            for (int i = 0; i<N;i++){
                dp[i] = i;
                for (int j = 1; j<= i - 3; j++){
                    dp[i] = Math.max(dp[i],dp[j]*(i-j-1));
                }
            }
            return dp[N];
        }
    }
