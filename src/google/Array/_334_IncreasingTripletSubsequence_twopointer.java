package google.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/27/19
 * Time: 2:58 PM
 * Description:
 * O(n) time O(1) space
 */


public class _334_IncreasingTripletSubsequence_twopointer {
    public boolean increasingTriplet(int[] nums) {
        // 4 5 3 2 1 6 7
        // 10 9 8 3 2 4 5 1
        if(nums == null || nums.length <= 2)
            return false;
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
}
