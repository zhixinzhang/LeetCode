package DataStructure.Array;
/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/12/19
 * Time: 4:36 PM
 * Description:
 */


public class _931_MinimumFallingPathSum_DP {
    public static void main(String[] args){
        minFallingPathSum_best(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    //O(mn) time O(m)space
    public static int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int n = A[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = A[0][i];
        for (int i = 1; i < A.length; i++){
            int[] clDP = dp.clone();
            for (int j = 0; j < n; j++){
                int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
                if(j - 1 >= 0)
                    l = dp[j-1];
                if(j + 1 < n)
                    r = dp[j+1];
                int mid = dp[j];
                clDP[j] = Math.min(l, Math.min(r, mid)) + A[i][j];
            }
            dp = clDP;
        }
        Integer res = Integer.MAX_VALUE;
        for (int i : dp)
            res = Math.min(res, i);
        return res;
    }
    public static int minFallingPathSum_best(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0)
            return 0;
        for (int i = 1; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
                if (j >= 1)
                    l = A[i-1][j-1];
                if(j + 1 < A[0].length)
                    r = A[i-1][j+1];
                int mid = A[i-1][j];
                A[i][j] = Math.min(l, Math.min(r, mid)) + A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : A[A.length-1]){
            res = Math.min(res, i);
        }
        return res;
    }
}
