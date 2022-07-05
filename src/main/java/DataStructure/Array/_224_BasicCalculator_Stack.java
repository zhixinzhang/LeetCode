package DataStructure.Array;

import java.util.Stack;

/** + - ( )
 * Created by zhang on 2018/1/17.
 */
// https://leetcode.com/problems/basic-calculator/discuss/62351
// data structure stack
//
public class _224_BasicCalculator_Stack {
    public static void main(String[] args){
        calculate("(1+(4+5+2)-3)+(6+8)");
    }
    public static int  calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sign = 1;    // plus or reduce
        int prev = 0;   // current value
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(prev);
                stack.push(sign);
                prev = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                prev = stack.pop() * prev + stack.pop();
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + Character.getNumericValue(s.charAt(i++));
                }
                prev = prev + sign * num;
                i -= 1;
            }
        }
        return prev;
    }

    // https://leetcode.com/problems/basic-calculator/solution/
    public int calculate_answer(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
