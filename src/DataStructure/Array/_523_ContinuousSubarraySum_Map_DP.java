package DataStructure.Array;

import java.util.HashMap;

/**
 * @author Luke(New Man) Zhang
 * @Date 1/30/2021 1:25 AM
 * <p>
 * Description:
 * Key Point:
 */

//1、处理k为0的情况；2、用HashMap保存sum对k取余数，如果前序有余数也为sum % k的位置，那么就存在连续子数组和为k的倍数

public class _523_ContinuousSubarraySum_Map_DP {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(k != 0){
                sum = sum%k;
            }
            if(hm.containsKey(sum)){
                if(i - hm.get(sum) > 1){
                    return true;
                }
            }else{
                hm.put(sum,i);
            }
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
