package google.DP;

/**
 * Created by zhang on 2018/6/27.
 * dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j]) or if we can find some pattern in string from i to j which will result in more less length.

 Time Complexity = O(n^3)

 https://segmentfault.com/a/1190000008341304
 https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95599/Accepted-Solution-in-Java
 *
 *
 */
public class _471_Encode_DP {

    public String encode_Best(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = "" + s.charAt(i);
        // j - i
        for(int len = 1; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                // enumerate seperate k
                for(int k = i; k < j; k++) {
                    int left = dp[i][k].length();
                    int right = dp[k+1][j].length();
                    // update shortest encoded string within (i, j)
                    if(dp[i][j] == null || left + right < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
                // update string within (i, j), encode abcabc
                String sub = s.substring(i, j + 1);
                int index = (sub + sub).indexOf(sub, 1);
                if(index < sub.length()) {
                    sub = (sub.length() / index) + "[" + dp[i][i+index-1] + "]";
                }
                if(dp[i][j] == null || dp[i][j].length() > sub.length()) {
                    dp[i][j] = sub;
                }
            }
        }

        return dp[0][n-1];
    }
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];

        for(int l=0;l<s.length();l++) {
            for(int i=0;i<s.length()-l;i++) {
                int j = i+l;
                String substr = s.substring(i, j+1);
                // Checking if string length < 5. In that case, we know that encoding will not help.
                if(j - i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    // Loop for trying all results that we get after dividing the strings into 2 and combine the   results of 2 substrings
                    for(int k = i; k<j;k++) {
                        if((dp[i][k] + dp[k+1][j]).length() < dp[i][j].length()){
                            dp[i][j] = dp[i][k] + dp[k+1][j];
                        }
                    }

                    // Loop for checking if string can itself found some pattern in it which could be repeated.
                    for(int k=0;k<substr.length();k++) {
                        String repeatStr = substr.substring(0, k+1);
                        if(repeatStr != null
                                && substr.length()%repeatStr.length() == 0
                                && substr.replaceAll(repeatStr, "").length() == 0) {
                            String ss = substr.length()/repeatStr.length() + "[" + dp[i][i+k] + "]";
                            if(ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }
}
