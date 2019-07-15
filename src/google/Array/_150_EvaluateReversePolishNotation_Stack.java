package google.Array;

import java.util.Stack;

/**
 * Created by zhang on 2018/6/12.
 * Input: ["4", "13", "5", "/", "+"]
 Output: 6
 Explanation: (4 + (13 / 5)) = 6
 coube be negative
 */
public class _150_EvaluateReversePolishNotation_Stack {
    public static int solution(String[] tokens){
        if (tokens == null || tokens.length == 0)   return 0;
        Stack<Integer> stack = new Stack<>();
        String oper = "+-*/";
        for (String s : tokens){
            if (oper.indexOf(s) == -1){
                int curVal = 0;
                if (s.charAt(0) == '-'){
                    curVal = Integer.parseInt(s.substring(1,s.length()))*-1;
                }else
                    curVal = Integer.parseInt(s);
                stack.push(curVal);
            }else{
                char op = s.charAt(0);
                int preR = stack.pop();
                int preL = stack.pop();
                switch (op){
                    case '+' : preL += preR; break;
                    case '-' : preL -= preR; break;
                    case '*' : preL *= preR; break;
                    case '/' : preL /= preR; break;
                }
                stack.push(preL);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        solution(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }
}
