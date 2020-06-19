package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 6/18/20 23:23
 */

import java.util.Stack;

/**  Implement a MyQueue class which implements a queue using two stacks. */
public class CCI3_4ImplementQueueUseTwoStack {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    public void push(int x) {
        input.push(x);
    }
    public void pop() {
        shift();
        output.pop();
    }
    public void peek() {
        shift();
        output.peek();
    }
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
    public void shift() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
