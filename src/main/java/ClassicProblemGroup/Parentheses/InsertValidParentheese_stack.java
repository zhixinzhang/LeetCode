package ClassicProblemGroup.Parentheses;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/14/19
 * Time: 4:03 PM
 * Description:
 * 给你一个 字符串 你创建出 最短的 有效的 括弧
 *
 *   ))) - > ((()))
 *   ()()())) -> ((()()()))
 *   ((()  -> ((()))
 *
 *   遇见（ 加入到stack 和 sb里，遇见 ）查看
 * 最后检查satck
 */


public class InsertValidParentheese_stack {
    public static String buildParen(String s){
        if(s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            switch (c){
                case '(':
                    stack.push('(');
                    sb.append('(');
                    break;
                case ')':
                    if (stack.isEmpty()){
                        sb.insert(0, '(');
                        sb.append(')');
                    }else {
                        stack.pop();
                        sb.append(')');
                    }
                    break;
            }
        }
        while (!stack.isEmpty()){
            stack.pop();
            sb.append(')');
        }

        String res = sb.toString();
        return res;
    }
    public static void main(String[] args){
        buildParen("(((");
    }
}
