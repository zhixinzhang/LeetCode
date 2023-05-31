package Company.Wepay;

import java.util.HashMap;
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

    // Hash table that takes care of the mappings.
    private static HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public void Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public static boolean isValid_map(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }


    //
    public static void main(String[] args){
        System.out.println( solution("(())(())"));
        System.out.println( solution("())"));

    }

    private static boolean solution(String s){
        if (s == null || s.length() == 0)
            return true;

        int leftP = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                leftP++;
            } else if (s.charAt(i) == ')'){
                if (leftP >= 1) {
                    leftP --;
                } else
                    return false;
            }
        }

        return leftP == 0;
    }
}
