package google.DP;

/**
 * Created by zhang on 2018/7/4.
 */
public class Fibonacci_DP_recursion {
//    Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
    public int fib_recur(int n){
        if ( n <= 1)
            return n;
        else
            return fib_recur(n-1)+ fib_recur(n-2);
    }
//    Time Complexity: O(n)
//    Extra Space: O(n)
    public int fib_DP(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int fib_DP_Optimal(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public int fib(int N) {
        if(N <= 1)
            return N;
        int sum = 0, a = 0, b = 1;
        int i = 2;
        while(i++ <= N){
            sum = a + b;
            a = b;
            b = sum;
            // i++;
        }
        return sum;
    }
}
