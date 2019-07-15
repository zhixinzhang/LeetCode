package Stack;

import java.util.Stack;

/**
 * Created by zhang on 2017/2/6.
 */
public class LongestValidParenth32 {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }




    public static void main(String args[]){
//        String s = ")()())";
        String s = "()()()((()";
        int answer = longestValidParentheses(s);
        System.out.print("");
    }
}
