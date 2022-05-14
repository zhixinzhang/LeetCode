package DataStructure.Array;
import java.util.*;


public class _628_MaximumProductofThreeNumbers{
	    public int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);
                 // -2 -1  0  1 2 3 
         //One of the Three Numbers is the maximum value in the array.

         int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
         int b = nums[0] * nums[1] * nums[nums.length - 1];
         return a > b ? a : b;
    }
}