package company.ForUsAll;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/5/19
 * Time: 7:30 PM
 * Description:
 */


public class InsertToValidParentheses {
    public static void main(String[] args){
        fixParen("(()()((()");
    }
    // ()()))) ->
    public static String fixParen(String s){
        if (s == null || s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++){
            char c = cs[i];
            if (c == ')' && stack.isEmpty()){
                sb.insert(0, '(');
                sb.append(')');
            }
            else if (c == ')' && stack.peek() == '('){
                sb.append(')');
                stack.pop();
            }
            else if (c == '('){
                sb.append('(');
                stack.push('(');
            }
        }
        while (!stack.isEmpty()){
            stack.pop();
            sb.append(')');
        }

        StringBuilder sbb = new StringBuilder();
        sb.append(0);
        return sbb.toString();
    }
}
