package DataStructure.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/18/19
 * Time: 7:08 PM
 * Description:
 */


public class _932_BeautifulArray_DividConquer {
    public static void main(String[] args){
        beautifulArray(5);
    }
    static Map<Integer, int[]> memo;
    public static int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public static int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x : f((N + 1) / 2))  // 奇数
                ans[t++] = 2 * x - 1;
            for (int x : f(N / 2))  // 偶数
                ans[t++] = 2 * x;
        }
        memo.put(N, ans);
        return ans;
    }
}
