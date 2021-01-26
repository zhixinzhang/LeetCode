package DataStructure.Array;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/max-consecutive-ones-iii/solution/
 * Key Point:
 *
 * Intuition
 *
 * To find the longest subarray with contiguous 1's we might need to find all the subarrays first.
 * But do we really need to do that? If we find all the subarrays we are essentially finding out so many unnecessary overlapping subarrays too.
 */

public class _1004_MaxConsecutiveOnes3_TwoPointer_SlidingWindow {

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length <= K) {
            return K;
        }

        int left = 0, right = 0, ans = 0;
        for ( ; right < A.length; right++){
            if (A[right] == 0) {
                K--;
            }
            while (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left ++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
