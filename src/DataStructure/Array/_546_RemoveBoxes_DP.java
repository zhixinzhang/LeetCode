package DataStructure.Array;

//http://blog.csdn.net/lizhb5/article/details/70161489
public class _546_RemoveBoxes_DP{
	 public int removeBoxes(int[] boxes) {  
        int n = boxes.length;  
        if(n == 0)  return 0;  
        int[][][] dp = new int[n][n][n];  
          
        // 初始化终止状态  
        for(int i=0; i<n; i++)  
            for(int k=0; k<=i; k++)  
                dp[i][i][k] = (1+k)*(1+k);  
          
        // dp数组求解，先计算距离差小的  
        for(int d=1; d<n; d++)  
            for(int r=d; r<n; r++) {  
                int l = r - d;  
                  
                for(int k=0; k<=l; k++) {  
                    // 现在就消掉left  
                    int ret = (k+1)*(k+1) + dp[l+1][r][0];  
                      
                    // 留待后用，可能有多个与left相同的color，与最接近的那个结合并不一定是最佳  
                    for(int m=l+1; m<=r; m++)  
                        if(boxes[m] == boxes[l])  
                            ret = Math.max(ret, dp[l+1][m-1][0] + dp[m][r][k+1]);  
  
                    dp[l][r][k] = ret;  
                }  
            }  
          
        return dp[0][n-1][0];   // 最后那个肯定是消掉，不用留下来  
    }  
}