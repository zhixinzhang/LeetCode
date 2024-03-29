package Company.Wepay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
 * 
*/
public class _150_EvaluateReversePolishNotation_Stack {
    public static void main(String[] args){
        // evalRPN(new String[]{"2","1","+","3","*"});
        // evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        evalRPN(new String[]{"a","13","5","/","+"});
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Set<String> signs = new HashSet<>();
        signs.addAll(Arrays.asList("+", "-", "*", "/", "^"));
        int ans = 0;
        Stack<Integer> values = new Stack<>();
        for (String token : tokens){
            if (signs.contains(token)) {
                int preVal2 = values.pop();
                int preVal1 = values.pop();
                int newVal = doMath(token, preVal1, preVal2);
                values.add(newVal);
            } else {
                try {
                    int val = Integer.parseInt(token);
                    values.add(val);
                } catch (Exception e) {
                    System.out.println(e.getCause());
                    break;
                }
                
                
            }
        }

        ans = values.peek();
        return ans;
    }

    public static int evalRPN_Invalid(String[] tokens) throws Exception {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Set<String> signs = new HashSet<>();
        signs.addAll(Arrays.asList("+", "-", "*", "/", "^"));
        int ans = 0;
        Stack<Integer> values = new Stack<>();
        for (String token : tokens){
            if (signs.contains(token)) {
                int preVal2 = values.pop();
                int preVal1 = values.pop();
                int newVal = doMath(token, preVal1, preVal2);
                values.add(newVal);
            } else {
                int val = helper(token);
                values.add(val);                
            }
        }

        ans = values.peek();
        return ans;
    }

    private static int doMath(String sign, int val1, int val2){
        if (sign == "*") {
            return val1 *= val2;
        } else if (sign == "+"){
            return val1 += val2;
        } else if (sign == "-") {
            return val1 -= val2;
        } else if (sign == "/"){
            return val1 /= val2;
        } else if (sign == "^"){
            return (int)Math.pow(val1, val2);
        }
        return 0;
    }

    private static int helper(String token) throws Exception{
        char[] chars = token.toCharArray();
        if (chars.length > 1 && chars[0] == '0') {
            throw new Exception("invalid input");
        }
        int val = 0;
        for (int i = 0 ; i < chars.length; i++){
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                int curVal = c - '0';
                val *= 10;
                val += curVal;
            } else {
                throw new Exception("invalid input");
            }
        }

        return val;
    }
}
