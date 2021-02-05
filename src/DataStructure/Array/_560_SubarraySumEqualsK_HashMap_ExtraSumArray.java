package DataStructure.Array;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/subarray-sum-equals-k/solution/
 * Similar: 523. Continuous Subarray Sum , 437. Path Sum III
 * Key Point:
 *
 */

public class _560_SubarraySumEqualsK_HashMap_ExtraSumArray {

/**
 * m(i,j)=sum(0,j)-sum(0,i), where sum(i,j)
 * represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
 *
 * The idea behind this approach is as follows: If the cumulative sum(represented by sum[i]sum[i] for sum up to i^{th}i
 * th
 *   index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.
 *
 * Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs. We store the data in the form: (sum_i, no. of occurrences of sum_i)(sum
 * i
 * ​
 *  ,no.ofoccurrencesofsum
 * i
 * ​
 *  ). We traverse over the array numsnums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum sum-ksum−k has occurred already,
 *  since it will determine the number of times a subarray with sum kk has occurred up to the current index. We increment the countcount by the same amount.
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
