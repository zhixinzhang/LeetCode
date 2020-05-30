package XianQiao;/*
@Author: Xianqiao
@Date: 3/28/20 15:50
**/

/**
 * stack里面放内容；按序对比
 * 逐个比逐个加
 * */

import java.util.Stack;

public class _1021_Remove_Outermost_Parentheses_Stack_StringBuilder_Xianqiao {
    public String removeOuterParentheses(String S) {
        //check corner case
        if (S == null || S.length() == 0){
            return S;
        }

        char[] chars = S.toCharArray();
        Stack<Character>  stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char i: chars){
            if (i == '('){
                if (stack.empty()){
                    stack.push(i);
                } else{
                    stack.push(i);
                    sb.append('(');
                }
            } else{
                if (stack.size() == 1){
                    stack.pop();
                } else{
                    stack.pop();
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }

}
