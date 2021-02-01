package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/23/19
 * Time: 1:27 PM
 * Description:
 */


public class _283_MoveZeroArray_TwoPointer {
    public static void main(String[] args){
        moveZeroes_toRight(new int[]{0,0,2,0,1,0, 3});
    }
    public static void moveZeroes_twopointer_swap(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int l = 0, r = 0;
        while (r <= nums.length-1){
            while (r <= nums.length-1 && nums[r] == 0)
                r++;
            while (l <= nums.length-1 && nums[l] != 0)
                l++;

            if (r >= nums.length || l>r)
                break;
            swap(l,r,nums);
        }
        System.out.println(nums);
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // better solution use swap
    public void moveZeroes(int[] nums) {
        int indexOfZero = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                swap(indexOfZero, i, nums);
                indexOfZero++;
            }
        }
    }

    public static void moveZeroes_toRight(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index;i< nums.length;++i){
            nums[i] = 0;
        }
        System.out.println(nums);
    }


    public static void moveZeroes_toLeft(int[] nums){
        // 0 0 2 0 0 1
        int n = nums.length;
        int i = n;           // i is index of 0 element
        for (int j = n-1; j >=0; j--) {
            if (nums[j] != 0) {
                i--;
                swap(i, j, nums);
            }
        }
        System.out.println(nums);
    }
}
