package google.Array;
import java.util.*;
/**
 * Created by zhang on 2018/6/21.
 */
public class _739_DailyTemperatures_Stack_TwoPointer {
   // 重点是 stack里面放index
    // 75 71 69 72 76
    // 0  1  2  3 4
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
