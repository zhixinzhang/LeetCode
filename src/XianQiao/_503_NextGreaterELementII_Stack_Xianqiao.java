package XianQiao;/*
@Author: Xianqiao
@Date: 3/25/2020 15:22
**/

import java.util.Arrays;
import java.util.Stack;
/**
 * circularly循环一个数组，可用for (int i = 0; i < n * 需要循环几遍; i++) {循环nums[i % n])}
 * 灵活运用stack先进后出的性质，一个坐标数与按顺序排列的其余符合条件的数对比
 *
 * */
public class _503_NextGreaterELementII_Stack_Xianqiao {
    public void main(Integer[] args) {
        int[] nums = new int[]{100,1,11,1,120,111,123,1,-1,-100};
        int[] result = nextGreaterElements(nums);
    }

    /**
     * {100,1,11,1,120,111,123,1,-1,-100}
     * n = 10; i = 10
     * res = [120,11,120,120,123,123,-1,100,100,100]
     * stack []
     * */


    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                //前面有需要找最大值的数，且这个值前面所有比这个数小的、需要找最大值的数都会被弹出并在结果替换成当前值
                res[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }
}
