package Company.uber.Calculate;
import java.util.*;
/**
 * Created by zhang on 2018/1/27.
 */
public class _Calculate_plus_reduce_bracket {
    public int calculate(String s) {
        int len = s.length(), sign = 1, res = 0, num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue; //只要数字不会被拆开，用这个就没问题。
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == len - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    res += sign * num;
                    num = 0;
                }
            } else { // + - ( )
                if (c == '+') {
                    sign = 1;
                }
                if (c == '-') {
                    sign = -1;
                }
                if (c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                }
                if (c == ')') {
                    res = res * stack.pop() + stack.pop();
                }
            }
        }
        return res;
    }

}
