package company.PG;
/**
 * Created by zhang on 2018/1/27.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
/**
 * 本题其实是Maximum Subarray Sum问题的延伸，不同的是这里需要考虑元素的符号。
 DP的四要素
 状态：

 max_product[i]: 以nums[i]结尾的max subarray product
 min_product[i]: 以nums[i]结尾的min subarray product
 方程：

 max_product[i] = getMax(max_product[i-1] * nums[i], min_product[i-1] * nums[i], nums[i])
 min_product[i] = getMin(max_product[i-1] * nums[i], min_product[i-1] * nums[i], nums[i])
 初始化：

 max_product[0] = min_product[0] = nums[0]
 结果：

 每次循环中 max_product[i] 的最大值
 *
 * */


public class _152_MaximumProductSubarray_DP {
    //DataStructure.DP, with O(n) space, O(n) time
    public int maxProduct(int[] nums) {

        int[] max = new int[nums.length]; // maximum product ending with nums[i]
        int[] min = new int[nums.length]; // minimum product ending with nums[i]

        max[0] = min[0] = nums[0];
        int result = max[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) { // 区分nums[i]的符号
                max[i] = Math.max(max[i], nums[i] * max[i - 1]);
                min[i] = Math.min(min[i], nums[i] * min[i - 1]);
            } else {
                max[i] = Math.max(max[i], nums[i] * min[i - 1]);
                min[i] = Math.min(min[i], nums[i] * max[i - 1]);
            }
            result = Math.max(max[i], result);
        }

        return result;
    }

    //DataStructure.DP, improved, with O(1) space, O(n) time
    public int maxProduct_improve(int[] nums) {
        int result, currentMax, currentMin;
        result = currentMax = currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(temp * nums[i], currentMin * nums[i]));

            result = Math.max(currentMax, result);
        }

        return result;
    }
}
