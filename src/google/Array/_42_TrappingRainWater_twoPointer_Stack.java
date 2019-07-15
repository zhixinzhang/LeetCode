package google.Array;

import java.util.Stack;

/**
 * Created by zhang on 2018/7/8.
 */
public class _42_TrappingRainWater_twoPointer_Stack {
    public int trap(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;
        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }

    public int trap_stack(int[] height) {
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
