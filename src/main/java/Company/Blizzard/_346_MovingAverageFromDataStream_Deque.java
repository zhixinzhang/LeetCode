package Company.Blizzard;

import java.util.ArrayDeque;
import java.util.Queue;

public class _346_MovingAverageFromDataStream_Deque {
    
    private final Queue<Integer> window;
    private final int maxSize;
    private double sum = 0.0;

    public _346_MovingAverageFromDataStream_Deque(int maxSize) {
        this.window = new ArrayDeque<>(maxSize + 1);
        this.maxSize = maxSize;
    }
    
    public double next(int val) {
        window.add(val);
        sum += val;
        if (window.size() > maxSize) {
            sum -= window.poll();
        }
        return sum / window.size();
    }
}
