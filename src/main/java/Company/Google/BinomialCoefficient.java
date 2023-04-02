package Company.Google;

/**
 * Created by zhang on 2017/12/3.
 */
public class BinomialCoefficient {
    // Returns value of Binomial Coefficient C(n, k)
    static int binomialCoeff(int n, int k)
    {
        int res = 1;

        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    /* Driver program to test above function*/
    public static void main(String[] args)
    {
        int n = 8;
        int k = 2;
        System.out.println("Value of C("+ n + ", " + k+ ") "
                + "is" + " "+ binomialCoeff(n, k));
    }

}
