package Company.Grammly;

import java.util.Stack;

/**
 * @author Luke(New Man) Zhang
 * @Date 1/30/2021 9:04 PM
 * <p>
 * Description:
 * Key Point: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294893/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
 */

public class _1047_RemoveAllAdjacentDuplicatesInString_Stack_TwoPointer {

    /**
     *
     * Time complexity : \mathcal{O}(N)O(N), where N is a string length.
     * Space complexity : \mathcal{O}(N - D)O(N−D) where D is a total length for all duplicates.
     * */

    public String removeDuplicates_noStack(String S) {
        if(S == null || S.length() == 0)
            return S;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // O(n) time O(n) space
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

    // two pointer
    /**
     * Solution 1: Two Pointers
     * i refers to the index to set next character in the output string.
     * j refers to the index of current iteration in the input string.
     *
     * Iterate characters of S one by one by increasing j.
     *
     * If S[j] is same as the current last character S[i - 1],
     * we remove duplicates by doing i -= 2.
     *
     * If S[j] is different as the current last character S[i - 1],
     * we set S[i] = S[j] and increment i++.
     * */
    public String removeDuplicates_TwoPointer(String S) {
        int i = 0, n = S.length();
        char[] ans = new char[n];

        for (int j = 0; j < n; j++, i++) {
            ans[i] = ans[j];
            if (i > 0 && ans[i - 1] == ans[i]){
                i -= 2;
            }
        }
        return new String(ans, 0, i);
    }
}
