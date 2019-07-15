package company.uber.Calculate;
import java.util.*;
/**
 * Created by zhang on 2018/1/27.
 */
//+ - * / ^ ( )
public class Calculate_plus_reduce_times_division_Pow_bracket {
    public int calculate(String s) {
        // remove spaces //这部分也可以放在下面判断，一句搞定，是空格的时候跳过
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        s = sb.toString();

        // init
        if (s == null || sb.length() == 0) return 0;
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1); map.put('-', 1);
        map.put('*', 2); map.put('/', 2);
        map.put('^', 3);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    numStack.push(num);
                    num = 0;
                }
            } else { // op or ()
                if (c == '(') {
                    opStack.push(c);
                }
                if (c == ')') {
                    while (!opStack.empty() && opStack.peek() != '(') {
                        helper(numStack, opStack);
                    }
                    opStack.pop(); // pop the '('
                }
                if (map.containsKey(c)) { // + - * / ^
                    if (opStack.empty() || opStack.peek() == '(' || map.get(c) > map.get(opStack.peek())) {
                        opStack.push(c);
                    } else {
                        while (!opStack.empty() && opStack.peek() != '(' && map.get(c) <= map.get(opStack.peek())) {
                            helper(numStack, opStack);
                        }
                        opStack.push(c);
                    }
                }
            }
        }

        while (!opStack.empty()) {
            helper(numStack, opStack);
        }
        return numStack.pop();
    }

    private void helper(Stack<Integer> numStack, Stack<Character> opStack) {
        int b = numStack.pop();
        int a = numStack.pop();
        char op = opStack.pop();
        if (op == '+') numStack.push(a + b);
        if (op == '-') numStack.push(a - b);
        if (op == '*') numStack.push(a * b);
        if (op == '/') numStack.push(a / b);
        if (op == '^') numStack.push((int)Math.pow(a, b));
    }

}
