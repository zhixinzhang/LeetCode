package DataStructure.String;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/15/19
 * Time: 9:56 PM
 * Description:
 */


public class _1021_RemoveOutermostParentheses_Stack {
    public static void main(String[] args){
        removeOuterParentheses("()()");
    }
    public static String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()){
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if (stack.size() == 1){
                if (c == ')')
                    stack.pop();
                else{
                    stack.push('(');
                    sb.append('(');
                }
                continue;
            }
            if (stack.size() >= 2){
                if (c == '('){
                    sb.append('(');
                    stack.push('(');
                }
                else if (c == ')'){
                    sb.append(')');
                    stack.pop();
                }
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses_nostack(String S) {
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        int open=0;

        for(char ch:S.toCharArray()){
            open += ((ch=='(')?1:-1);

            if(open==0){
                sb.append(S.substring(i+1,j));
                i=j+1;
            }
            j++;
        }

        return sb.toString();
    }
}
