package company.Apple;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/2/8.
 */
//O(n)
//The basic idea is to maintain two heaps: a max-heap and a min-heap. The max heap stores the smaller half of all numbers while the min heap stores the larger half.
public class _295_FindMedianfromDataStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

    //  1 2 3 4 5   median 3
//
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

// Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
