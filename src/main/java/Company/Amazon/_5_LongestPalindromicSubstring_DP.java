package Company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/12/19
 * Time: 2:36 PM
 * Description:
 * brute  force O(n^3)
 * dp O(n ^ 2)
 */


public class _5_LongestPalindromicSubstring_DP {

    // O(n ^ 2) space O(n ^ 2)
    // DP[Left][Right] is palidrom
// when  S[Left+1][right-1] and S[Left] == S[Right] 
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

    /**
     * We observe that a palindrome mirrors around its center. 
     * Therefore, a palindrome can be expanded from its center, and there are only 2n−12n - 12n−1 such centers.

You might be asking why there are 2n−12n - 12n−1 but not nnn centers? The reason is 
the center of a palindrome can be in between two letters. Such palindromes have even number 
of letters (such as "abba") and its center are between the two 'b's.
     * 
    */
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i<s.length(); i++){
          int lenOdd = startFromMiddle(i, i+1, s);
          int lenEven = startFromMiddle(i,i, s);
          int lenMax = Math.max(lenOdd, lenEven);
          
          if(lenMax > end - start){
            start = i - (lenMax-1)/2;
            end = i + (lenMax/2);
          }
        }
        return s.substring(start, end+1);
      }
    
  private int startFromMiddle(int left, int right, String s) {
      int L = left, R = right;
      while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
          L--;
          R++;
      }
      return R - L - 1;
  }

}  



