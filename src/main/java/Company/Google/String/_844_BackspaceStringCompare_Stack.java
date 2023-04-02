package Company.Google.String;

import java.util.Stack;

/**
 * Created by zhang on 2018/6/27.
 * Stack 12 ms  O(n) space O(n) time
 * StringBuilder O(n) O(1)  10 ms
 */
public class _844_BackspaceStringCompare_Stack {
    public static boolean backspaceCompare(String S, String T) {
        if(S.equals(T)) return true;
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        handle(s1,S);
        handle(s2,T);
        if(s1.equals(s2))
            return true;
        else
            return false;
    }
    public static void handle(Stack<Character> stack, String s){
        for(int i = 0; i<s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == '#')
                stack.pop();
            else if (stack.isEmpty() && s.charAt(i) == '#')
                continue;
            else
                stack.push(s.charAt(i));
        }
    }

    public static boolean backspaceCompare_(String S, String T) {
        if(S.equals(T)) return true;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        handle(sb1,S);
        handle(sb2,T);

        if(sb1.toString().equals(sb2.toString()))
            return true;
        else
            return false;
    }
    public static void handle(StringBuilder sb, String s){
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '#')
                count++;
            else if(count > 0)
                count--;
            else if(count == 0)
                sb.append(s.charAt(i));
        }
    }


    public static void main(String[] args){
//        backspaceCompare("ab#c","ad#c");
        backspaceCompare_("ab#c","ad#c");
    }
}
