package DataStructure.Array;


import java.util.Arrays;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/discuss/709227/JavaC%2B%2BPython-Two-Sum
 * Key Point:
 *
 * Almost same as problem two sum.
 * If we want to know the count of subarray in sorted array A,
 * then it's exactly the same.
 * Make sure you can do two sum before continue.
 *
 *
 * Explanation
 * Sort input A first,
 * For each A[i], find out the maximum A[j]
 * that A[i] + A[j] <= target.
 *
 * For each elements in the subarray A[i+1] ~ A[j],
 * we can pick or not pick,
 * so there are 2 ^ (j - i) subsequences in total.
 * So we can update res = (res + 2 ^ (j - i)) % mod.
 *
 * We don't care the original elements order,
 * we only want to know the count of sub sequence.
 * So we can sort the original A, and the result won't change.
 *
 *
 * Complexity
 * Time O(NlogN)
 * Space O(1) for python
 * (O(N) space for java and c++ can be save anyway)
 */

public class _1498_NumberofSubsequencesThatSatisfytheGivenSumCondition_TwoPointer {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long[] modPow = new long[nums.length + 1];
        modPow[0] = 1;
        int MOD = (int)1e9 + 7;
        for (int i = 1; i < modPow.length; i++) {
            modPow[i] = 2 * modPow[i-1] % MOD;
        }

        //It is impossible to use 2^n in Java when n is very large, but Python can
        //So we need to use DP-method to pre-calculate 2^n % 1e9+7
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left <= right){
            if (nums[left] + nums[right] > target) {
                right --;
            } else {
                long curPower = modPow[right - left];
                result += curPower%MOD;
                left++;
            }
        }

        result = result % MOD;
        return (int) result;
    }
}
