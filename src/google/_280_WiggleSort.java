package google;

/**
 * Created by zhang on 2018/5/29.
 */
//Given an unsorted array nums, reorder it in-place such that
// nums[0] <= nums[1] >= nums[2] <= nums[3]
public class _280_WiggleSort {
        public void wiggleSort(int[] nums) {
            for (int i = 0; i<nums.length; i++){
                if (i % 2 == 1){    // 0 1 2 3
                    if (nums[i-1] > nums[i])
                        swap(nums,i);
                }else if (i != 0 && nums[i-1]<nums[i]){
                        swap(nums,i);
                }
            }
        }
        private void swap(int[] nums, int i){
            int tmp=nums[i];
            nums[i]=nums[i-1];
            nums[i-1]=tmp;
        }
    }
