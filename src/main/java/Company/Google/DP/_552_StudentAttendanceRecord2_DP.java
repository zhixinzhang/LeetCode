package Company.Google.DP;

/**
 * Created by zhang on 2018/6/24.
 * https://leetcode.com/problems/student-attendance-record-ii/discuss/101638/simple-java-on-solution
 */
// "A" "P" "L"
    // https://www.cnblogs.com/grandyang/p/6866756.html
public class _552_StudentAttendanceRecord2_DP {
    static final int M = 1000000007;

    public int checkRecord(int n) {
        /**  n = 1           res
         *   A L P            3
         *   n = 2
         *   "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"  8
         *   n = 3
         *   []
         * */
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }

        long res = PorL[n];
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }

        return (int) res;
    }
}
