package DataStructure.Array;

//给定数组，和整数K，计数数组中所有满足元素乘积小于K的连续子数组的个数。

//该题目主要的解题思路是寻找每步相同的计数规律。
//按照一般的思维，要想记录连续子数组需要从左向右遍历数组。
//这里最重要的就是处理乘积大于K的情况，需要丢弃最前面的元素，那么说明需要有一个指针记录最前面元素的位置。
//在不大于K的情况下，则累加每次加入新元素后子数组的个数。
public class _713_SubarrayProductLessThanK_TwoPointer{
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return 0;
        if ( k <= 1) return 0;

        int n = nums.length;
        long p = 1l;
        int i = 0, total = 0;
        for (int j = 0; j < n; j++){
            p *= nums[j];
            while (p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
        }

        return total;
        
    }
}