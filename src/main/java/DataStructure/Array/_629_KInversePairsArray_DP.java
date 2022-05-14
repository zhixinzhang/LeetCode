package DataStructure.Array;

// ****很好的DP
//https://www.cnblogs.com/grandyang/p/7111385.html
public class _629_KInversePairsArray_DP{
	    public int kInversePairs(int n, int k) {
          long[][] dp = new long[n+1][k+1];  
          
        for(int i=0; i<=n; i++)  
            dp[i][0] = 1;  
          
        for(int i=1; i<=n; i++)  
            for(int j=1; j<=k; j++) {  
                dp[i][j] = dp[i][j-1]+dp[i-1][j];  
                if(j-i >= 0) dp[i][j] -= dp[i-1][j-i];  
                dp[i][j] += 1000000007;  
                dp[i][j] %= 1000000007;  
            }  
          
        return (int) dp[n][k];  
    }
}