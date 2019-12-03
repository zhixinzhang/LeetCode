package XianQiao;

import java.util.Stack;

public class Parentheses_Stack {
    public static boolean isPareValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (stack.empty()) {
                stack.push(chars[i]);
            } else {
                char temp = stack.peek();
                if (temp == '{' && chars[i] == '}') {
                    stack.pop();
                } else if (temp == '[' && chars[i] == ']') {
                    stack.pop();
                } else if (temp == '(' && chars[i] == ')') {
                    stack.pop();
                } else {
                        if (chars[i] != '(' && chars[i] != '{' && chars[i] != '['){
                            return false;
                        }

                    stack.push(chars[i]);
                }
            }

        }
        return stack.empty();
    }

    public static void main(String[] args){
        isPareValid("((({{([}}[][}})))");
    }
}
