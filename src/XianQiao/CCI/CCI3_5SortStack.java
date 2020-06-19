package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 6/18/20 23:38
 */

import java.util.Stack;

/** Write a program to sort a stack such that the smallest items are on the top. You can use an
 * additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty. */

public class CCI3_5SortStack {
    public void sort(Stack<Integer> stack1) {
        Stack<Integer> stack2 = new Stack<>();

        while (!stack1.isEmpty()) { //as long as stack1 is not empty, keep comparing and sorting.
            int temp = stack1.pop();
            while (!stack2.isEmpty() && temp < stack2.peek()) {
                //if there are integers that can be compared and the current integer is smaller.
                stack1.push(stack2.pop())
            }
            stack2.push(temp);
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
