package DataStructure.Array;

/**
 *  https://leetcode.com/problems/wiggle-sort/solutions/71724/java-solution-with-explanation-thoughts/
 * The basic idea is to make sure that every odd position is greater than (or equal to) its two adjacent even postions. For example, if the current odd position is i, 
 * then we need to make sure the nums[i-1] <= nums[i] and nums[i+1] <= nums[i]. If you do that for the entire array, 
 * then the result will satisfy Wiggle Sort's requirement. (It's kind of like a greedy solution IMO, where local optimum leads to global optimum).
 * 
*/
public class _280_WiggleSort_Swap {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i-1] < nums[i]) {  // at even index, check if it's greater than previous number
                swap(nums, i-1, i);
            }
            if (i % 2 != 0 && nums[i-1] > nums[i]) {  // at odd index, check if it's smaller than previous number
                swap(nums, i-1, i);
            }
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
