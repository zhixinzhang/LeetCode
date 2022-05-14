package DataStructure.Array;

/**
 * Created by zhang on 2017/1/17.
 */
public class moveZeros {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,0,0,4,5,0,6,7};
        moveZeroes(arr);
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0;i<nums.length;++i){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index;i< nums.length;++i){
            nums[i] = 0;
        }
    }
}
