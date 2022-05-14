package google.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2018/8/3.
 */
public class _259_3SumSmaller_sort {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        Arrays.sort(nums);
        int L = nums.length;
        int count = 0;
        for(int i = 0; i < L-2; i++){
            int lo = i+1;
            int hi = L-1;
            while(lo<hi) {
                if(nums[i] + nums[lo] + nums[hi] < target) {
                    count += hi-lo;
                    lo++;
                }
                else
                    hi--;
            }
        }
        return count;
    }
}
