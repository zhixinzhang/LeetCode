package DataStructure.Integer;

/**
 * Created by zhang on 2018/5/2.
 */
public class _397_IntegerReplacement_recursion {
    public int integerReplacement(int n) {
        if (n <= 3) return n - 1;
        if (n % 2 == 0) return 1 + integerReplacement(n / 2);
        else return 1 + Math.min(integerReplacement(n - 1), 1 + integerReplacement(n / 2 + 1));
    }


    public static int integerReplacement_DP(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[0] = 0;
        for (int i = 2; i<n; i++){
            if (i % 2 == 0)
                dp[i] = dp[i/2]+1;
            else{
                int a = dp[i+1] + 2;
                int b = dp[i-1] + 2;
                dp[i] = Math.min(a,b);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        integerReplacement_DP(7);
    }
}
