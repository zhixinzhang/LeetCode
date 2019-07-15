package Stack;

import java.util.Stack;

/**
 * Created by zhang on 2017/9/26.
 */
/**善用stack 的FILO
 * */
public class _20_StackValidParenthese {
    public boolean isValid(String s) {
        if (s.length() == 0){
            return  true;
        }
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0 ;i<arr.length;i++){
            if (stack.size() == 0){
                stack.push(arr[i]);
            }else if (stack.peek() == '{' && arr[i] == '}'){
                stack.pop();
            }else if (stack.peek() == '[' && arr[i] == ']'){
                stack.pop();
            }else if (stack.peek() == '(' && arr[i] == ')'){
                stack.pop();
            }else{
                stack.push(arr[i]);
            }
        }
        if (stack.size() != 0)
            return false;
        return true;
    }
}
