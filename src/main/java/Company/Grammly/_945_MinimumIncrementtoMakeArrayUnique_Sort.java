package Company.Grammly;
import java.util.*;
// SORT Time Complexity: O(Nlog⁡N)  Complexity: O(N)
public class _945_MinimumIncrementtoMakeArrayUnique_Sort {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0, taken = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                taken++;
                moves -= nums[i];
            } else {
                int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
                moves += give * (give + 1) / 2 + give * nums[i - 1];
                taken -= give;
            }
        }

        if (nums.length > 0)
            moves += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];

        return moves;
    }


    // O(N+M)
    /**
     *First count how many times each value occurs in nums.
Iterate over all possible values of x. Note that the x will never be larger than the largest value in nums plus the length of nums. For each possible value of x:
If there are 2 or more values x in nums, save the duplicate values to increment later.
If there are 0 values x in nums, then the last saved value in taken gets incremented to x. 
     * 
     * 
    */
    public int minIncrementForUnique_counting(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
         
        int[] count = new int[nums.length + maxVal];
        for (int x : nums) {
            count[x]++;
        }

        int moves = 0;
        int taken = 0;
        for (int x = 0; x < nums.length + maxVal; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                moves -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                moves += x;
            }
        }

        return moves;
    }
}
