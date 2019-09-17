package google.String;

import java.util.Stack;

public class _1047_RemoveAllAdjacentDuplicatesInString_Stack {

    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0)
            return S;
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
