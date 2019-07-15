package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2017/2/7.
 */
public class ImplementStckUsingQue225 {

    /** Initialize your data structure here. */
    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();
    public void MyStack() {


    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public void pop() {
        while (q1.size()>1){
            q2.offer(q1.poll());
        }
        q1.poll();
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    /** Get the top element. */
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int top = q1.peek();
        q2.offer(q1.poll());

        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;

        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
