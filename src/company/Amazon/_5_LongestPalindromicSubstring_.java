package company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/12/19
 * Time: 2:36 PM
 * Description:
 * brute  force O(n^3)
 * dp O(n ^ 2)
 */


public class _5_LongestPalindromicSubstring_ {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return s;
        int max = 0;
        String res = "";
        for(int i = 0; i < s.length(); i++){
            for(int r = s.length() - 1; r >= i; r--) {
                if (isPalin(s, i, r))
                    if (max < r - i + 1){
                        res = s.substring(i, r + 1);
                        max = r - i + 1;
                    }
            }
        }
        return res;
    }
    public static boolean isPalin(String s, int i, int r){
        while(i <= r){
            if(s.charAt(i) != s.charAt(r))
                return false;
            i++;
            r--;
        }
        return true;
    }

    public static void main(String[] args){
        longestPalindrome("babad");
    }



    public String longestPalindrome_DP(String s) {
        if(s == null || s.length() <= 1)
            return s;

        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
