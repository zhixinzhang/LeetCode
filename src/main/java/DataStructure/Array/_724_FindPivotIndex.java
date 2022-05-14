package DataStructure.Array;

/**
 * Created by zhang on 2018/5/5.
 */
public class _724_FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }

        return -1;
    }
    public  static void main(String[] args){
        pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }
}
