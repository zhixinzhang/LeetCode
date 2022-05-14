package DataStructure.String;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/14/19
 * Time: 12:04 AM
 * Description:
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/247626/JavaPythonC%2B%2B-Stack-Solution-O(N)
 */


public class _1003_CheckIfWordIsValidAfterSubstitutions_stack {
    public boolean isValid(String S) {
        while(S.indexOf("abc")!=-1)
        {
            S=S.replaceAll("abc","");
        }
        return S.equals("");
    }

//    Solution 2
//    Keep a stack, whenever meet 'c',
//    pop a and b at the end of stack.
//            Otherwise return false.

    public boolean isValid_stack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
