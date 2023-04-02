package google;

/**
 * Created by zhang on 2018/5/23.
 * https://blog.csdn.net/laputafallen/article/details/79719253
 */
public class _679_24Game_backtrack {
    static final double eps = 0.001;
    public static boolean judgePoint24(int[] nums) {
        return f(new double[] {nums[0], nums[1], nums[2], nums[3]});
    }

    private static boolean f(double[] a) {
        if (a.length == 1) {
            if(Math.abs(a[0] - 24.0) < eps)
                return true;

        }
        for (int i = 0; i < a.length; i++) {
            //注意这里，与解法1不同,因为在compute里面已经包含了两个数的前后顺序
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, l = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[l++] = a[k];
                    }
                }
                for (double k : compute(a[i], a[j])) {
                    b[a.length - 2] = k;
                    if (f(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //这里很好，把取数逻辑分离开了
    private static double[] compute(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
    }

    public static void main(String[] args){
        judgePoint24(new int[]{4,1,8,7});
    }

}
