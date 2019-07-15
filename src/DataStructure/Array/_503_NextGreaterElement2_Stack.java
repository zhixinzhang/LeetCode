package DataStructure.Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/5/19
 * Time: 2:55 PM
 * Description:
 */


public class _503_NextGreaterElement2_Stack {
    public int[] nextGreaterElements(int[] A) {
        if(A == null || A.length == 0) return A;
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }
}
