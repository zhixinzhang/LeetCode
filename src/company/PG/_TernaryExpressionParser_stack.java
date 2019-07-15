package company.PG;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhang on 2018/1/27.
 */
//Iterate the expression from tail, whenever encounter a character before '?', calculate the right value and push back to stack.
//P.S. this code is guaranteed only if "the given expression is valid" base on the requirement.
public class _TernaryExpressionParser_stack {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Deque<Character> stack = new LinkedList<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {

                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}
