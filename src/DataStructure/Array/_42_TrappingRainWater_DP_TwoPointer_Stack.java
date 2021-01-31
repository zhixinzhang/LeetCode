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
        if (height == null || height.length <= 2) {
            return 0;
        }
        int left = 0, right = height.length - 1, ans = 0;
        int leftMax = 0, rightMax = 0;


        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                left ++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right --;
            }
        }

        return ans;
    }

    /**
     *
     * We keep a stack and iterate over the array. We add the index of the bar to the stack if bar is smaller than or equal to the bar at top of stack, which means that the current bar is bounded by the previous bar in the stack.
     * If we found a bar longer than that at the top, we are sure that the bar at the top of the stack is bounded by the current bar and a previous bar in the stack, hence, we can pop it and add resulting trapped water to \text{ans}ans.
     *
     * Algorithm
     *
     * Use stack to store the indices of the bars.
     * Iterate the array:
     * While stack is not empty and \text{height[current]}>\text{height[st.top()]}height[current]>height[st.top()]
     * It means that the stack element can be popped. Pop the top element as \text{top}top.
     * Find the distance between the current element and the element at top of stack, which is to be filled. \text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
     * Find the bounded height \text{bounded\_height} = \min(\text{height[current]}, \text{height[st.top()]}) - \text{height[top]}bounded_height=min(height[current],height[st.top()])−height[top]
     * Add resulting trapped water to answer \text{ans} \mathrel{+}= \text{distance} \times \text{bounded\_height}ans+=distance×bounded_height
     * Push current index to top of the stack
     * Move \text{current}current to the next position
     *
     *
     * Time complexity: O(n)O(n).
     * Single iteration of O(n)O(n) in which each bar can be touched at most twice(due to insertion and deletion from stack) and insertion and deletion from stack takes O(1)O(1) time.
     * Space complexity: O(n)O(n). Stack can take upto O(n)O(n) space in case of stairs-like or flat structure.
     *
     * */
    public static int trap_Stack(int[] height){
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

    public static void main(String[] args){
        trap_Stack(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
