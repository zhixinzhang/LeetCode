package DataStructure.Array;

/**
 * Created by zhang on 2017/3/13.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
//动态
public class MaximumSubarray53 {
    public static int maxSubArray(int[] nums) {
        int global = nums[0];
        int maxLocal = nums[0];

        for(int i =1;i<nums.length;i++){
            maxLocal = Math.max(nums[i],nums[i]+maxLocal);
            global = Math.max(global,maxLocal);
            int a =0;
        }
        return global;
    }

    public  static  void main(String args[]){
        int[] nums  = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
