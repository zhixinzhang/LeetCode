package DataStructure.Array;
import java.util.*;

public class _682_BaseballGame_stack{
    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= stack.pop();
            } else if (op.equals("D")) {
                int curr = stack.peek() * 2;
                sum += curr;
                stack.push(curr);
            } else if (op.equals("+")) {
                int tmp = stack.pop();
                int curr = tmp + stack.peek();
                sum += curr;
                stack.push(tmp);
                stack.push(curr);
            } else {
                int curr = Integer.valueOf(op);
                sum += curr;
                stack.push(curr);
            }
        }
        return sum;
    }
}