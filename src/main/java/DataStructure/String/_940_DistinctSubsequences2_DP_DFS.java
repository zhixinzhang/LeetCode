package DataStructure.String;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/13/19
 * Time: 1:21 PM
 * Description:
 * https://blog.csdn.net/u014110320/article/details/83958616
 * https://leetcode.com/problems/distinct-subsequences-ii/discuss/192030/Java-DP-O(N2)-time-greater-O(N)-time-greater-O(1)-space
 * dp[i] represents the count of unique subsequence ends with S[i].
 * dp[i] is initialized to 1 for S[0 ... i]
 * For each dp[i], we define j from 0 to i - 1, we have:
 *
 * if s[j] != s[i], dp[i] += dp[j]
 * if s[j] == s[i], do nothing to avoid duplicates.
 * Then result = sum(dp[0], ... dp[n - 1])
 * Time complexity: O(n^2)
 */


public class _940_DistinctSubsequences2_DP_DFS {
    public int distinctSubseqII(String S) {
        // abaac
        int n = S.length(), M = (int)1e9 + 7, result = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (S.charAt(i) != S.charAt(j)){
                    dp[i] += dp[j];
                    dp[i] %= M;
                }
            }
            result += dp[i];
            result %= M;
        }
        return result;
    }
}
