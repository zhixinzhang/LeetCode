package company.Houzz;

/**
 * Created by zhang on 2017/12/13.
 */
public class _162_FIndPeakElement_BS {
    //linear time O(n)
    public int findPeakElement(int[] nums) {
        // linear time   1 2 3 4 1
        if(nums.length == 1) return 0;
        // 1 2 3 4 1
        for(int i = 0;i<nums.length;i++){
            if(i+1 < nums.length){
                if(nums[i] > nums[i+1]){
                    return i;
                }
            }else{
                return nums.length-1;
            }
        }
        return 0;
    }
    // bs o(logn)
    public int findPeakElement_BS(int[] nums) {
        // linear time   1 2 3 4 1
        if(nums.length == 1) return 0;
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }

        }
        return (left == nums.length - 1 || nums[left] > nums[left + 1]) ? left:right;
        }
    }
