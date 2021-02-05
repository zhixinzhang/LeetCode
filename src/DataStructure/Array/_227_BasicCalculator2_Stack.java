package DataStructure.Array;

import java.util.ArrayDeque;
import java.util.Deque;

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
 */

public class _227_BasicCalculator2_Stack {
    public static void main(String[] args){
        calculate_1("10 - 2 * 3 /4 ");
    }

    // O(n) time O(n) space
    public static int calculate_stack(String input) {
        // 1 + 2 * 3 /4 + 6 / 1 + 2
        int num = 0;
        char prev_sign = '+';
        input = input.replaceAll(" ","");
        if(input == null || input.length() == 0) return num;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i<input.length(); i ++){
            char c = input.charAt(i);
            if (Character.isDigit(c)){              //find digit
                num = num * 10 + (c -'0');
            }
            if(i == input.length() - 1 || !Character.isDigit(c)){
                if(prev_sign == '+'){
                    stack.offerLast(num);
                }else if(prev_sign == '-'){
                    stack.offerLast(-1 * num);
                }else if(prev_sign == '*'){
                    int temp = stack.pollLast();
                    stack.offerLast(temp*num);
                }else if(prev_sign == '/'){
                    int temp = stack.pollLast();
                    stack.offerLast(temp / num);
                }
                num = 0;
                prev_sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pollLast();
        }
        return  res;
    }

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
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
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
