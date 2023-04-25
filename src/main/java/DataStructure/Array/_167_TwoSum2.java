package DataStructure.Array;

import java.util.HashMap;

/**
 * Created by zhang on 2017/9/21.
 * Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class _167_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l <= r){
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            }

            if (numbers[l] + numbers[r] > target) {
                r --;
            } else {
                l ++;
            }
        }

        return new int[]{l + 1, r + 1};
    }
}
