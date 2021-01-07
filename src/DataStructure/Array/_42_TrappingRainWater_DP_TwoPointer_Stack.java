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
