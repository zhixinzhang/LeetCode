package DataStructure.Integer;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/20/19
 * Time: 1:37 PM
 * Description:
 */


public class _509_FibonacciNumber_DP_recursion {
    // O(2 ^ n)  O(N). We need space proportional to N to account for the max size of the stack, in memory

    public int fib(int N) {
        if(N <= 1)
            return N;
        int l = fib(N - 1);
        int r = fib(N - 2);
        int res = l + r;
        return res;
    }

    //O(N)
    public int fib_DP(int N) {
        if(N <= 1)
            return N;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

// O(N) time + O(1) Space
    public int fib_DP_constant(int N) {
        if (N <= 1) {
            return N;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
