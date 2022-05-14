package DataStructure.Array;

/**
 * Created by zhang on 2017/10/20.
 */

import java.util.Arrays;

/**{1,2,6,8,5,4};  ----  128456  就是找到下一个 比他大的数
 * 首先从后往前search nums[i] > nums[i-1] 第一个降序的数 8 跟 6 互换 128654
 * 然后 654 从小到大排列
 * */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        // 158476531
        //
        int i = nums.length-2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[] nums = {1,2,6,8,5,4};
        int a = 0;
    }
}

