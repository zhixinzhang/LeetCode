package DataStructure.Integer;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/21/19
 * Time: 2:59 PM
 * Description:
 */


public class _878_NthMagicalNumber_BinarySearch {
    public int nthMagicalNumber(int N, int A, int B) {
        if (B < A) {
            return nthMagicalNumber(N, B, A);
        }
        long start = 0, end = Long.MAX_VALUE;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (check(A, B, mid) < N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int) (start % (1e9 + 7));
    }
    private long check(int A, int B, long mid) {
        long count = 0;
        int lcm = lcm(A, B);

        count += (mid / A);
        if (lcm != B) {
            count += (mid / B);
            count -= (mid / lcm);
        }
        return count;
    }

    public int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}
