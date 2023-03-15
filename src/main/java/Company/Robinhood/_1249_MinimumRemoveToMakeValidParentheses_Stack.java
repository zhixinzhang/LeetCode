package DataStructure.String;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-29 16:23
 * <p>
 * Description: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solution/
 * Key Point:
 */

public class _1249_MinimumRemoveToMakeValidParentheses_Stack {
    public static void main(String[] args){
        String input = "111)  (134())(((";
        minRemoveToMakeValid(input);
    }
    // use stack
    // Time complexity : O(n)O(n), where nn is the length of the input string.
    public static String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer>  stack = new Stack<>();
        Set<Integer> indexesToRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            } else if (s.charAt(i) == ')'){
                if (stack.isEmpty()){
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb.toString());
        return sb.toString();

    }

    // solution 2 :
    public String minRemoveToMakeValid_TwoParse(String s) {

        // Parse 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            } if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        // Parse 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}
