package google;

/**
 * Created by zhang on 2018/5/21.
 * 类似于21点  从0开始 每次选一个点 直到  大于等于K
 * 每次选值在【1  W】之间
 *多少可能 N 或者小于N个点
 * In a word,
 dp[i]: probability of get points i
 dp[i] = sum(last W dp values) / W
 */
public class _837_New21Game_DP {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i]; else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
        }
        return res;
    }
}
