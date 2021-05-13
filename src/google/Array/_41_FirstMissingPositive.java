package google.Array;

import java.time.LocalDate;

/**
 * Created by zhang on 2018/6/19.
 * https://www.youtube.com/watch?v=jfb72FfxWKU
 *
 * bucket sort 排序  每次调换
 */
public class _41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        /* each number is at most seened twice, if while loop runs more, outer loop runs less, o(n) */
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;/* deal with when there is all positive number, or the array is empty */
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



    public int firstMissingPositive_changeNegativetoPosititve(int[] nums) {
        int n = nums.length;

        int contains = 0;
        for (int i = 0; i < n ; i++){
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }

        if (contains == 0)
            return 1;

        if (n == 1)
            return 2;

        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        for (int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);

            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        for (int i = 1; i < n; i++){
            if(nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }
}
