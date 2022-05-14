package Company.Apple;

/**
 * Created by zhang on 2018/2/12.
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
// 重点是O（n）时间 constant space
public class _41_FirstMissingPositive_Swap {
        public int firstMissingPositive(int[] nums) {
            int res = 0;
            //[3,1,-1,2]            bucket sort
            //[2,1,-1,3]
            //[-1,1,2,3]
            //[-1,1,2,3]
            for(int i = 0; i<nums.length; i++){
                while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                    swap(nums[i]-1, i,nums);
                }
            }
            for (int i = 0;i<nums.length;i++){
                if(nums[i] != i+1)
                    return i+1;
            }
            return nums.length + 1;/* deal with when there is all positive number, or the array is empty */
        }
        private void swap(int i, int j, int[] nums){

        }
    }
