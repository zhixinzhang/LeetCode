package DataStructure.Array;

/**
 * Created by zhang on 2018/5/1.
 */
public class _376_WiggleSubsequence_Greedy {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 2)
                return nums.length;
            int res = 1;
            int flag = 0;
            for (int i = 1; i<nums.length; i++){
                if (nums[i] - nums[i-1] > 0 && flag <= 0 || nums[i] - nums[i-1] < 0 && flag >= 0){
                    res++;
                    flag = nums[i] - nums[i-1];
                }
            }
            return res;
        }
    }
