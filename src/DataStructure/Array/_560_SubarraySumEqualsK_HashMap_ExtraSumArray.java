package DataStructure.Array;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/subarray-sum-equals-k/solution/
 * Key Point:
 */

public class _560_SubarraySumEqualsK_HashMap_ExtraSumArray {

/**
 * m(i,j)=sum(0,j)-sum(0,i), where sum(i,j)
 * represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
 *
 * */
    public int subarraySum_Map(int[] nums, int k) {
        int count = 0, sum = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }

        Map<Integer, Integer> cached = new HashMap<>();  // key -> sum,  Value -> count number of sum
        cached.put(0, 1);
        for (int num : nums){
            sum += num;
            if (cached.containsKey(sum - k)){
                count += cached.get(sum - k);
            }
            cached.put(sum, cached.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    /**
     * Solution 2 :
     *
     * Time complexity : O(n^2)O(n
     * 2
     *  ). Considering every possible subarray takes O(n^2)O(n
     * 2
     *  ) time. Finding out the sum of any subarray takes O(1)O(1) time after the initial processing of O(n)O(n) for creating the cumulative sum array.
     *
     * Space complexity : O(n)O(n). Cumulative sum array sumsum of size n+1n+1 is used.
     *
     * */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }

        int[] sum = new int[nums.length + 1];
        sum[0] = nums[0];
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j <= nums.length; j++){
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
