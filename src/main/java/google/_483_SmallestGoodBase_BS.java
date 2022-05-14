package google;

/**
 * Created by zhang on 2018/5/30.
 * https://segmentfault.com/a/1190000008366710
 */
public class _483_SmallestGoodBase_BS {
    public String smallestGoodBase(String n) {
        // return k
        // n = 1 + k^2 + k^3 + k^4
        long num = Long.valueOf(n);
        for (int m = Math.min((int) Math.pow(num,0.5),64); m>1;m--){
            long k = (long) Math.pow(num,1.0/m);
            if(isGoodBase(num, k, m))
                return String.valueOf(k);
        }
        return String.valueOf(num - 1);
    }
    private boolean isGoodBase(long num, long base, int m) {
        long sum = num;
        long val = 1;
        // calculate k^0, k^1,  ..., k^m
        for(int i = 0; i <= m; i++) {
            sum -= val;
            val *= base;
        }
        return sum == 0;
    }
}
