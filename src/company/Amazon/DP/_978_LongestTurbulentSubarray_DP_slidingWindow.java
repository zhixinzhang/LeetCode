package company.Amazon.DP;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/18/19
 * Time: 7:34 PM
 * Description:
 *https://leetcode.com/problems/longest-turbulent-subarray/discuss/221935/Java-O(N)-time-O(1)-space
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 */


public class _978_LongestTurbulentSubarray_DP_slidingWindow {
    public static void main(String[] args){
        maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9});
    }

    public static int maxTurbulenceSize(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }
}
