package DataStructure.Array;

import java.util.Stack;

/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/6 21:45
 * Link :
 * Description: https://leetcode.com/problems/trapping-rain-water/solution/
 * https://leetcode.com/problems/trapping-rain-water/discuss/409175/Java-Detailed-Explanations-and-Illustrations-(divide-and-conquer-DP-two-pointers)
 */
public class _42_TrappingRainWater_DP_TwoPointer_Stack {


    //
    /**
     * Algorithm : DP
     * O(n) time, O (n) space
     * Find maximum height of bar from the left end upto an index i in the array \text{left\_max}left_max.
     * Find maximum height of bar from the right end upto an index i in the array \text{right\_max}right_max.
     * Iterate over the \text{height}height array and update ans:
     * Add \min(\text{left\_max}[i],\text{right\_max}[i]) - \text{height}[i]min(left_max[i],right_max[i])−height[i] to \text{ans}ans
     *
     * */
    public int trap_DP(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; ++i, --j) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int ans = 0;

        for (int k = 1; k < n - 1; ++k) { // do not consider the first and the last places
            int water = Math.min(leftMax[k - 1], rightMax[k + 1]) - height[k];
            ans += (water > 0) ? water : 0;
        }

        return ans;
    }


    /**
     * Algorithm : Two Pointers
     * O(n), O(1)
     * https://segmentfault.com/a/1190000004594606
     * 双指针法的思想：先找到左右两边的第一个峰值作为参照位，然后分别向后（向前）每一步增加该位与参照位在这一位的差值，加入sum，直到下一个峰值，\
     * 再更新为新的参照位。这里有一个需要注意的地方，为什么要先计算左右两个峰值中较小的那个呢？因为在两个指针逼近中间组成最后一个积水区间时，要用较短边计算。
     * */
    public int trap_TwoPointer(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;

        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }

                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }

                --right;
            }
        }

        return ans;
    }

    public int trap_Stack(int[] height){
        int len = height.length;
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                int tmp = stack.pop();
                if (!stack.isEmpty()) {
                    water += (Math.min(height[stack.peek()],height[i])-height[tmp])*(i-stack.peek()-1);
                }
                i--;
            }
        }
        return water;
    }
}
