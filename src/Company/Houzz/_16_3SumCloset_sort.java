package Company.Houzz;

import java.util.Arrays;

/**
 * Created by zhang on 2018/1/21.
 */
//O(logn)
public class _16_3SumCloset_sort {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, closest = 0;
        for (int k=0; k<nums.length-2; ++k) {
            for (int i=k+1, j=nums.length-1; i<j; ) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == target) { return target; }
                else if (sum > target) {
                    if (sum-target < diff) {
                        diff = sum-target;
                        closest = sum;
                    }
                    --j;
                } else {
                    if (target-sum < diff) {
                        diff = target-sum;
                        closest = sum;
                    }
                    ++i;
                }
            }
        }
        return closest;
    }
}
