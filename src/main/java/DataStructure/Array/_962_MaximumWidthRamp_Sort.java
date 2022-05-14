package DataStructure.Array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/18/19
 * Time: 9:43 PM
 * Description:
 */


public class _962_MaximumWidthRamp_Sort {
    public static void main(String[] args){
        solve(new int[]{6,0,8,2,1,5});
    }
    public static int solve(int[] A){
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
