package DataStructure.String;

import java.util.HashMap;
import java.util.Map;

//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//dp[n] = dp[n-1]+1 
public class _91_DecodeWays_DP_Recursion {


    /**
     * Time Complexity: O(N)O(N), where NN is length of the string. Memoization helps in pruning the recursion tree and hence decoding for an index only once. Thus this solution is linear time complexity.
     *
     * Space Complexity: O(N)O(N). The dictionary used for memoization would take the space equal to the length of the string. There would be an entry for each index value. The recursion stack would also be equal to the length of the string.
     * */
    Map<Integer, Integer> cache = new HashMap<>();
    public int numDecoding_Recursion(String s){
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int res = recur(0, s);
        return res;    }

    private int recur(int index, String s){
        // if we reach the end of the string, then we return 1
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (index == s.length() - 1) {
            return 1;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int ans = recur(index + 1, s);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26) {
            ans += recur(index+2, s);
        }

        cache.put(index, ans);
        return ans;
    }

    // O(n) and O(n)
    // dp[i] += dp[i -1] 如果小於26 大於10 還要加上dp[i - 2]
    public int numDecodings_DP(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        // DP integer array to store the subproblem results

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i += 1) {
            // Check if successful single digit decode is possible.
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }

            // check if successful two digital
            int number = Integer.valueOf(s.substring(i-2, i));
            if (number >= 10 && number <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}