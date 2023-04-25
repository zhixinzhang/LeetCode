package Company.Sony;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Just use a queue where you "push to front" by pushing to back 
 * and then rotating the queue until the new element is at the front (i.e., size-1 times move the front element to the back).
 * 
*/
public class _225_ImplementStackusingQueues {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {              //  1 2 3 4 5  -> 6     6 1 2 3 4 5
        queue.add(x);
        for (int i=1; i < queue.size(); i++)
            queue.add(queue.remove());
    }

    public void pop() {
        queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
