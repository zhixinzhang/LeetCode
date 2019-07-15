package DataStructure.String;
import java.util.*;
//Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.


public class _516_LongestPalindromicSubsequence_DP{
    //dp[i][j] represent length of palindromic
    //inital dp[0][0] = 1
    //dp[i][j] = dp[i-1][j+1]+2 (left = right) dp[i][j+1] dp[i-1][j] 
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()]; 
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}