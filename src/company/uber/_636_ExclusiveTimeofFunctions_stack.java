package company.uber;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2018/9/18.
 * stack store log id
 * prev mean the previous timestamp
 */
public class _636_ExclusiveTimeofFunctions_stack {
    public static void main(String[] args){
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        exclusiveTime(2,logs);
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        for (String log : logs){
            String[] arr = log.split(":");
            if (arr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(arr[2]) - pre;
                }
                stack.push(Integer.parseInt(arr[0]));
                pre = Integer.parseInt(arr[2]);
            } else {
                res[stack.pop()] += Integer.parseInt(arr[2]) - pre + 1;
                pre = Integer.parseInt(arr[2]) + 1;
            }
        }
        return res;
    }
}
