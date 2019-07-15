package DataStructure.Array;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 7:23 PM
 * Description:
 * 一遍过 牛逼
 * 210 120
 */


public class _946_ValidateStackSequences_Stack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && (stack.peek() == popped[j])){
                j++;
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            if(stack.pop() != popped[j])
                return false;
            j++;
        }
        return true;
    }
}
