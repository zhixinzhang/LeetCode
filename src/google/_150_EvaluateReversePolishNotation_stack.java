package google;

import java.util.Stack;

/**
 * Created by zhang on 2018/5/9.
 */
// use the stack
// when we meet the operator char we pop
// we meet num we push
public class _150_EvaluateReversePolishNotation_stack {
        public static int evalRPN(String[] tokens) {
            if (tokens == null || tokens.length == 0)   return 0;
            if(tokens.length == 1)  return Integer.parseInt(tokens[0]);
            String op = "+-*/";
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i<tokens.length; i++){
                while (op.indexOf(tokens[i]) == -1){
                    stack.push(Integer.parseInt(tokens[i++]));
//                    stack.push(DataStructure.Integer.parseInt(tokens[i++]));
                }
                int x = stack.pop();
                int y = stack.pop();
                switch (tokens[i]){
                    case "+" : y += x;break;
                    case "-" : y -= x;break;
                    case "*" : y *= x;break;
                    case "/" : y /= x;break;
                }
                stack.push(y);
            }
            return stack.pop();
        }
        public static void main(String[] args){
            evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        }
    }
