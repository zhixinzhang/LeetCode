package DataStructure.DP;

/**
 * Created by zhang on 2018/1/21.
 */
// 21 knapsack 针对物品 每个物品取或不取

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
/**
 （1），v[i][0]=v[0][j]=0;
 （2），v[i][j]=v[i-1][j]   当w[i]>j
 （3），v[i][j]=max{v[i-1][j],v[i-1][j-w[i]]+v[i]}  当j>=w[i]
 */
// 间和空间复杂度均为O(N*V) O(N*V)
public class Knapsack_DP {
    static int[] A = new int[]{2,2,6,5,4};
    static int[] V = new int[]{6,3,5,4,6};
    static int m = 10;
    public  static void main(String[] args){
        _01_Knap(A,V,m);
        _01_Knap_Array(A,V,m);
        _complete_Knap(A,V,m);
    }
    public static void _01_Knap(int[] A, int[] V, int m) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j - A[i]] + V[i], dp[j - 1]);
                }
            }
        }
        System.out.println(dp[m]);
    }

    public static int _01_Knap_Array(int[] A, int[] V, int m) {
        int[][] dp = new int[A.length][m + 1];
        for (int j = 1; j < m + 1; j++) {
            if (j == A[0]) {
                dp[0][j] = V[0];
            } else {
                dp[0][j] = 0;
            }
            for (int i = 1; i < A.length; i++) {
                if (j < A[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i]] + V[i], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length - 1][m];
    }

    //背包问题三（最大价值+可重复选择）
    public static void _complete_Knap(int[] A, int[] V, int m){
            int[] dp = new int[m + 1];
            for (int i = 0; i < A.length; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j >= A[i]) {
                        dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
                    }
                }
            }
        System.out.println(dp[m]);
    }


//    public static void _complete_Knap() {
//        int[] weight = {3, 4, 6, 2, 5};
//        int[] val = {6, 8, 7, 5, 9};
//        int n = val.length;
//        int W = weight.length;
//        int maxw = 10;
//        int[][] dp = new int[n+1][W+1];
//        for(int i = 0 ; i<n ; i++){
//            for(int j = 0 ; j <= W ; j++){
//                if( j < W[i] ){
//                    dp[i+1][j] = dp[i][j];
//                }else{
//                    dp[i+1][j] = Math.max(dp[i][j], dp[i+1][j-w[i]]+v[i]);
//                }
//            }
//        }
//        System.out.println();
//    }
}
