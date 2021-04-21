package DataStructure.String;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/20/2021 10:39 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1209_RemoveAllAdjacentDuplicatesinString2_Stack {
    public static void main(String[] args){
        removeDuplicates("deeedbbcccbdaa", 3);
    }

    public static String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c){
                stack.push(1);
                sb.append(c);
            } else {
                int curCount = stack.pop();
                if (++curCount == k) {
                    sb.delete(sb.length() - k + 1, sb.length());
                } else {
                    stack.push(curCount);
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
