package company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/22/19
 * Time: 12:36 PM
 * Description:
 */


public class _50_POW_BinarySearch {
    // O(n) time
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }

    public double myPow_recur(double x, int n) {
        int k = Math.abs(n);
        return n > 0 ? recur(x, k) : 1 / recur(x, k);
    }

    public double recur(double x, int k){
        if(k == 0)  return 1;
        double half = recur(x, k / 2);

        if(k % 2 == 0)
            return half * half;
        else
            return half * half * x;

    }

    public double myPow_Binary(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
