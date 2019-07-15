package DataStructure.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/18/19
 * Time: 5:52 PM
 * Description:
 * https://leetcode.com/problems/binary-subarrays-with-sum/solution/
 */


public class _930_BinarySubarraysWithSum_prefixsum_twopointer {
    public static void main(String[] args){
        numSubarraysWithSum_prefix_sum(new int[]{1,0,1,0,0,1}, 2);
    }
    public static int numSubarraysWithSum_prefix_sum(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int x: P) {
            ans += count.getOrDefault(x, 0);
            count.put(x+S, count.getOrDefault(x+S, 0) + 1);
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; ++j) {
            // While sumLo is too big, iLo++
            sumLo += A[j];
            while (iLo < j && sumLo > S)
                sumLo -= A[iLo++];

            // While sumHi is too big, or equal and we can move, iHi++
            sumHi += A[j];
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0))
                sumHi -= A[iHi++];

            if (sumLo == S)
                ans += iHi - iLo + 1;
        }

        return ans;
    }

    public int numSubarraysWithSum_DP(int[] A, int S) {
        int[] dp = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) dp[i + 1] = dp[i] + A[i];
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int c : dp) {
            ans += count.getOrDefault(c, 0);
            count.put(c + S, count.getOrDefault(c + S, 0) + 1);
        }
        return ans;
    }
}
