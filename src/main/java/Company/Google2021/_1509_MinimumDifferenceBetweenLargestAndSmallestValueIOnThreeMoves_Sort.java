package Company.Google2021;

import java.util.Arrays;

/**
 * @author Luke Zhang
 * @Date 2021-08-12 16:21
 *
 *
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/discuss/730567/JavaC%2B%2BPython-Straight-Forward
 */
public class _1509_MinimumDifferenceBetweenLargestAndSmallestValueIOnThreeMoves_Sort {
    public int minDifference(int[] A) {
        int n = A.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }
}
