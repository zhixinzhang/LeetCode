package Company.PG;
/**
 * Created by zhang on 2018/1/
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]
 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 // 创建的array[....] 每个位置是之前位置的总和
 */
public class _303_RangeSumQueryImmutable {
    int[] array;
    // 重写构造方法
    public _303_RangeSumQueryImmutable(int[] nums) {
        if(nums.length > 0) {
            array = new int[nums.length];
            array[0] = nums[0];
            for(int i = 1; i < nums.length; ++i) {
                array[i] = array[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j > array.length) {
            return 0;
        }
        if (i == 0) {
            return array[j];
        }
        return array[j] - array[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 5;
        _303_RangeSumQueryImmutable obj = new _303_RangeSumQueryImmutable(nums);
        int param_1 = obj.sumRange(i,j);
        System.out.println(param_1);
    }
}
