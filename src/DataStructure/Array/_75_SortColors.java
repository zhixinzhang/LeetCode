package DataStructure.Array;

/**
 * Created by zhang on 2017/9/22.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
/**用三个指针  两个指针左右 一个指针当前
 *
 * */
public class _75_SortColors {
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <=1 ){
            return;
        }

        int leftPoint = 0;
        int curPoint = 0;
        int rightPoint = nums.length-1;
        rightPoint = findRightPoint(nums,rightPoint);
        while (curPoint <= rightPoint){
            if (nums[curPoint] == 0)
                swap(nums,curPoint++,leftPoint++);
            else if (nums[curPoint] == 2)
                swap(nums,curPoint,rightPoint--);
            else
                curPoint++;
        }
//        for (int i = 0; i <nums.length ; i++) {
//            if (curPoint == leftPoint && nums[curPoint] == 2 && leftPoint < rightPoint){
//                int tmpCur = nums[curPoint];
//                int tmpRight = nums[rightPoint];
//
//            }else if(){
//
//            }
//        }
    }

    public static void swap(int[] nums, int a, int b){
        if (nums[a] != nums[b]){
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }
    public static int findRightPoint(int[] nums, int rightPoint){
        while (nums[rightPoint] == 2){
            rightPoint --;
        }
        return rightPoint;
    }

    public static void main(String args[]){
        int[] nums = {2,0,1,2,0,1,2,0,2,0,1,1,2,2};
        sortColors(nums);
    }
}
