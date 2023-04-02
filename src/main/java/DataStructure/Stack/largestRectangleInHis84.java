package DataStructure.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhang on 2017/2/6.
 */

//类似于 Container With Most Water，对每个柱子，左右扩展
public class largestRectangleInHis84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[heights.length + 1];
        h = Arrays.copyOf(heights, heights.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }


    public static  void main(String args[]){
        int[] heights = {2,1,5,6,2,3};
         int a =largestRectangleArea(heights);

    }
}
