package Company.Google;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2017/12/7.
 */
public class _354_RussianDollEnvelopes_DP {
    public int maxEnvelopes(int[][] envelopes) {
        if (   envelopes           == null
                || envelopes.length    == 0
                || envelopes[0]        == null
                || envelopes[0].length == 0){
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return Integer.compare(e1[0], e2[0]);
            }
        });

        int   n  = envelopes.length;
        int[] dp = new int[n];

        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;

            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
