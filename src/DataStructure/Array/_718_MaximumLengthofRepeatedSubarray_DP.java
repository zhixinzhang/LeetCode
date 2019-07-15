package DataStructure.Array;

//https://www.cnblogs.com/grandyang/p/7801533.html
//我们注意观察，dp值不为0的地方，都是当A[i] == B[j]的地方，而且还要加上左上方的dp值，即dp[i-1][j-1]，所以当前的dp[i][j]就等于dp[i-1][j-1] + 1，而一旦A[i] != B[j]时，直接赋值为0，不用多想，因为子数组是要连续的，一旦不匹配了，
//就不能再增加长度了。我们每次算出一个dp值，都要用来更新结果res，这样就能得到最长相同子数组的长度了
public class _718_MaximumLengthofRepeatedSubarray_DP{

	    public int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length ==0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        // dp formula dp[m][n] represent A[0,,m]B[0,,,n] maximum subarray
        //dp[m][n] = Math.max(dp[m-1][n-1]+1,0)
        dp[0][0] = 0;
        for(int i = 1;i<=m;i++){
            for(int j = 1; j<=n;j++){
                dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1]+1:0;
                res = Math.max(dp[i][j],res);
            }
        }
        return res;
    }
}