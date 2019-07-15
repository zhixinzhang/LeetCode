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
    public static boolean solu_DP(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i<nums.length; i++){
            sum[i] = nums[i] + sum[i-1];
        }
        for (int len = 2; len <= nums.length; len++){
            for (int i = 0; i<nums.length; i++){
                int l = i, r = i+len-1;
                if (r >= nums.length) break;
                int curS = sum[r] - sum[l] + nums[l];
                if (curS % k == 0)
                    return true;
            }
        }
        return false;
    }
}
