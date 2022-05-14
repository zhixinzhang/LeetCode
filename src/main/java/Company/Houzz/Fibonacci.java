package Company.Houzz;

/**
 * Created by zhang on 2018/1/16.
 */
// f(n) = f(n-1) + f(n-2);
// recursion is when a function calls itself
public class Fibonacci {
    public static void main(String[] args){
        System.out.println(fibonacci_recursion(3));
    }

    // O(2^n).
    public static int fibonacci_recursion(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        return fibonacci_recursion(n-1) + fibonacci_recursion(n-2);
    }
// O(n);
    public int fibonacci(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        int res = 0,prev0 = 0;
        int prev1 = 1;
        for(int i = 2; i<n;i++){
            res = prev0 + prev1;
            prev0 = prev1;
            prev1 = res;
        }
        return res;
    }
}
