package DataStructure.Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/4/2021 12:58 AM
 * <p>
 * Description:  https://leetcode.com/problems/basic-calculator-ii/solution/
 * Key Point:
 *
 * Scan the input string s from left to right and evaluate the expressions based on the following rules
 *
 * If the current character is a digit 0-9 ( operand ), add it to the number currentNumber.
 * Otherwise, the current character must be an operation (+,-,*, /). Evaluate the expression based on the type of operation.
 * Addition (+) or Subtraction (-): We must evaluate the expression later based on the next operation. So, we must store the currentNumber to be used later. Let's push the currentNumber in the Stack.
 * Multiplication (*) or Division (/): Pop the top values from the stack and evaluate the current expression. Push the evaluated value back to the stack.
 */

public class _227_BasicCalculator2_Stack {
    public static void main(String[] args){
        calculate_1("10 - 2 * 3 /4 ");
    }

    // O(n) time O(n) space
    public static int calculate_stack(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    /**
     * The approach works similar to Approach 1 with the following differences :
     *
     * Instead of using a stack, we use a variable lastNumber to track the value of the last evaluated expression.
     * If the operation is Addition (+) or Subtraction (-), add the lastNumber to the result instead of pushing it to the stack. The currentNumber would be updated to lastNumber for the next iteration.
     * If the operation is Multiplication (*) or Division (/), we must evaluate the expression lastNumber * currentNumber and update the lastNumber with the result of the expression. This would be added to the result after the entire string is scanned.
     *
     * Time Complexity: \mathcal{O}(n)O(n), where nn is the length of the string ss.
     *
     * Space Complexity: \mathcal{O}(1)O(1)
     *
     * 22 - 3 * 5
     * */
    public static int calculate_1(String s){
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;

        char operation = '+';
        s = s.replaceAll(" ", "");

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;           //22  -
                } else if (operation == '*') {
                    lastNumber += lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber += lastNumber / currentNumber;
                }

                operation = c;
                currentNumber = 0;
            }
        }

        result += lastNumber;
        return result;
    }
}
