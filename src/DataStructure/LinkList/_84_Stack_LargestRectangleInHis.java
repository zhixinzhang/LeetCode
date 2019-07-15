package DataStructure.LinkList;

/**
 * Created by zhang on 2017/9/18.
 * Given n non-negative integers representing the histogram's bar
 * height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */

import java.util.Arrays;
import java.util.Stack;

/**如果用两次循环 哦O(n2) 每次循环到一个点 然后左右判断 是否能包含  这样时间复杂度 太大
 *所以用stack 而stack 重点的地方是  stack里面的数值是持续递增的 ！！ 比如2 3 12 11 不能有11
 *
 * */
public class _84_Stack_LargestRectangleInHis {
    // best solvement
    public static int largestRectangleArea_best(int[] heights) {
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

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int result = 0;
        int min_val = heights[0];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i< heights.length; i++){
            min_val = (min_val>heights[i])?min_val:heights[i];
            int value = calculate(i,heights);
            result = (value>result)?value:result;
        }
        if(min_val*heights.length > result){
            result = min_val*heights.length;
        }
        return result;
    }
    public static int calculate(int i, int[] heights){
        //每个柱子左右扫描
        int val = heights[i];
        int nextPointer = i+1;
        int prePointer = i-1;
        if (nextPointer < heights.length){
            while (heights[nextPointer] >= heights[i]){
                val = val + heights[i];
                nextPointer ++;
                if (nextPointer == heights.length){
                    break;
                }
            }
        }
        if (prePointer >= 0){
            while (heights[prePointer] >= heights[i]){
                val = val + heights[i];
                prePointer --;
                if (prePointer < 0){
                    break;
                }
            }
        }
        System.out.println("cs   " + i  + "value  " + val);
        return val;
    }
    public static void main(String args[]){
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {12,11,10,9,8,7,6,5,4,3,2,1};
        int result = largestRectangleArea_best(heights);
//        int result = largestRectangleArea(heights);
    }

}
