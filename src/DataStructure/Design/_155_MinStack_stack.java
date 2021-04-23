package DataStructure.Design;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/23/2021 12:05 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _155_MinStack_stack {
    Stack<int[]> stack;
    /** initialize your data structure here. */
    public _155_MinStack_stack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(new int[]{val, val});
            return;
        }

        int min = stack.peek()[1];
        stack.push(new int[]{val, Math.min(val, min)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
