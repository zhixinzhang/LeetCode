package DataStructure.Array;

/**
 * Created by zhang on 2017/11/8.
 * Count the number of prime numbers less than a non-negative number, n.
 N 个数里面找质数
 */
public class _204_CountPrimes_DP {
    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
    public static void main(String[] args){
        int n = 16;
        int c = countPrimes(n);
    }
}
