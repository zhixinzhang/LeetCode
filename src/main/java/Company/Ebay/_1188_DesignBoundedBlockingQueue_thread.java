package Company.Ebay;

import java.util.*;

public class _1188_DesignBoundedBlockingQueue_thread {
    private int capacity;
    private Queue<Integer> queue;

    public _1188_DesignBoundedBlockingQueue_thread(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList();
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized(queue){
            while(queue.size() == capacity) {
                queue.wait();
            }

            queue.notifyAll();
            queue.offer(element);
        }
    }
    
    public int dequeue() throws InterruptedException {
        int val; 
        synchronized(queue){
            while(queue.size() == 0) {
                queue.wait();
            }

            queue.notifyAll();
            val = queue.poll();
        
        }

        return val;
    }
    
    public int size() {
        return queue.size();
    }
}
