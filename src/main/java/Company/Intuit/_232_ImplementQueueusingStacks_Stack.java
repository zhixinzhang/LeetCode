package Company.Intuit;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/23/2021 3:21 AM
 * <p>
 * Description:
 * Similar task : https://leetcode.com/problems/implement-queue-using-stacks/discuss/64284/Do-you-know-when-we-should-use-two-stacks-to-implement-a-queue
 * Key Point:
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/discuss/64284/Do-you-know-when-we-should-use-two-stacks-to-implement-a-queue\
 *
 * When there's only one thread doing the read/write operation to the stack, there will always one stack empty. However, in a multi-thread application,
 * if we have only one queue, for thread-safety, either read or write will lock the whole queue. In the two stack implementation, as long as the second stack is not empty, push operation will not lock the stack for pop.
 */

public class _232_ImplementQueueusingStacks_Stack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    /** Initialize your data structure here. */
    public _232_ImplementQueueusingStacks_Stack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (s2.isEmpty() && s1.isEmpty())  {
            return true;
        }
        return false;
    }
}
