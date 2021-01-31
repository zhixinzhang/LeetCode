package company.zillow.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2018/8/22.
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2
 * that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 */
public class _523_ContinuousSubarraySum_MAP_DP {
    public static void main(String[] args){

        solu_DP(new int[]{23, 2, 4, 6, 7}, 6);
    }
    public static boolean solu(int[] nums, int k){
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            int curM = sum % k;
            if (hm.containsKey(curM))
                return true;
            else
                hm.put(curM, i);
        }
        return false;
    }

    /**
     * Algorithm
     *
     * We can optimize the brute force approach to some extent, if we make use of an array sumsum that stores the cumulative sum of the elements of the array, such that sum[i]sum[i] stores the sum of the elements upto the i^{th}i
     * th
     *   element of the array.
     *
     * Thus, now as before, we consider every possible subarray for checking its sum. But, instead of iterating over a new subarray everytime to determine its sum, we make use of the cumulative sum array. Thus, to determine the sum of elements from the i^{th}i
     * th
     *   index to the j^{th}j
     * th
     *   index, including both the corners, we can use: sum[j] - sum[i] + nums[i]sum[j]−sum[i]+nums[i].
     *
     *   Time complexity : O(n^2)O(n
     * 2
     *  ). Two for loops are used for considering every subarray possible.
     *
     * Space complexity : O(n)O(n). sumsum array of size nn is used.
     *
     * */


    public static boolean solu_DP(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int summ = sum[end] - sum[start] + nums[start];
                if (summ == k || (k != 0 && summ % k == 0))
                    return true;
            }
        }
        return false;
    }
}
