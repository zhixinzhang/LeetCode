package Company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/27.
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class _155_MinStack_stack {
    /** initialize your data structure here. */
    private Stack<Element> stack = new Stack<>();

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(new Element(x,x));
        }
        else {
            stack.push(new Element(x,x<getMin()?x:getMin()));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek().x;
        }
        return -1;
    }

    public int getMin() {
        if(!stack.isEmpty()) {
            return stack.peek().min;
        }
        return -1;
    }

    private class Element {
        private int x;
        private int min;
        Element(int x,int min) {
            this.x = x;
            this.min = min;
        }
    }
}
