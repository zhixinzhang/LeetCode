package DataStructure.Array;

//这里用dp[i][j][k]表示前i个字符串在0个数不超过j、1个数不超过k时最多能选取的字符串个数。统计第i个字符串中0和1个数分别为cnt0和cnt1，如果取第i个字符串则dp[i][j][k] = dp[i-1][j-cnt0][k-cnt1] + 1，如果不取第i个字符串则dp[i][j][k]
// = dp[i-1][j][k]，取两者大的作为dp[i][j][k]的值。由于dp[i][j][k]只与dp[i-1][*][*]相关，所以这里可以重复使用m*n个数据将空间复杂度降为O(m*n)，

//dp[i][j] = Math.max(dp[i-s.count('0')][j-s.count('1')]+1, dp[i][j])
public class _474_OnesandZeroes_DP{
 public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m+1][n+1];
    for (String s : strs) {
        int[] count = count(s);
        for (int i=m;i>=count[0];i--) 
            for (int j=n;j>=count[1];j--) 
                dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
    }
    return dp[m][n];
}
    
public int[] count(String str) {
    int[] res = new int[2];
    for (int i=0;i<str.length();i++)
        res[str.charAt(i) - '0']++;
    return res;
 }

}