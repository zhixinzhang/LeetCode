package Company.Apple;

/**
 * Created by zhang on 2018/2/9.
 */
public class _7_ReverseInteger {
    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        // 901000
        while (x > 0) {
            // avoid overflowing
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - x % 10) < res * 10) {
                return 0;
            }
            int tail = x % 10;
            res = res * 10 + tail;
            x /= 10;
        }

        return sign * res;
    }
    public static void main(String[] args){
        reverse(-901000);
    }
}
