package google.Array;

/**
 * Created by zhang on 2018/6/15.
 */
public class PlusOne_Backtrack_Iterator {
    public static int[] plusOne_iter(int[] nums){
        int n = nums.length-1;
        for (int i = n; i >= 0; i--){
            if (nums[i] != 9){
                nums[i] ++;
                break;
            }else {
                nums[i] = 0;
            }
        }
        if (nums[0] == 0){
            int[] res = new int[nums.length+1];
            res[0] = 1;
            return res;
        }
        return nums;

    }


    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{1};
        return helper(digits,digits.length-1);
        // [ 1 2 3 9] -- [1 2 4 0]
        // [9 9] [100]
    }
    public static int[] helper(int[] digits, int index){
        // 1 2 3 9   dig 1 2 3 0    newD 0 0 0 0 0
        // 1 2 3 0   dig 1 2 3 0  --> 1 2 4 0
        if (digits[index] < 9){
            digits[index] ++;
            return digits;
        }else {
            if (index != 0){
                digits[index] = 0;
                return helper(digits,index-1);
            }else {
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res;
            }
        }
    }
    public static void main(String[] args){

        plusOne_iter(new int[]{9,9});
        plusOne(new int[]{1,2,3,9});
    }
}
