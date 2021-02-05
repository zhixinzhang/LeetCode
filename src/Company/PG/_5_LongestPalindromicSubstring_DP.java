package Company.PG;

/**
 * Created by zhang on 2018/1/27.
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
// 三种方法 DataStructure.DP
// DataStructure.DP O(n^2) space O(n*2)
// dp[i][j] = from index i to index j (in string S)  is palindromic set true
//    p[i][j] = (s[i] == s[j] && dp[i+1][j-1] == true)
//
public class _5_LongestPalindromicSubstring_DP {
    public String longestPalindrome(String s) {
        if(s == null || s.length()==0)
            return "";
        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for(int i=s.length()-1;i>=0;i--) {
            for(int j=i;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1])) {
                    palin[i][j] = true;
                    if(maxLen<j-i+1) {
                        maxLen=j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    //O(n^2) Time, O(n) Space
    // at row i, dp[j] is true if s[j, i] is palindrome
    // opt[i] = max{i-j+1 if s[i] == s[j], j=0,...,i && (i-j <= 1 || isPalindrome(j+1, i-1)), opt[i-1]}
    // isPalindrome(j, i) <=> s[i] == s[j] && isPalindrome(j+1, i-1)
    public String longestPalindrome_DP2(String s) {
        int N = s.length();
        boolean[] isPalindrome = new boolean[N];
        isPalindrome[0] = true;
        String opt = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
//                int opt_tmp = 0;
                if (s.charAt(i) == s.charAt(j) && (i-j<=1 || isPalindrome[j+1])) {
                    int len = i-j+1;
                    if (len > opt.length()) {
                        opt = s.substring(j, i+1);
                    }
                    isPalindrome[j] = true;
                } else isPalindrome[j] = false;
            }
        }
        return opt;
    }


}
