package company.uber;

import java.util.Arrays;

/**
 * Created by zhang on 2018/9/15.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=393447&ctid=201324
 * 找三个数和 大于target的
 */
public class _259_3SumSmaller_FollowUp {
    public static void main(String[] args){
//        threeSumSmaller(new int[]{-2, -1, 0, 1, 2, 3, 4}, 2);
        threeSumGreater(new int[]{-2, -1, 0, 1, 2, 3, 4}, 2);
    }

    public static int threeSumSmaller(int[] nums, int target) {
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

    public static int threeSumGreater(int[] nums, int target){
        if (nums == null || nums.length <= 2)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        //[-2, -1, 0, 1, 2, 3, 4]
        int l, r;
        for (int i = 0; i < nums.length-2; i++){
            l = i + 1;
            r = l + 1;
            while (l < r){
                if (nums[i] + nums[l] + nums[r] >= target){
                    res += n - r;
                    l++;
                }else {
                    r++;
                }
            }
        }

        return res;
    }
}
