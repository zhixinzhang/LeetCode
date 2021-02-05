package Company.uber;


/**
 * Created by zhang on 2018/9/11.
 */
public class _283_MoveZeroArray {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,0,0,4,5,0,6,7};
        // 0 0 1 2 3 4 5 6 7  O(n) O(n)
        // two pointer  i -> index that element not 1  j  index that element is 1
        moveZeroes_toLeft(new int[]{1,2,3,4,0,0,5});
    }

    public static void moveZeroes_toRight(int[] nums) {
        int index = 0;
        for(int i = 0;i<nums.length;++i){
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
                    swap(nums, i, j);
                }
            }
        System.out.println(nums);
    }
        public static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


}
