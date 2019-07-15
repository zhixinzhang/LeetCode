package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/8/19
 * Time: 7:43 PM
 * Description:
 */


public class _1007_MinimumDominoRotationsForEqualRow_ {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) { return -1; }
        int[] countA = new int[7]; // countA[i] records the occurrence of i in A.
        int[] countB = new int[7]; // countB[i] records the occurrence of i in B.
        int[] same = new int[7]; // same[k] records the occurrence of k, where k == A[i] == B[i].
        for (int i = 0; i < A.length; ++i) {
            ++countA[A[i]];
            ++countB[B[i]];
            if (A[i] == B[i]) { ++same[A[i]]; }
        }
        for (int i = 1; i < 7; ++i) {
            if (countA[i] + countB[i] - same[i] >= A.length) {
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }
        return -1;
    }
}
