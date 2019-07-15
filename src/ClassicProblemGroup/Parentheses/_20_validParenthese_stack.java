package ClassicProblemGroup.Parentheses;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/14/19
 * Time: 4:02 PM
 * Description:
 */


public class _20_validParenthese_stack {
    public static boolean isValid(String s) {
        // ( [ {  push bracket in stack
        // ) ] } . pop and compare
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    else
                        stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    else
                        stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    else
                        stack.pop();
                    break;
                default:
                    stack.push(c);

            }
        }
        return stack.isEmpty();
    }
}
