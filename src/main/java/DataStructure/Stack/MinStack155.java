package DataStructure.Stack;

import java.util.Stack;

/**
 * Created by zhang on 2017/2/5.
 */
public class MinStack155 {

    /** initialize your data structure here. */
    public MinStack155() {

    }

    public void push(int x) {
        s.push(x);
        int minValue = minStack.isEmpty()?x: Math.min(minStack.peek(),x);
        minStack.push(minValue);

    }

    public void pop() {
        s.pop();
        minStack.pop();

    }

    public int top() {

        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
}

/**
 * Your MinStack155 object will be instantiated and called as such:
 * MinStack155 obj = new MinStack155();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */