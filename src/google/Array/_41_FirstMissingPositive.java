package google.Array;

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
}
