package DataStructure.Array;

/**
 * Created by zhang on 2017/1/31.
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the
 * product of all the elements of nums except nums[i].
 Solve it without division and in O(n).
 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProtectofArrayExcept238 {  //limit  exceed
//    public static int[] productExceptSelf(int[] nums) {
//        int[] newNums = new int[nums.length];
//        for (int i = 0;i<nums.length;i++){
//          int curValue = product(i,nums);
//            newNums[i] =  curValue;
//        }
//        return  newNums;
//    }
//    private static int product(int i,int[] nums){
//        int curValue = 1;
//        for (int j = 0;j<nums.length;j++){
//            if (i != j){
//                curValue = curValue*nums[j];
//            }
//        }
//        return curValue;
//    }


    public static int[] productExceptSelf(int[] nums) {
        int[] newNums = new int[nums.length];
        newNums[0] = 1;
        for(int i = 1;i<nums.length;i++){
            newNums[i] = nums[i-1] * newNums[i-1];
        }
        int right = 1;
        for(int i = nums.length-1; i>=0;i--){
            newNums[i] *= right;
            right *= nums[i];
        }
        return  newNums;
    }




    public  static  void main (String args[]){
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);

    }
}
